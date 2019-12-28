package com.revature.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws IOException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
				
		
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(
					/*
					 * We're using environment variables.
					 */
					System.getenv("dburl"),
					System.getenv("dbusername"),
					System.getenv("dbpassword")
					);
			System.out.println(connection + "Success!");
		}
		

		
		return connection;
	}
}
