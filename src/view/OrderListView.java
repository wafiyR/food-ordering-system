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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MenuOrderController;
import model.MenuOrder;

public class OrderListView extends JFrame {

	private JPanel contentPane;
	private JTable tableList;
	private JScrollPane scrollPane;
	private JButton btnDeleteOrder;
	private JButton btnBack;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public void OrderListViewPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderListView frame = new OrderListView();
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
	public OrderListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();

		scrollPane.setBounds(12, 127, 499, 218);
		contentPane.add(scrollPane);
		
		tableList = new JTable();
		scrollPane.setViewportView(tableList);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Food Name");
		model.addColumn("Price");	
		model.addColumn("Quantity");
		model.addColumn("Table No");
		
		
		tableList.setModel(model);
		tableList.setAutoResizeMode(0);
		
		btnDeleteOrder = new JButton("Home");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainPage mlv = new MainPage();
				
				if(e.getActionCommand().equals("Home"))
				{
					mlv.mainPage();
					//this.dispose();
					dispose();
				}	
			}
		});
		btnDeleteOrder.setBounds(414, 78, 97, 25);
		contentPane.add(btnDeleteOrder);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuView mlv = new MenuView();
				
				if(e.getActionCommand().equals("Back"))
				{
					mlv.menuViewPage();
					//this.dispose();
					dispose();
				}	
			}
		});
		btnBack.setBounds(12, 78, 97, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setText("M&M System");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(0, 0, 541, 61);
		contentPane.add(textField);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(167, 409, 104, 47);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		DefaultTableModel model2 = new DefaultTableModel();
		
		model2.addColumn("Total Price(RM)");
		
		table.setModel(model2);
		table.setAutoResizeMode(0);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		
		tableList.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableList.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		MenuOrderController apc = new MenuOrderController();

		try {
			ArrayList<MenuOrder> list = apc.listOrder();
			
			model = (DefaultTableModel) tableList.getModel();
			
			Object[] row = new Object[5];
			
			for(int i=0; i<list.size(); i++) {
				
				row[0] = list.get(i).getId();
				row[1] = list.get(i).getFoodName();
				row[2] = list.get(i).getPrice();
				row[3] = list.get(i).getQuantity();
				row[4] = list.get(i).getTableno();
				model.addRow(row);
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ArrayList<MenuOrder> list2 = apc.listExpenses();
			
			model2 = (DefaultTableModel) table.getModel();
			
			Object[] row2 = new Object[1];	
			
			for(int i=0; i<list2.size(); i++) {
				
				row2[0] = list2.get(i).getPrice();

				model2.addRow(row2);
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
				
				/*txtId.setText((String) mdl.getValueAt(i, 0).toString());
				txtFoodName.setText((String) mdl.getValueAt(i, 1).toString());
				txtPrice.setText((String) mdl.getValueAt(i, 2).toString());*/

				
				
				
			}
		});		
		
	}
	
	/*public void refreshTable() throws ClassNotFoundException, SQLException {
	
	AddProductController apc = new AddProductController();
	
	DefaultTableModel model = (DefaultTableModel) tableList.getModel();
	model.setRowCount(0);
	
	ArrayList<AddProduct> list = apc.listAll();
	
	model = (DefaultTableModel) tableList.getModel();
	
	Object[] row = new Object[4];
	
	for(int i=0; i<list.size(); i++) {
		
		row[0] = list.get(i).getId();
		row[1] = list.get(i).getName();
		row[2] = list.get(i).getPrice();
		row[3] = list.get(i).getQuantity();
		model.addRow(row);
	}		
	
}*/

}
