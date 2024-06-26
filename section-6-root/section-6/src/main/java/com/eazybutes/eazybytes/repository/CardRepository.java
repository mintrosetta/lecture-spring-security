package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybutes.eazybytes.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
	List<Card> findByCustomerId(int customerId);
}
