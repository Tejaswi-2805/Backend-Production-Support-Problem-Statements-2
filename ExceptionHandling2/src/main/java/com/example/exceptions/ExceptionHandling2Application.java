package com.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceptionHandling2Application {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandling2Application.class, args);
		
		String fileName = "financial_data.jpg";
		
        try {
            processFile(fileName);
            System.out.println("File Processed Successfully: \"File processed.\"");
        } catch (com.example.exceptions.CustomFileNotFoundException e) {
            System.err.println("Error: File '" + fileName + "' not found.");
        } catch (com.example.exceptions.InvalidFileFormatException e) {
            System.err.println("Error: Invalid file format for '" + fileName + "'.");
        } catch (com.example.exceptions.FileProcessingException e) {
            System.err.println("Error: Unexpected error occurred while processing '" + fileName + "'.");
        }
	}

	private static void processFile(String fileName)
            throws CustomFileNotFoundException, InvalidFileFormatException, FileProcessingException {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Perform file processing logic here

            // check for a specific file format
            if (!fileName.endsWith(".csv")) {
                throw new InvalidFileFormatException("Invalid file format for '" + fileName + "'.");
            }

            System.out.println("File processing logic executed successfully.");
        }
            catch (java.io.FileNotFoundException e) {
            throw new CustomFileNotFoundException("File '" + fileName + "' not found.");
        }
        catch (IOException e) {
            throw new FileProcessingException("Unexpected error occurred while processing '" + fileName + "'.");
        }
    }

}
