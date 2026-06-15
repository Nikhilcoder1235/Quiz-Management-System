

package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	public static final String DB_URl = "jdbc:mysql://localhost:3306/quiz"; 
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "Nikhil@2227";
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}                       
	}
	public static Connection getConnection( ) throws Exception{
		Connection con = DriverManager.getConnection(DB_URl, DB_USER, DB_PASSWORD); 
		return con; 
	}
}
