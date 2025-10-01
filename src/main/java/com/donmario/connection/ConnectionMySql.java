package com.donmario.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySql {
	
public static Connection getConnection() {
	Connection connection = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/donmario";
		String user = "root";
		String password = "61046026";
		connection = DriverManager.getConnection(url,user,password);
	}
	catch(Exception e){
		System.out.print("hubo un problema con ConnectionMySql.getConnection()");
	}
	return connection;
}
}
