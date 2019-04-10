package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dbConnectivity.My_function;
import main.UserLogin;
import main.WelcomePage;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PinChange extends JFrame {

	protected static final int ERROR_MESSAGE = 0;
	private JPanel contentPane;
	private JPasswordField pwdOld;
	private JPasswordField pwdNew;
	private JPasswordField pwdConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
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
	public PinChange() {
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
		
		JLabel lblThanksForUsing = new JLabel("Thanks for using Our ATM service we will happy to serve to in future");
		lblThanksForUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForUsing.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThanksForUsing.setBounds(12, 384, 758, 80);
		panel.add(lblThanksForUsing);
		
		JLabel lblPiChange = new JLabel("Pin Change");
		lblPiChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiChange.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPiChange.setBounds(301, 23, 221, 56);
		panel.add(lblPiChange);
		
		JLabel lblEnterOldPin = new JLabel("Enter Old Pin");
		lblEnterOldPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOldPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterOldPin.setBounds(193, 144, 122, 24);
		panel.add(lblEnterOldPin);
		
		JLabel lblEnterNewPin = new JLabel("Enter New Pin");
		lblEnterNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterNewPin.setBounds(193, 193, 140, 24);
		panel.add(lblEnterNewPin);
		
		JLabel lblConfirmPin = new JLabel("Confirm Pin\r\n");
		lblConfirmPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmPin.setBounds(193, 239, 122, 24);
		panel.add(lblConfirmPin);
		
		pwdOld = new JPasswordField();
		pwdOld.setBounds(403, 147, 100, 22);
		panel.add(pwdOld);
		
		pwdNew = new JPasswordField();
		pwdNew.setBounds(403, 193, 100, 22);
		panel.add(pwdNew);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setBounds(403, 242, 100, 22);
		panel.add(pwdConfirm);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String old=pwdOld.getText();
				String New=pwdNew.getText();
				String confirm=pwdConfirm.getText();
				String old1=UserLogin.pin;
				if(old1.equals(old)) {
				if(confirm.equals(New)) {
					boolean Status=My_function.pinChange(old,New,UserLogin.card,UserLogin.accountno);
					if(Status) {
						JOptionPane.showMessageDialog(null, "Pin Change Succesfull");
						new WelcomePage().setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Pin Change Unsuccesful","Pin change Error",ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR \nNew Pin and confirm pin does not match","Pin change Error",ERROR_MESSAGE);
				}}
				else {
					JOptionPane.showMessageDialog(null, "OLD Pin does Not match","Pin change Error",ERROR_MESSAGE);
				}
			}
		});
		btnConfirm.setBounds(218, 323, 97, 25);
		panel.add(btnConfirm);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdConfirm.setText(null);
				pwdNew.setText(null);
				pwdOld.setText(null);
			}
		});
		btnClear.setBounds(354, 323, 97, 25);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage().setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(492, 323, 97, 25);
		panel.add(btnExit);
	}

}
