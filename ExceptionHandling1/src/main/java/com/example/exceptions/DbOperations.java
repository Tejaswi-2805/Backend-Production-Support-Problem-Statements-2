package com.example.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbOperations {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/tasks";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
    // database connection

	private static Connection establishConnection() throws DatabaseConnectionException {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Failed to connect to the database.");
        }
    }
	
	// Insert data into the Users table
    public static void insertUserData(String username, String email) throws SQLException, DataIntegrityViolationException {
        try (Connection connection = establishConnection()) {
            String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, email);
                statement.executeUpdate();
                System.out.println("Data inserted successfully.");
            } catch (SQLException e) {
                handleSQLException(e);
            }
        } catch (DatabaseConnectionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void handleSQLException(SQLException e) throws DataIntegrityViolationException {
        if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
            throw new DataIntegrityViolationException("Error: Data integrity violation - Duplicate email.");
        } else {
            e.printStackTrace();
        }
    }

}
