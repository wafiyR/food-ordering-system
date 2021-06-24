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

import controller.MenuOrderController;
import model.MenuOrder;

public class MenuView extends JFrame {

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
	private JTextField txtQuantity;
	private JLabel lblTableNo;
	private JTextField txtTableNo;
	private JButton btnOrderList;
	private JLabel lblOrder;
	private JTextField textField;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public void menuViewPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView(); 
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
	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdate = new JButton("Order");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int id = Integer.parseInt(txtId.getText().trim());
				String fdname =  txtFoodName.getText();
				Double price = Double.parseDouble(txtPrice.getText().trim());
				int quantity = Integer.parseInt(txtQuantity.getText().trim());
				int tableno = Integer.parseInt(txtTableNo.getText().trim());
				
				MenuOrder adp = new MenuOrder();
				
				adp.setId(id);
				adp.setFoodName(fdname);
				adp.setPrice(price);
				adp.setQuantity(quantity);
				adp.setTableno(tableno);
				
				
				MenuOrderController apc = new MenuOrderController();
				
				try {
					int success = apc.orderMenu(adp);
					
					txtId.setText("");
					txtFoodName.setText("");
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTableNo.setText("");

					if(success == -1)
						JOptionPane.showMessageDialog(null, "Product already exists");					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//update product details
				
			}
		});
		
		btnUpdate.setBounds(245, 489, 107, 23);
		contentPane.add(btnUpdate);		
		
		scrollPane = new JScrollPane();

		scrollPane.setBounds(111, 84, 300, 136);
		contentPane.add(scrollPane);
		
		tableList = new JTable();
		scrollPane.setViewportView(tableList);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Food Name");
		model.addColumn("Price");		
		
		
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
		btnBack.setBounds(10, 65, 71, 23);
		contentPane.add(btnBack);
		
		lblName = new JLabel("Food Name:");
		lblName.setBounds(110, 348, 89, 14);
		contentPane.add(lblName);
		
		lblPrice = new JLabel("Price(RM) :");
		lblPrice.setBounds(110, 378, 67, 14);
		contentPane.add(lblPrice);
		
		txtFoodName = new JTextField();
		txtFoodName.setBounds(189, 345, 163, 20);
		contentPane.add(txtFoodName);
		txtFoodName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(189, 375, 163, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(110, 320, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(189, 315, 163, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(110, 408, 56, 16);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(189, 405, 163, 22);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		lblTableNo = new JLabel("Table no:");
		lblTableNo.setBounds(110, 443, 56, 16);
		contentPane.add(lblTableNo);
		
		txtTableNo = new JTextField();
		txtTableNo.setBounds(189, 440, 164, 22);
		contentPane.add(txtTableNo);
		txtTableNo.setColumns(10);
		
		btnOrderList = new JButton("Order List");
		btnOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrderListView mlv = new OrderListView();
				
				if(e.getActionCommand().equals("Order List"))
				{
					mlv.OrderListViewPage();
					//this.dispose();
					dispose();
				}				
				
			}
		});
		btnOrderList.setBounds(136, 488, 97, 25);
		contentPane.add(btnOrderList);
		
		lblOrder = new JLabel("ORDER");
		lblOrder.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblOrder.setBounds(199, 243, 97, 16);
		contentPane.add(lblOrder);
		
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
		separator.setBounds(0, 273, 454, 9);
		contentPane.add(separator);
		
		
		tableList.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(100);

		
		MenuOrderController apc = new MenuOrderController();
		
		try {
			ArrayList<MenuOrder> list = apc.listAll();
			
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
