package com.loanprocessingsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanprocessingsystem.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	

}
