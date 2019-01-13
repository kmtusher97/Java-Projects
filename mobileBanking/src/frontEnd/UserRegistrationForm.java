package frontEnd;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class UserRegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField mblno;
	private JTextField NIDno;
	private JTextField simNID;
	private JTextField pin;

	/**
	 * Launch the application.
	 */
	public boolean isValid( int nid, String nm, String mblNO, int nidSim, String pinno ) {
		if( pinno == "" || (int)pinno.length() > 5 ) 
			return false;
		if( nm == "" || (int)nm.length() > 100 ) 
			return false;
		if( (int)mblNO.length() != 11 || mblNO.charAt(0) != '0' || mblNO.charAt(1) != '1' )  
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistrationForm frame = new UserRegistrationForm();
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
	public UserRegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(159, 65, 281, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		mblno = new JTextField();
		mblno.setBounds(159, 96, 281, 20);
		contentPane.add(mblno);
		mblno.setColumns(10);
		
		NIDno = new JTextField();
		NIDno.setBounds(159, 127, 281, 20);
		contentPane.add(NIDno);
		NIDno.setColumns(10);
		
		simNID = new JTextField();
		simNID.setBounds(159, 158, 281, 20);
		contentPane.add(simNID);
		simNID.setColumns(10);
		
		pin = new JTextField();
		pin.setBounds(159, 189, 281, 20);
		contentPane.add(pin);
		pin.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(52, 68, 76, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Mobile No:");
		lblNewLabel.setBounds(52, 99, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NID No");
		lblNewLabel_1.setBounds(52, 130, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sim NID");
		lblNewLabel_2.setBounds(52, 161, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PIN");
		lblNewLabel_3.setBounds(52, 192, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(52, 223, 76, 14);
		contentPane.add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
					PreparedStatement st = con.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");
					String nm = name.getText();
					String mblNO = mblno.getText();
					int nid = Integer.parseInt(NIDno.getText());
					int nidSim = Integer.parseInt(simNID.getText());
					String pinno = pin.getText();
					
					st.setInt(1, nid);
					st.setString(2, nm);
					st.setString(3, mblNO);
					st.setInt(4, nidSim);
					st.setDouble(5, 0.0);
					st.setString(6, pinno);
					
					if( isValid( nid, nm, mblNO, nidSim, pinno ) ) {
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully Registered!!!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Input!!!");
					}
				}
				catch (Exception er) {
					System.out.println(er);
				}
			}
		});
		btnNewButton.setBounds(159, 251, 258, 23);
		contentPane.add(btnNewButton);
	}
}
