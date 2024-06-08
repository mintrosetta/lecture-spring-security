package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eazybutes.eazybytes.model.Customer;

@Repository
public interface UserRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c.* FROM Customer c WHERE c.email = :email")
    List<Customer> findByEmail(@Param("email") String email);

}
