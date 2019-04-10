package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dbConnectivity.My_function;
import main.WelcomePage;
import view.AdminPanel;
import view.SelectAccount;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCard;
	private JPasswordField pwdPin;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 150, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WelcomePage.class.getResource("/resources/5a89168045b28.jpeg")));
		lblNewLabel.setBounds(0, 0, 800, 251);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 251, 782, 753);
		contentPane.add(panel);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAdminLogin.setBounds(305, 85, 246, 39);
		panel.add(lblAdminLogin);
		JLabel lblCardNumber = new JLabel("User Name");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCardNumber.setBounds(180, 169, 140, 16);
		panel.add(lblCardNumber);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(180, 216, 140, 16);
		panel.add(lblPassword);
		
		txtCard = new JTextField();
		txtCard.setBounds(415, 169, 210, 22);
		panel.add(txtCard);
		txtCard.setColumns(10);
		
		pwdPin = new JPasswordField();
		pwdPin.setBounds(415, 216, 210, 22);
		panel.add(pwdPin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String user=txtCard.getText();
			String pass=pwdPin.getText();
			boolean Status=My_function.verifyAdmin(user,pass);
			if(Status) {
				new AdminPanel().setVisible(true);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invaild Username Password Try Again");
			}
				
			}
		});
		btnLogin.setBounds(225, 319, 97, 25);
		panel.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText(null);
				pwdPin.setText(null);
			}
		});
		btnClear.setBounds(371, 319, 97, 25);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnExit.setBounds(528, 319, 97, 25);
		panel.add(btnExit);
	}
}
