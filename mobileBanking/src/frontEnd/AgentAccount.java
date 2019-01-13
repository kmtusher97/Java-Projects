package frontEnd;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AgentAccount extends JFrame {
	private String name;
	private String mobile_no;
    private String NID_no_SIM;
    private double balance;
    private String PIN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getNID_no_SIM() {
        return NID_no_SIM;
    }

    public void setNID_no_SIM(String NID_no_SIM) {
        this.NID_no_SIM = NID_no_SIM;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentAccount frame = new AgentAccount();
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
	public AgentAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(33, 11, 161, 239);
		contentPane.add(panel);
		
		JButton button = new JButton("1. Check Balance");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
					Statement stmnt = con.createStatement();
					String sql = "select * from agent where mobileno='" + mobile_no + "' and PIN='" + PIN + "'";
					ResultSet res = stmnt.executeQuery(sql);
					
					if( res.next() ) {
						JOptionPane.showMessageDialog(null, "You account Balance is " + res.getDouble("balance") + " TK");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error!! :( Try again");
					}
					
					con.close();
				}
				catch (Exception er) {
					System.out.println(er);
				}
			}
		});
		button.setBounds(10, 25, 138, 23);
		panel.add(button);
		
		JButton button_2 = new JButton("3. Send Money");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnderConstruction uc = new UnderConstruction();
				uc.setVisible(true);
			}
		});
		button_2.setBounds(10, 59, 138, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("4. Payment");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnderConstruction uc = new UnderConstruction();
				uc.setVisible(true);
			}
		});
		button_3.setBounds(10, 93, 138, 23);
		panel.add(button_3);
		
		JButton button_5 = new JButton("6. Help");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnderConstruction uc = new UnderConstruction();
				uc.setVisible(true);
			}
		});
		button_5.setBounds(10, 195, 138, 23);
		panel.add(button_5);
		
		JButton btnNewButton = new JButton("5. Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistrationForm userReg = new UserRegistrationForm();
				userReg.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 127, 138, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("7. Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnderConstruction uc = new UnderConstruction();
				uc.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 161, 138, 23);
		panel.add(btnNewButton_1);
	}

}
