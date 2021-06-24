package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.User;

public class UserController{
	

public boolean findUser(String username) throws ClassNotFoundException, SQLException
	{
		boolean found = false;
		String sql = "select username from sign_up where username = ?";
		Connection con = DBConnection.doConnection();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, username);
		//1 is referring to ?in the sql statement. 
		
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
			found = true;
	
		con.close();
		return found;	
	}
	
	public int addUser(User user) throws ClassNotFoundException, SQLException
	{
		int success = -1;
		String sql = "insert into sign_up (username, email, phoneNum, password) values (?,?,?,?)";
		if(findUser(user.getUserName())==false)
		{
		
			Connection con = DBConnection.doConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getPhoneNum());
			preparedStatement.setString(4, user.getPassword());
			
			success = preparedStatement.executeUpdate();
			con.close();
		}
		return success;
		
	}
	
}
	