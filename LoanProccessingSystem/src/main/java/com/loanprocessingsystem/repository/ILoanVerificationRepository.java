package com.loanprocessingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanprocessingsystem.entities.LoanApplication;

@Repository
public interface ILoanVerificationRepository extends JpaRepository<LoanApplication, Integer>{


}
