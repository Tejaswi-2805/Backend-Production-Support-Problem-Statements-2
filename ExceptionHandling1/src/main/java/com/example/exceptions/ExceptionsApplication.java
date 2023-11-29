package com.example.exceptions;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceptionsApplication {

	public static void main(String[] args) throws SQLException, DataIntegrityViolationException {
		SpringApplication.run(ExceptionsApplication.class, args);
		
		String username = "john legend";
        String email = "johnlegend@example.com";
        
        DbOperations.insertUserData(username, email);
	}
}
