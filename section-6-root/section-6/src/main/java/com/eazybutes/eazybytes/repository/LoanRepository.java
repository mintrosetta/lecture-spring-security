package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybutes.eazybytes.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {
	List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
