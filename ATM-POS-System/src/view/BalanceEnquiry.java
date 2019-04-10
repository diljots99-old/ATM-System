package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.UserLogin;
import main.WelcomePage;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BalanceEnquiry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceEnquiry frame = new BalanceEnquiry();
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
	public BalanceEnquiry() {
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
		
		JLabel lblBalanceEnquiry = new JLabel("Balance Enquiry");
		lblBalanceEnquiry.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblBalanceEnquiry.setBounds(298, 35, 217, 51);
		panel.add(lblBalanceEnquiry);
		
		JLabel lblThanksForUsing = new JLabel("Thanks for using Our ATM service we will happy to serve to in future");
		lblThanksForUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForUsing.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThanksForUsing.setBounds(12, 384, 758, 80);
		panel.add(lblThanksForUsing);
		
		JLabel lblNewLabel_1 = new JLabel("Aavailble Balance : "+UserLogin.availBal);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(194, 179, 417, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage().setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(354, 330, 97, 25);
		panel.add(btnExit);
	}

}
