package com.loanprocessingsystem.LoanVerificationServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.loanprocessingsystem.entities.LoanApplication;
import com.loanprocessingsystem.entities.Status;
import com.loanprocessingsystem.exception.InvalidLoanApplicationException;
import com.loanprocessingsystem.repository.ILoanApplicationRepository;
import com.loanprocessingsystem.service.ILoanVerificationServiceImpl;

/* Loan Verification Service Testing
 * Testing the status update of loan verification by passing status of loan application
 * */


@SpringBootTest
public class LoanVerificationServiceTest {

	ILoanApplicationRepository loanApplicationRepo;

	private static ILoanVerificationServiceImpl financeservice;

	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		loanApplicationRepo = mock(ILoanApplicationRepository.class); // test through approach 2
		financeservice = new ILoanVerificationServiceImpl(loanApplicationRepo); // Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("Test to update Status")
	void testUpdateStatus() throws InvalidLoanApplicationException {
		LoanApplication loanApplication = new LoanApplication(1,Status.APPROVED);

		
		Optional<LoanApplication> optionalApplication=Optional.of(loanApplication);
		LoanApplication updateLoanApplication = new LoanApplication(1,Status.PENDING);
		when(loanApplicationRepo.findById((long) 1)).thenReturn(optionalApplication);
		when(loanApplicationRepo.save(updateLoanApplication)).thenReturn(updateLoanApplication);
		LoanApplication test_loanapplication=financeservice.updateStatus(updateLoanApplication);
		assertEquals(updateLoanApplication,test_loanapplication);
	}

}