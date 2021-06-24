package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.InsertMenu;
import model.Login;
import model.MenuOrder;

public class MenuOrderController {
	
	
	public int orderMenu(MenuOrder im) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.doConnection();
		
		int success = -1;
		
		Login login = new Login();
		
		String query = "SELECT userid FROM login ORDER BY id DESC LIMIT 1";
				
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			int id = rst.getInt(1);

			String sql = "insert into foodorder (foodName, price, quantity, tableno) values (?,?,?,?)";
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, im.getFoodName());
			preparedStatement.setDouble(2, im.getPrice());
			preparedStatement.setInt(3, im.getQuantity());
			preparedStatement.setInt(4, im.getTableno());

		
			success = preparedStatement.executeUpdate();	
			
			String sql2 = "update foodmenu SET userid = '"+id+"'";
			PreparedStatement statement = con.prepareStatement(sql2);
			int upd = statement.executeUpdate();
			
		}
		
								
		con.close();
		
		return success;
		
	}
	
	public ArrayList<MenuOrder> listAll() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<MenuOrder> list = new ArrayList<MenuOrder>();

		Connection con = DBConnection.doConnection();
		
		Login login = new Login();
		
		String query = "SELECT userid FROM login ORDER BY id DESC LIMIT 1";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			
			int id = rst.getInt(1);
			
			String sql = "select id, foodName, price from foodmenu"; //and list_id = '"+listId"'

			PreparedStatement preparedStatement = con.prepareStatement(sql);
		
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				MenuOrder inm = new MenuOrder();
				
				inm.setId(resultSet.getInt(1));
				// 1 is referring to list_ID in the sql  --> String sql = "select id(1),name, price, quantity, list_id from list_product where user_id = '"+id+"' "; 
				
				inm.setFoodName(resultSet.getString(2));
				// 2 is referring to month in the sql   --> String sql = "select id,name(2), price, quantity, list_id from list_product where user_id = '"+id+"' "; 
				
				inm.setPrice(resultSet.getDouble(3));
				// 3 is referring to week in the sql   --> String sql = "select id,name, price(3), quantity, list_id from list_product where user_id = '"+id+"' "; 

				
				list.add(inm);
			}
						
		}
		
		
		con.close();
		
		return list;
	}

	public ArrayList<MenuOrder> listOrder() throws ClassNotFoundException, SQLException {
		
		ArrayList<MenuOrder> list = new ArrayList<MenuOrder>();

		Connection con = DBConnection.doConnection();
		
		Login login = new Login();
		
		String query = "SELECT userid FROM login ORDER BY id DESC LIMIT 1";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			
			int id = rst.getInt(1);
			
			String sql = "select id, foodName, price,quantity,tableno from foodorder"; //and list_id = '"+listId"'

			PreparedStatement preparedStatement = con.prepareStatement(sql);
		
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				MenuOrder inm = new MenuOrder();
				
				inm.setId(resultSet.getInt(1));
				// 1 is referring to list_ID in the sql  --> String sql = "select id(1),name, price, quantity, list_id from list_product where user_id = '"+id+"' "; 
				
				inm.setFoodName(resultSet.getString(2));
				// 2 is referring to month in the sql   --> String sql = "select id,name(2), price, quantity, list_id from list_product where user_id = '"+id+"' "; 
				
				inm.setPrice(resultSet.getDouble(3));
				// 3 is referring to week in the sql   --> String sql = "select id,name, price(3), quantity, list_id from list_product where user_id = '"+id+"' "; 
				inm.setQuantity(resultSet.getInt(4));
				
				inm.setTableno(resultSet.getInt(5));
				
				list.add(inm);
			}
						
		}
		
		
		con.close();
		
		return list;
	}
	
	
	public ArrayList<MenuOrder> listExpenses() throws ClassNotFoundException, SQLException
	{

	ArrayList<MenuOrder> list = new ArrayList<MenuOrder>();

	Connection con = DBConnection.doConnection();

	String query = "select sum(price*quantity) FROM foodorder";

	PreparedStatement pst = con.prepareStatement(query);

	ResultSet rst = pst.executeQuery();	

	//if(rst.next()) {
		
		//double p = rst.getDouble(1);
		
		

	while(rst.next())
	{
		MenuOrder list2 = new MenuOrder();
		
	list2.setPrice(rst.getDouble(1));
	// 1 is referring to list_ID in the sql

	//list2.setPrice(rst.getDouble(2));
	// 2 is referring to month in the sql

	list.add(list2);
	}
	
	//System.out.println(p);	

	//}
	

	
	con.close();


	return list;
	}

}
