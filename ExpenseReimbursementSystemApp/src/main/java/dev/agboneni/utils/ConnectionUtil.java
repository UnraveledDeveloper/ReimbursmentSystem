//ExpenseReimbursmentSystem 
package dev.agboneni.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	Connection conn = null;
	
	public static Connection createConnection() {
		Properties props = new Properties();
		FileInputStream in;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			in = new FileInputStream(ConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());
			props.load(in);
			String details = props.getProperty("condetails");
			Connection conn = DriverManager.getConnection(details);
			return conn;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
