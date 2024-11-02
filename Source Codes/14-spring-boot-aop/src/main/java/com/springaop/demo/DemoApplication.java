package com.springaop.demo;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			addAccount(accountDAO, membershipDAO);
		};
	}

	private void addAccount(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		System.out.println("Call Account:");
		accountDAO.addAccount();
		System.out.println("Call Membership:");
		membershipDAO.addAccount();
	}


}
