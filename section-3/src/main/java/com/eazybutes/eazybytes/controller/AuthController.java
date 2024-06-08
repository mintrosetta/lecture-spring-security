package com.eazybutes.eazybytes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public AuthController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @GetMapping("")
    public String getTest() {
        return "Hello auth";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            Optional<Customer> existCustomer = this.customerRepository.findByEmail(customer.getEmail());

            if (existCustomer.isPresent()) {
                throw new Exception("Email has already to use");
            } else {
                this.customerRepository.save(customer);
            }

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
