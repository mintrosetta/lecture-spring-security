package com.eazybutes.eazybytes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.AccountTransaction;
import com.eazybutes.eazybytes.repository.AccountTransactionRepository;

@RestController
@RequestMapping("balances")
public class BalanceController {

	private AccountTransactionRepository accountTransactionRepository;

	public BalanceController(AccountTransactionRepository accountTransactionRepository) {
		this.accountTransactionRepository = accountTransactionRepository;
	}
	
    @GetMapping("")
    public List<AccountTransaction> getAccount(@RequestParam("id") Integer id) {
        List<AccountTransaction> transactions = this.accountTransactionRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        
    	return transactions;
    }


}
