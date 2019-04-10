package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.WelcomePage;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectService extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectService frame = new SelectService();
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
	public SelectService() {
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
		
		JLabel lblSelectAanyOne = new JLabel("Select  the service accoring to your Requirement");
		lblSelectAanyOne.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectAanyOne.setBounds(177, 53, 469, 56);
		panel.add(lblSelectAanyOne);
		
		JButton btnCashWithdrwal = new JButton("Cash Withdrwal");
		btnCashWithdrwal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashWithdraw().setVisible(true);
				dispose();
			}
		});
		btnCashWithdrwal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCashWithdrwal.setBounds(168, 145, 150, 30);
		panel.add(btnCashWithdrwal);
		
		JButton btnBalanceEnquiry = new JButton("Balance Enquiry");
		btnBalanceEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BalanceEnquiry().setVisible(true);
				dispose();
				}
		});
		btnBalanceEnquiry.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBalanceEnquiry.setBounds(168, 188, 150, 30);
		panel.add(btnBalanceEnquiry);
		
		JButton btnMiniStatement = new JButton("Mini Statement");
		btnMiniStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MiniStatement().setVisible(true);
				dispose();
			}
		});
		btnMiniStatement.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMiniStatement.setBounds(168, 231, 150, 30);
		panel.add(btnMiniStatement);
		
		JButton btnPinChange = new JButton("Pin Change\r\n");
		btnPinChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PinChange().setVisible(true);
				dispose();
			}
		});
		btnPinChange.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPinChange.setBounds(474, 148, 150, 30);
		panel.add(btnPinChange);
		
		JButton btnCashDeposit = new JButton("Cash Deposit");
		btnCashDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashDeposit().setVisible(true);
				dispose();
			}
		});
		btnCashDeposit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCashDeposit.setBounds(474, 191, 150, 30);
		panel.add(btnCashDeposit);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "If you are unable to figure out which option to select then the option you should\n seelect will do same as its name suggest otherwise you can contact Bank");
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHelp.setBounds(474, 234, 150, 30);
		panel.add(btnHelp);
		
		JButton btnContactAtmService = new JButton("Contact ATM Service Excecitive");
		btnContactAtmService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Contact Number : 1800 180 2222");
							
			}
		});
		btnContactAtmService.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnContactAtmService.setBounds(264, 288, 269, 18);
		panel.add(btnContactAtmService);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage().setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(349, 409, 97, 25);
		panel.add(btnExit);
	}

}
