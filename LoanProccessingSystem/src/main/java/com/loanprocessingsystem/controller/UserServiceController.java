package com.loanprocessingsystem.controller;

import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanprocessingsystem.entities.Admin;
import com.loanprocessingsystem.entities.LoanVerificationManager;
import com.loanprocessingsystem.entities.User;
import com.loanprocessingsystem.service.IUserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/* User Service Controller
 * User Service Controller contains various methods to interact with the loan user table
 * "/loan" is to check the loan page 
 * "/adduserasadmin" is to add admin to the user table
 * "/adduseraslandofficer" to add land officer to the user table
 * "/adduserasfinanceofficer" to add finance officer to the user table
 * "/signin" to sign in into the account
 * "/signout" to sign out of the account
 * */


@Validated
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/user")
@ApiModel(value = "User Service Rest Controller" , description = "Holds all APIs related to the User Service")
public class UserServiceController {
	Logger logger = Logger.getLogger(LoanAgreementController.class.getName());	
	
	public UserServiceController() {
		logger.log(Level.INFO,"----->Inside User Service Controller Working!");
	}
	
	@Autowired
	IUserService userService;
	
	@ApiOperation(value = "POST mapping to add new user as admin to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/adduserasadmin")
	public Admin addNewUser(@RequestBody  @Valid Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	
	
	
	
	@ApiOperation(value = "POST mapping to add new user as financeofficer to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/adduserasfinanceofficer")
	public LoanVerificationManager addNewUser(@RequestBody  @Valid LoanVerificationManager loanVerificationOfficer) {
		this.userService.addNewUser(loanVerificationOfficer);
		return loanVerificationOfficer;
		
	}
	
	@ApiOperation(value = "POST mapping to add new user to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signin")
	public User signIn(@RequestBody  @Valid User user) {
		this.userService.signIn(user);
		return user;
		
	}

	@ApiOperation(value = "POST mapping to logout from the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signout")
	public User signOut(@RequestBody  @Valid User user) {
		this.userService.signOut(user);
		return user;
		
	}
}
