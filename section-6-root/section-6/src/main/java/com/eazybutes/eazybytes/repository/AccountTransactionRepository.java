package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybutes.eazybytes.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, String> {
	List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
