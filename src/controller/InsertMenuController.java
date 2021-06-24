package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
//import model.AddProduct;
//import model.AddProduct;
import model.InsertMenu;
import model.Login;
//import view.ProductListView;

public class InsertMenuController {
	
	public int insertMenu(InsertMenu im) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.doConnection();
		
		int success = -1;
		
		Login login = new Login();
		
		String query = "SELECT userid FROM login ORDER BY id DESC LIMIT 1";
				
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			int id = rst.getInt(1);

			String sql = "insert into foodmenu (foodName, price) values (?,?)";
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, im.getFoodName());
			preparedStatement.setDouble(2, im.getPrice());

		
			success = preparedStatement.executeUpdate();	
			
			// userid in sql statement (sql2) is the column in foodmenu db
			// in phpmyadmin - setting userid column in foodmenu db
			// default value --> As defined: 0
			
			String sql2 = "update foodmenu SET userid = '"+id+"'";
			PreparedStatement statement = con.prepareStatement(sql2);
			int upd = statement.executeUpdate();
			
		}
		
								
		con.close();
		
		return success;
		
	}
	
	
	public ArrayList<InsertMenu> listAll() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<InsertMenu> list = new ArrayList<InsertMenu>();

		Connection con = DBConnection.doConnection();
		
		Login login = new Login();
		
		String query = "SELECT userid FROM login ORDER BY id DESC LIMIT 1";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			
			int id = rst.getInt(1);
			
			String sql = "select id,foodName, price from foodmenu where userid = '"+id+"' "; //and list_id = '"+listId"'

			PreparedStatement preparedStatement = con.prepareStatement(sql);
		
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				InsertMenu inm = new InsertMenu();
				
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
	
	public int updateMenu(InsertMenu addp) throws ClassNotFoundException, SQLException {

		Connection con = DBConnection.doConnection();
		
		int success = -1;

		String sql = "update foodmenu SET foodName = ?, price = ? where id ='"+addp.getId()+"'";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, addp.getFoodName());
		preparedStatement.setDouble(2, addp.getPrice());


	
		success = preparedStatement.executeUpdate();	

		
		//ProductListView plv = new ProductListView();
		
		//plv.refreshTable();
		
		
		con.close();
		
		return success;
		
	}
	
	public int deleteMenu(InsertMenu addp) throws ClassNotFoundException, SQLException {
		
		Connection con = DBConnection.doConnection();
		
		int success = -1;
		
		String sql = "delete from foodmenu where id = '"+addp.getId()+"' ";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);		
		
		success = preparedStatement.executeUpdate();		
		
		con.close();
		
		
		return success;
		
	}	
	
}
