package context;

import java.sql.*;

public class DBContext {
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +"\\"+ instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty()) {
			url = "jdbc:sqlserver://localhost;"
			        + "user= " + userID + ";" + "password=" + password+ ";database="+ dbName;
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	
	private final String serverName = "MSSQLSERVER";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String instance="";
	private final String userID= "duc";
	private final String password = "1010";
	
	
}
