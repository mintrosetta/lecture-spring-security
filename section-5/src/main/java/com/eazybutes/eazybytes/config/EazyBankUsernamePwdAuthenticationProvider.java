package com.eazybutes.eazybytes.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eazybutes.eazybytes.model.Customer;
import com.eazybutes.eazybytes.repository.CustomerRepository;

// custom authentication logic for web application
@Configuration
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    public EazyBankUsernamePwdAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // can custom authentication logic in this method, ex. check verify email
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        Optional<Customer> optionalCustomer = this.customerRepository.findByEmail(email);
        
        if (!optionalCustomer.isPresent()) {
            throw new UsernameNotFoundException("Account not foumd");
        }

        Customer customer = optionalCustomer.get();

        if (!this.passwordEncoder.matches(password, customer.getPwd())) {
            throw new BadCredentialsException("Invalid password");
        }

        List<GrantedAuthority> authoriries = new ArrayList<>();
        authoriries.add(new SimpleGrantedAuthority(customer.getRole()));

        return new UsernamePasswordAuthenticationToken(email, password, authoriries);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
