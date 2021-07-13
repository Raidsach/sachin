package com.loanprocessingsystem.exception;

public class LoanVerificationException extends Exception {

	public LoanVerificationException() {
		super();

	}

	public LoanVerificationException(String message, Throwable cause) {
		super(message, cause);

	}

	public LoanVerificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public LoanVerificationException(String message) {
		super(message);

	}

	public LoanVerificationException(Throwable cause) {
		super(cause);

	}

}
