package guviTask12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q2 {

	public static void main(String[] args) {

		// JDBC URL, username, and password for the database connection
		String URL = "jdbc:mysql://localhost:3306/guvi";
		String uname = "root";
		String psw = "Harifz_7581";

		 // SQL insert statement
		String insertSQLData = "INSERT INTO employeedetail (emplcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
		// Creating connection to mysql db
	    try (Connection connect = DriverManager.getConnection(URL, uname, psw);
	         PreparedStatement prepstatement = connect.prepareStatement(insertSQLData)) {

	            // Data to be inserted
	            Object[][] employeeData = {
	                {101, "Jenuy", 25, 10000},
	                {102, "Jacky", 30, 20000},
	                {103, "Joe", 20, 40000},
	                {104, "John", 40, 80000},
	                {105, "Shameer", 25, 90000}
	            };

	         // Insert data into the database
	            for (Object[] employee : employeeData) {
	            	prepstatement.setInt(1, (Integer) employee[0]);  // emplcode
	            	prepstatement.setString(2, (String) employee[1]); // empname
	            	prepstatement.setInt(3, (Integer) employee[2]); // empage
	            	prepstatement.setInt(4, (Integer) employee[3]); // esalary
	            	// Executing the insert
	            	prepstatement.executeUpdate();
	            }

	            System.out.println("Data inserted successfully");
	           
	        } catch (SQLException e) { // Catching SQL exceptions
	            e.printStackTrace();
	        }
	    }
	}


