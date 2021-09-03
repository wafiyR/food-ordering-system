package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.InsertMenuController;
import model.InsertMenu;

public class ManageMenu extends JFrame {

	private JPanel contentPane;
	private JTable tableList;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JLabel lblName;
	private JLabel lblPrice;
	private JTextField txtFoodName;
	private JTextField txtPrice;
	private JLabel lblId;
	private JTextField txtId;
	private JButton btnInsertMenu;
	private JLabel lblMenu;
	private JTextField textField;
	private JSeparator separator;
	private JButton btnLoad;

	/**
	 * Launch the application.
	 */
	public void manageMenuPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMenu frame = new ManageMenu();
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
	public ManageMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txtId.getText().trim());
				
				InsertMenu adp = new InsertMenu();
				adp.setId(id);
							
				InsertMenuController apc = new InsertMenuController();				
				
				try {
					int success = apc.deleteMenu(adp);
					
					txtId.setText("");
					txtFoodName.setText("");
					txtPrice.setText("");

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				JOptionPane.showMessageDialog(null, "Menu is Deleted Successfully!");
				//delete product details
			}
		});
		btnDelete.setBounds(304, 473, 103, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int id = Integer.parseInt(txtId.getText().trim());
				String fdname =  txtFoodName.getText();
				Double price = Double.parseDouble(txtPrice.getText().trim());
				
				
				InsertMenu adp = new InsertMenu();
				
				adp.setId(id);
				adp.setFoodName(fdname);
				adp.setPrice(price);
				
				InsertMenuController apc = new InsertMenuController();
				
				try {
					int success = apc.updateMenu(adp);
					
					txtId.setText("");
					txtFoodName.setText("");
					txtPrice.setText("");

					if(success == -1)
						JOptionPane.showMessageDialog(null, "Product already exists");					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Menu is Updated Successfully!");
				
				//update product details
				
			}
		});
		
		btnUpdate.setBounds(185, 473, 107, 23);
		contentPane.add(btnUpdate);	
		
		scrollPane = new JScrollPane();

		scrollPane.setBounds(94, 73, 309, 136);
		contentPane.add(scrollPane);
		
		tableList = new JTable();
		scrollPane.setViewportView(tableList);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Food Name");
		model.addColumn("Price(RM)");		
		
		
		tableList.setModel(model);
		tableList.setAutoResizeMode(0);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPage mlv = new MainPage();
				
				if(e.getActionCommand().equals("Back"))
				{
					mlv.mainPage();
					//this.dispose();
					dispose();
				}				
				
			}
		});
		btnBack.setBounds(10, 73, 74, 23);
		contentPane.add(btnBack);
		
		// alternatice way to reload data: https://www.youtube.com/watch?v=Tm36-pphxkQ
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// MainPage mlv = new MainPage();
				ManageMenu mngMenu = new ManageMenu();
				
				if(e.getActionCommand().equals("Load"))
				{
					//mlv.mainPage();
					mngMenu.manageMenuPage();
					//this.dispose();
					dispose();
					// location.reload();
				}				
				
			}
		});
		btnLoad.setBounds(10, 119, 74, 23);
		contentPane.add(btnLoad);
		
		lblName = new JLabel("Food Name:");
		lblName.setBounds(94, 344, 89, 17);
		contentPane.add(lblName);
		
		lblPrice = new JLabel("Price(RM) :");
		lblPrice.setBounds(94, 386, 65, 14);
		contentPane.add(lblPrice);
		
		txtFoodName = new JTextField();
		txtFoodName.setEditable(false);
		txtFoodName.setBounds(185, 342, 163, 20);
		contentPane.add(txtFoodName);
		txtFoodName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(185, 383, 163, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(94, 305, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(185, 302, 163, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		btnInsertMenu = new JButton("Insert Menu");
		btnInsertMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertMenuView apv = new InsertMenuView();
				
				if(e.getActionCommand().equals("Insert Menu"))
				{
					apv.insertMenuPage();
					//this.dispose();
					dispose();
				}			
												
			}
		});
		btnInsertMenu.setBounds(67, 473, 107, 23);
		contentPane.add(btnInsertMenu);
		
		lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblMenu.setBounds(201, 222, 56, 16);
		contentPane.add(lblMenu);
		
		textField = new JTextField();
		textField.setText("M&M System");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(0, 0, 454, 61);
		contentPane.add(textField);
		
		separator = new JSeparator();
		separator.setBounds(0, 261, 454, 9);
		contentPane.add(separator);
		
		tableList.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		InsertMenuController apc = new InsertMenuController();

		try {
			ArrayList<InsertMenu> list = apc.listAll();
			
			model = (DefaultTableModel) tableList.getModel();
			
			Object[] row = new Object[3];
			
			for(int i=0; i<list.size(); i++) {
				
				row[0] = list.get(i).getId();
				row[1] = list.get(i).getFoodName();
				row[2] = list.get(i).getPrice();
				model.addRow(row);
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tableList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//display selected row in text fields
				
				int i = tableList.getSelectedRow();
				
				DefaultTableModel mdl = new DefaultTableModel();
				
				mdl = (DefaultTableModel) tableList.getModel();  //or use DefaultTableModel
				
				txtId.setText((String) mdl.getValueAt(i, 0).toString());
				txtFoodName.setText((String) mdl.getValueAt(i, 1).toString());
				txtPrice.setText((String) mdl.getValueAt(i, 2).toString());

				
				
				
			}
		});		
		
	}
}
