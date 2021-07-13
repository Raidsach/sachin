package com.loanprocessingsystem;

import java.util.logging.Level; 
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@SpringBootApplication
public class LoanprocessingsystemApplication {
	

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(LoanprocessingsystemApplication.class.getName());
		SpringApplication.run(LoanprocessingsystemApplication.class, args);
		logger.log(Level.INFO, "-------> SWAGGER Working OK!");
	}

	@Bean
	public Docket docket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title(" Loan Application Documentation")
				.description("Contains all the APIs for the   Loan Application Version 1.0")
				.version(" Loan Application Version 1.0").build();
	}

}
