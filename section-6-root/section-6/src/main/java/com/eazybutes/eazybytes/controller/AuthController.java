package com.eazybutes.eazybytes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Customer;
import com.eazybutes.eazybytes.repository.CustomerRepository;

@RestController
@RequestMapping("auths")
public class AuthController {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    public AuthController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public Customer getUserDetail(Authentication authentication) {
    	Optional<Customer> customerOptional = this.customerRepository.findByEmail(authentication.getName());
        
    	if (customerOptional.isPresent())  return null;
    	
    	return customerOptional.get();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            Optional<Customer> existCustomer = this.customerRepository.findByEmail(customer.getEmail());

            if (existCustomer.isPresent()) {
                throw new Exception("Email has already to use");
            } else {
                String passwordHashed = this.passwordEncoder.encode(customer.getPwd());

                customer.setPwd(passwordHashed);

                this.customerRepository.save(customer);
            }

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
