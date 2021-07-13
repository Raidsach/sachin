package com.loanprocessingsystem.service;

import java.util.Optional;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanprocessingsystem.entities.LoanApplication;
import com.loanprocessingsystem.exception.InvalidLoanApplicationException;
import com.loanprocessingsystem.repository.ILoanApplicationRepository;

/*Loan Verification Manager Service
 *ILoanVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 * */

@Service
public class ILoanVerificationServiceImpl implements ILoanVerificationService {

	@Autowired
	ILoanApplicationRepository fApplicationRepository;

	public ILoanVerificationServiceImpl(ILoanApplicationRepository applicationRepository) {
		super();
		this.fApplicationRepository = applicationRepository;
	}

	@Override
	@Transactional
	// method to check loan application is present in the DB, update if application
	// is present else invoke Exception class
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = fApplicationRepository.findById(loanApplication.getApplicationId());
		if (optional.isPresent()) {
			fApplicationRepository.save(loanApplication);
			return loanApplication;
		} else {
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");// returns updated loan
																								// application

		}
	}

}