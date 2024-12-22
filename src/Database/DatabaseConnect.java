package Database;

import java.sql.*;

public class DatabaseConnect {
	
	private static String URL = "jdbc:mysql://localhost:3306/banking";
	private static String username = "root";
	private static String password = "Maharajan45";
	
	public static Connection getConnection() {
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(URL,username,password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	

}
