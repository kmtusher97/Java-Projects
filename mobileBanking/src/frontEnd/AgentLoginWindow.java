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

public class AgentLoginWindow extends JFrame {

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
					AgentLoginWindow frame = new AgentLoginWindow();
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
	public AgentLoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(32, 11, 363, 239);
		panel.add(panel_1);
		
		JLabel lblAgentLogin = new JLabel("Agent Login");
		lblAgentLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgentLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAgentLogin.setBounds(86, 11, 185, 24);
		panel_1.add(lblAgentLogin);
		
		JLabel label_1 = new JLabel("Mobile No");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(10, 81, 84, 24);
		panel_1.add(label_1);
		
		mbl = new JTextField();
		mbl.setColumns(10);
		mbl.setBounds(104, 84, 249, 20);
		panel_1.add(mbl);
		
		JLabel label_2 = new JLabel("PIN");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(10, 137, 84, 14);
		panel_1.add(label_2);
		
		pin = new JPasswordField();
		pin.setBounds(104, 137, 249, 18);
		panel_1.add(pin);
		
		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
					Statement stmnt = con.createStatement();
					String sql = "select * from agent where mobileno='" + mbl.getText() + "' and PIN='" + pin.getText().toString() + "'";
					ResultSet res = stmnt.executeQuery(sql);
					
					if( res.next() ) {
						AgentAccount agentAccount = new AgentAccount();
						agentAccount.setMobile_no(mbl.getText());
						agentAccount.setPIN(pin.getText().toString());
						agentAccount.setVisible(true);
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
		button.setBounds(104, 184, 89, 23);
		panel_1.add(button);
	}

}
