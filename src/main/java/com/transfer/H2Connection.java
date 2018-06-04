package com.transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection
{
	private static String url = "jdbc:h2:tcp://localhost:9092/./testdb";
	private static String user = "sa";
	private static String passwd = "";

	public static Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(url, user, passwd);
		
	}
}