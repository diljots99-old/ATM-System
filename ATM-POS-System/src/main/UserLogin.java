package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.SelectAccount;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCard;
	private JPasswordField pwdPin;
	public static String userName="";
	public static String card="";
	public static String pin="";
	public static String accountType="";
	public static String availBal="";
	public static String accountno="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		userName=null;
		card=null;
		pin=null;
		accountno=null;
		accountType=null;
		availBal=null;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(other.ran.getRandomNumber(), other.ran.getRandomNumber(), 800, 800);
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
		
		JLabel lblNewLabel_1 = new JLabel("ATM User Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(325, 27, 150, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCardNumber.setBounds(180, 169, 140, 16);
		panel.add(lblCardNumber);
		
		JLabel lblPassword = new JLabel("ATM Pin\r\n");
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
				card=txtCard.getText();
				pin=pwdPin.getText();
				boolean status=dbConnectivity.My_function.verifyUser(card,pin);
				if(status) {
					JOptionPane.showMessageDialog(null, "Welcome, "+userName);
					new SelectAccount().setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invailde Card Number Or Pin");
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
				new WelcomePage().setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(528, 319, 97, 25);
		panel.add(btnExit);
	}
}
