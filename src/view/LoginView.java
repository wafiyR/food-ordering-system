package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.Login;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JTextField txtLoginPage;
	private JPasswordField txtPassword;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public void loginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page\r\n");
		lblLoginPage.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblLoginPage.setBounds(177, 92, 113, 55);
		contentPane.add(lblLoginPage);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(69, 193, 70, 25);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(69, 262, 70, 25);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(151, 193, 139, 24);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		Button btnLogin = new Button("LOGIN");	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login();
				MainPage menu = new MainPage();
				
				login.setUserName(txtUsername.getText());
				login.setPassword(txtPassword.getText());
				LoginController loginController = new LoginController();	
				
				try {
					boolean success = loginController.doLogin(login);
					if(success == true) {
						//JOptionPane.showMessageDialog(null,"Go to main menu");
						menu.mainPage();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Wrong Username/Password");
					}
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		btnLogin.setBounds(158, 329, 113, 30);
		contentPane.add(btnLogin);
		
		txtLoginPage = new JTextField();
		txtLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginPage.setBackground(new Color(253, 245, 230));
		txtLoginPage.setEditable(false);
		txtLoginPage.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		txtLoginPage.setText("WELCOME TO M&M SYSTEM");
		txtLoginPage.setBounds(0, 0, 454, 79);
		contentPane.add(txtLoginPage);
		txtLoginPage.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(151, 263, 139, 22);
		contentPane.add(txtPassword);
		
		separator = new JSeparator();
		separator.setBounds(0, 147, 454, 9);
		contentPane.add(separator);
	}

}
