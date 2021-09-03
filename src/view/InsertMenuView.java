package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.InsertMenuController;
import model.InsertMenu;

public class InsertMenuView extends JFrame {

	private JPanel contentPane;
	private JTextField txtFood;
	private JTextField txtPrice;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void insertMenuPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMenuView frame = new InsertMenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 122, 454, 9);
		contentPane.add(separator);
		
		JLabel lblInsertNewMenu = new JLabel("INSERT NEW MENU");
		lblInsertNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertNewMenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblInsertNewMenu.setBounds(134, 86, 177, 16);
		contentPane.add(lblInsertNewMenu);
		
		JLabel lblFood = new JLabel("Food : ");
		lblFood.setBounds(113, 170, 56, 16);
		contentPane.add(lblFood);
		
		JLabel lblPrice = new JLabel("Price(RM) : ");
		lblPrice.setBounds(100, 216, 69, 19);
		contentPane.add(lblPrice);
		
		txtFood = new JTextField();
		txtFood.setColumns(10);
		txtFood.setBounds(180, 167, 116, 22);
		contentPane.add(txtFood);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(181, 216, 116, 22);
		contentPane.add(txtPrice);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String foodName = txtFood.getText();
				Double price = Double.parseDouble(txtPrice.getText().trim());
				
				InsertMenu im = new InsertMenu();
				im.setFoodName(foodName);
				im.setPrice(price);
				
				InsertMenuController imc = new InsertMenuController();
				
				
				try {
					int success = imc.insertMenu(im);
					txtFood.setText("");
					txtPrice.setText("");					
				
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Menu is Added Successfully!");
				/*AddProduct addProduct = new AddProduct();
				addProduct.setName(name);
				addProduct.setPrice(price);
				addProduct.setQuantity(quantity);
				addProduct.setList_ID(list_ID);
				
				AddProductController apc = new AddProductController();*/
			}
		});
		btnInsert.setBounds(250, 311, 97, 25);
		contentPane.add(btnInsert);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageMenu apv = new ManageMenu();
				
				if(e.getActionCommand().equals("Back"))
				{
					apv.manageMenuPage();
					//this.dispose();
					dispose();
				}	
			}
		});
		btnBack.setBounds(86, 311, 97, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setText("M&M System");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(0, 0, 454, 61);
		contentPane.add(textField);
	}

}
