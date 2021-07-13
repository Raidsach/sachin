package com.loanprocessingsystem.controller;

import java.util.logging.Level; 
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanprocessingsystem.entities.LoanApplication;
import com.loanprocessingsystem.exception.InvalidLoanApplicationException;
import com.loanprocessingsystem.service.ILoanVerificationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/*  Loan Verification Officer REST Controller
 *  Loan Verification controller contain a single method to alter the loan application
 *  "/loan" is to check the loan page 
 *  "/Loancestatus"is a method the update the status of the loan application along 
 *  with other field officer find important to change 
 * */

@Validated
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/loanverify")
@ApiModel(value="Loan Verification Controller", description = "Holds all APIs related to the Loan")
public class LoanVerificationController {
	Logger logger = Logger.getLogger(LoanVerificationController.class.getName());
	@Autowired
	private ILoanVerificationService service;
	
	//Method to check the working of rest controller in the console
	public LoanVerificationController() {
		logger.log(Level.INFO,"-----> Loan Rest Controller Working!");
		
	}
	
	//Method to check the connection with the webservice
	@GetMapping("/Loan")
	public String LoanRequest() {
		return "Welcome : Loan Processing System"; //returns String value
	}

	
	@ApiOperation(value="PUT mapping for the Loan Verification to update the status of application",response=LoanVerificationController.class)
	@PutMapping("/loanstatus")
	//Method to update the status of application and loan amount if approved, passes the parameters of application class
	public LoanApplication updateStatus(@RequestBody @Valid LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.service.updateStatus(loanapplication);  //returns the updated loan application
	}

}