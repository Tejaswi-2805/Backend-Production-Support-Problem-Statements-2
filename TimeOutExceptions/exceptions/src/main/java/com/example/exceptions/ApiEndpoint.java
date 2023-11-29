package com.example.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiEndpoint {
	
	@GetMapping("/hello")
	public String hello(String message) {
		return "hello Tejaswi!!";
	}

}
