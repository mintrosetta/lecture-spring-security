package com.eazybutes.eazybytes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybutes.eazybytes.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {

	
}
