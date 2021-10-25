package com.project1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil cu;
	private static Properties prop = new Properties();
	
	private ConnectionUtil() {
		
	}

	public static synchronized ConnectionUtil getConUtil() {
		if(cu == null) {
			return new ConnectionUtil();
		} 
		return cu;
	}
	
	public Connection getCon() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		String url = "";
		String password = "";
		String username = "";
		
		try {
			prop.load(is);
			url = (String)prop.getProperty("url");
			username = (String)prop.getProperty("username");
			password = (String)prop.getProperty("password");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Connection con;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
