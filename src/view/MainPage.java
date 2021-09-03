package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtMainPage;

	/**
	 * Launch the application.
	 */
	public void mainPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageFood = new JButton("Manage Food");
		btnManageFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageMenu mm = new ManageMenu();
				
				if(e.getActionCommand().equals("Manage Food"))
				{
					mm.manageMenuPage();
					//this.dispose();
					dispose();
				}					
				
			}
		});
		btnManageFood.setBounds(150, 283, 127, 44);
		contentPane.add(btnManageFood);
		
		txtMainPage = new JTextField();
		txtMainPage.setText("M&M System");
		txtMainPage.setEditable(false);
		txtMainPage.setBackground(new Color(255, 222, 173));
		txtMainPage.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		txtMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtMainPage.setBounds(0, 0, 454, 61);
		contentPane.add(txtMainPage);
		txtMainPage.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				if(arg0.getActionCommand().equals("Logout"))
				{
					System.exit(-1);
				}
			}
		});
		btnLogout.setBounds(349, 402, 80, 25);
		contentPane.add(btnLogout);
		
		JButton btnOrderFood = new JButton("Order Food");
		btnOrderFood.setForeground(Color.BLACK);
		btnOrderFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
			
				
				MenuView mnv = new MenuView();
				
				if(f.getActionCommand().equals("Order Food"))
				{
					mnv.menuViewPage();
					//this.dispose();
					dispose();
				}
			}
		});
		btnOrderFood.setBounds(150, 196, 127, 44);
		contentPane.add(btnOrderFood);
		
		JLabel lblMainPage = new JLabel("Main Page");
		lblMainPage.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblMainPage.setBounds(173, 98, 153, 25);
		contentPane.add(lblMainPage);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 136, 454, 9);
		contentPane.add(separator);
	}

}
