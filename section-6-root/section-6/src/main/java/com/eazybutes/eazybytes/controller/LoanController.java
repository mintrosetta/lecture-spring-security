package com.eazybutes.eazybytes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Loan;
import com.eazybutes.eazybytes.repository.LoanRepository;

@RestController
@RequestMapping("loans")
public class LoanController {

	private LoanRepository loanRepository;

	public LoanController(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}
	
    @GetMapping("")
    public List<Loan> getAccount(@RequestParam("id") int id) {
    	List<Loan> loans = this.loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        return loans;
    }

}
