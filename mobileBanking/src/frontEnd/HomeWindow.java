package frontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window;


public class HomeWindow extends JFrame {

	private JPanel homeWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow frame = new HomeWindow();
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
	public HomeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 422);
		homeWindow = new JPanel();
		homeWindow.setBackground(Color.LIGHT_GRAY);
		homeWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homeWindow);
		homeWindow.setLayout(null);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
			}
		});
		btnAdmin.setBounds(208, 109, 89, 23);
		homeWindow.add(btnAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow userWindow = new UserWindow();
				userWindow.setVisible(true);
			}
		});
		btnUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUser.setBounds(208, 180, 89, 23);
		homeWindow.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("DCash");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(110, 21, 280, 40);
		homeWindow.add(lblNewLabel);
	}
}
