package com.example.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.exceptions.TimeOutException;


@SpringBootApplication
public class ProductsCatalogueApplication {
	
	private static final String API_ENDPOINT = "http://localhost:8080/getAllProducts";
	private static final int TIMEOUT_MS = 5000;

	public static void main(String[] args) {
		SpringApplication.run(ProductsCatalogueApplication.class, args);
		
		try {
			makeApiCall(API_ENDPOINT);
			System.out.println("Successful API Call: \"API response received successfully.\"");
		} catch (TimeOutException e) {
			System.err.println("Error: API call exceeded the timeout limit.");
		} catch (com.example.demo.exceptions.ApiResponseException e) {
			System.err.println("Error: The API returned an error response.");
		} catch (com.example.demo.exceptions.NetworkException e) {
			System.err.println("Error: Network issue encountered during the API call.");
		}
	}
	private static void makeApiCall(String apiEndpoint)
			throws TimeOutException, com.example.demo.exceptions.ApiResponseException, com.example.demo.exceptions.NetworkException {
		try {
            System.out.println("Making API call to: " + apiEndpoint);

			URL url = new URL(apiEndpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(TIMEOUT_MS);
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Processing the successful API response here
				System.out.println("API response received successfully.");
			} else {
				throw new com.example.demo.exceptions.ApiResponseException("The API returned an error response.");
			}
		} catch (java.net.SocketTimeoutException e) {
			throw new TimeOutException("API call exceeded the timeout limit.");
		} catch (IOException e) {
			throw new com.example.demo.exceptions.NetworkException("Network issue encountered during the API call.");
		}
	}


}
