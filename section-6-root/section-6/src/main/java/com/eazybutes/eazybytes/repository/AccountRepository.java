package com.eazybutes.eazybytes.repository;

import org.springframework.data.repository.CrudRepository;

import com.eazybutes.eazybytes.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	Account findByCustomerId(int customerId);
}
