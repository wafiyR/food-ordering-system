package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Login;
import database.DBConnection;

public class LoginController {
	
	public boolean doLogin(Login login) throws SQLException, ClassNotFoundException
	{
		String level ="";
		//code
		String sql = "select username,password from sign_up where username= ? and password = ?";
		//String sql = "select id from sign_up where username= ? and password = ?";
		DBConnection db = new DBConnection();
		Connection con = db.doConnection();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, login.getUserName());
		preparedStatement.setString(2, login.getPassword());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			level = resultSet.getString(1);
			
			String username = login.getUserName();
			
			String query = "select userid, username from sign_up where username = '"+username+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()) {
				
				int id = rst.getInt(1);
				
				String qry = "insert into login (userid,username) values ('"+id+"','"+username+"')";
				//String qry = "insert into login (user_id,username) value (id,username)";
				PreparedStatement pds = con.prepareStatement(qry);
				//ResultSet rtt = pds.executeQuery();
				int rtt = pds.executeUpdate();
				//pds.executeQuery();
				
				//System.out.println(id); --> display login'user id
				
			}
			
			//System.out.println(username); --> display login'user username
			
			con.close();
			return true;
		}
		else {
			con.close();
			return false;
		}
			
		
		
		
		//System.out.println(level); -->print out username
		
		
	}

}
