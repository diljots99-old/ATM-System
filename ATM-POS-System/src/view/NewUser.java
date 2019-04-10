package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbConnectivity.My_function;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCard;
	private JTextField txtPin;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(other.ran.getRandomNumber(), other.ran.getRandomNumber(), 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewUser.class.getResource("/resources/5a89168045b28.jpeg")));
		lblNewLabel.setBounds(0, 0, 800, 251);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 251, 782, 753);
		contentPane.add(panel);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setBounds(340, 13, 56, 16);
		panel.add(lblNewUser);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(172, 80, 131, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblAtmPin = new JLabel("ATM Pin\r\n");
		lblAtmPin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAtmPin.setBounds(172, 136, 131, 43);
		panel.add(lblAtmPin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(172, 192, 131, 43);
		panel.add(lblUserName);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccountType.setBounds(172, 248, 131, 43);
		panel.add(lblAccountType);
		
		JRadioButton Saving = new JRadioButton("Saving");
		Saving.setSelected(true);
		buttonGroup.add(Saving);
		Saving.setBackground(Color.ORANGE);
		Saving.setBounds(338, 257, 127, 25);
		panel.add(Saving);
		
		JRadioButton Current = new JRadioButton("Current");
		buttonGroup.add(Current);
		Current.setBackground(Color.ORANGE);
		Current.setBounds(480, 257, 127, 25);
		panel.add(Current);
		
		txtCard = new JTextField();
		txtCard.setBounds(340, 90, 159, 22);
		panel.add(txtCard);
		txtCard.setColumns(10);
		
		txtPin = new JTextField();
		txtPin.setColumns(10);
		txtPin.setBounds(340, 146, 159, 22);
		panel.add(txtPin);
		
		txtUser = new JTextField();
		
		txtUser.setColumns(10);
		txtUser.setBounds(340, 202, 159, 22);
		panel.add(txtUser);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String card=txtCard.getText();
				String pin=txtPin.getText();
				String username=txtUser.getText();
				String accountype=null;
				if(Saving.isSelected()) {
					accountype="Saving";
				}
				if(Current.isSelected()) {
					accountype="Current";
				}
				boolean Status=My_function.newUser(card,pin,username,accountype);
				if(Status) {
					JOptionPane.showMessageDialog(null, "Your Data Saved");
				}
				else {
					JOptionPane.showMessageDialog(null, "Your Data not Saved");
				}
			}
		});
		btnRegister.setBounds(332, 365, 97, 25);
		panel.add(btnRegister);
	}
}
