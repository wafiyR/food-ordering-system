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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.User;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtPhoneNum;
	private JPasswordField txtPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblSignUp.setBounds(190, 74, 97, 43);
		contentPane.add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(51, 156, 86, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(51, 187, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(51, 220, 163, 28);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(51, 259, 75, 14);
		contentPane.add(lblPassword);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();
				String email =  txtEmail.getText();
				int phoneNum = Integer.parseInt(txtPhoneNum.getText().trim());
				String password = txtPassword.getText();
				
				User user = new User();
				user.setUserName(username);
				user.setEmail(email);
				user.setPhoneNum(phoneNum);
				user.setPassword(password);
				
				//JOptionPane.showMessageDialog(null, "Sign Up Successfully");
				
				UserController userController = new UserController();
				
				try {
					int success = userController.addUser(user);
					txtUsername.setText("");
					txtEmail.setText("");
					txtPhoneNum.setText("");
					txtPassword.setText("");
					if(success == -1)
						JOptionPane.showMessageDialog(null, "Username already exists");
				}catch(ClassNotFoundException arg0) {
					arg0.printStackTrace();
				}catch(SQLException arg0) {
					arg0.printStackTrace();
				}
				
				
			}
		});
		btnSignUp.setBounds(51, 361, 97, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblAlreadySignUp = new JLabel("Already Sign Up?");
		lblAlreadySignUp.setBounds(269, 343, 116, 14);
		contentPane.add(lblAlreadySignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginView btnLogin = new LoginView();
				
				if(e.getActionCommand().equals("Login"))
				{
					btnLogin.loginPage();
					//this.dispose();
					dispose();
				}					
								
				
			}
		});
		btnLogin.setBounds(269, 361, 89, 23);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(181, 153, 148, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(181, 184, 148, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(181, 220, 148, 20);
		contentPane.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(181, 255, 148, 22);
		contentPane.add(txtPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 268, 0, -210);
		contentPane.add(separator_1);
		
		textField = new JTextField();
		textField.setText("M&M System");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(0, 0, 464, 61);
		contentPane.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 130, 454, 9);
		contentPane.add(separator);
	}

}
