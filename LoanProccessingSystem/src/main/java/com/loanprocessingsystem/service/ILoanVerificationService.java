package com.loanprocessingsystem.service;

import com.loanprocessingsystem.entities.LoanApplication;
import com.loanprocessingsystem.exception.InvalidLoanApplicationException;

/*Loan Verification Manager Service
 *ILoanVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing 
 * */

public interface ILoanVerificationService  {
	
public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

	}
