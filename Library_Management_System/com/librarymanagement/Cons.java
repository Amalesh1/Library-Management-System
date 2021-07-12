package com.librarymanagement;

import java.sql.*;

public class Cons {
	
	Connection c;
	Statement s;
	public Cons() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "library_management_system", "admin");
			s = c.createStatement();
			
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
