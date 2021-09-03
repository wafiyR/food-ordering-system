package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	
	public static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mm2021","root","");
		
		// try getConnection with online mysql hosting (online/remote db)
		// hostname = sql12.freemysqlhosting.net
		// hostusername = sql12380691
		// hostpassword = XAtKnxRNY6
		// databasename = sql12380691
		
		// Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12380691","sql12380691","XAtKnxRNY6");
		
		return conn;
	}
			
	public static void main(String[] args) {
		try {
			System.out.println(DBConnection.doConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}