package frontEnd;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setBackground(Color.WHITE);
		lblLoginForm.setBounds(96, 11, 231, 36);
		contentPane.add(lblLoginForm);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(10, 68, 81, 29);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(10, 134, 81, 29);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(96, 134, 313, 25);
		contentPane.add(pass);
		
		email = new JTextField();
		email.setBounds(96, 68, 313, 25);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
					Statement stmnt = con.createStatement();
					String sql = "select * from adminlogin where email='" + email.getText() + "' and pass='" + pass.getText().toString() + "'";
					ResultSet res = stmnt.executeQuery(sql);
					
					if( res.next() ) {
						JOptionPane.showMessageDialog(null, "Successful Login!!");
						AdminWindow adminWindow = new AdminWindow();
						adminWindow.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect mail or password!");
					}
					
					con.close();
				}
				catch (Exception er) {
					System.out.println(er);
				}
			}
		} );
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(141, 190, 89, 23);
		contentPane.add(btnLogin);
	}

}