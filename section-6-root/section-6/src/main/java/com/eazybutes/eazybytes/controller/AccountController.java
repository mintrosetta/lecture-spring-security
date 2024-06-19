package com.eazybutes.eazybytes.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Account;
import com.eazybutes.eazybytes.repository.AccountRepository;

@RestController
@RequestMapping("accounts")
public class AccountController {

	private AccountRepository accountRepository;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
    @GetMapping("")
    public Account getAccountDetail(@RequestParam("id") Long id) {
    	Optional<Account> accountOptional = this.accountRepository.findById(id);
        
    	if (accountOptional.isPresent()) return null;
    	
    	return accountOptional.get();
    }

}
