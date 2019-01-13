package frontEnd;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField mbl;
	private JPasswordField pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginWindow frame = new UserLoginWindow();
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
	public UserLoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 11, 363, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserLogin.setBounds(86, 11, 185, 24);
		panel.add(lblUserLogin);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNo.setBounds(10, 81, 84, 24);
		panel.add(lblMobileNo);
		
		mbl = new JTextField();
		mbl.setBounds(104, 84, 249, 20);
		panel.add(mbl);
		mbl.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPin.setBounds(10, 137, 84, 14);
		panel.add(lblPin);
		
		pin = new JPasswordField();
		pin.setBounds(104, 137, 249, 18);
		panel.add(pin);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
					Statement stmnt = con.createStatement();
					String sql = "select * from user where mobileno='" + mbl.getText() + "' and PIN='" + pin.getText().toString() + "'";
					ResultSet res = stmnt.executeQuery(sql);
					
					if( res.next() ) {
						PersonalAccount personalAccount = new PersonalAccount();
						personalAccount.setMobile_no(mbl.getText());
						personalAccount.setPIN(pin.getText().toString());
						personalAccount.setVisible(true);
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
		});
		btnGo.setBounds(104, 184, 89, 23);
		panel.add(btnGo);
	}
}
