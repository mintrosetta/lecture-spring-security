package com.eazybutes.eazybytes.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eazybutes.eazybytes.model.Customer;
import com.eazybutes.eazybytes.repository.CustomerRepository;

@Service
public class EasyBankUserDetails implements UserDetailsService {

    private CustomerRepository customerRepository;

    public EasyBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = null;
        Optional<Customer> customer = this.customerRepository.findByEmail(username);

        if (!customer.isPresent()) {
            throw new UsernameNotFoundException("User detail not found for user: " + username);
        }

        Customer resultCustomer = customer.get();

        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(resultCustomer.getRole()));
        
        return new User(username, resultCustomer.getPwd(), authorities);
    }

}
