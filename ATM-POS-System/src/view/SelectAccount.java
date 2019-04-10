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

import main.UserLogin;
import main.WelcomePage;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectAccount frame = new SelectAccount();
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
	public SelectAccount() {
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
		
		JLabel lblSelectAccoutType = new JLabel("Select Accout Type");
		lblSelectAccoutType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectAccoutType.setBounds(82, 210, 253, 59);
		panel.add(lblSelectAccoutType);
		
		JButton btnSaving = new JButton("Saving");
		btnSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=UserLogin.accountType;
				if(type.equalsIgnoreCase("Saving"))
				{
					new SelectService().setVisible(true);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Transaction Terminated Worng Account Type");
					dispose();
					new WelcomePage().setVisible(true);
				}
			}
		});
		btnSaving.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaving.setBounds(426, 284, 97, 25);
		panel.add(btnSaving);
		
		JButton btnCurrent = new JButton("Current");
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=UserLogin.accountType;
				if(type.equalsIgnoreCase("Current"))
				{
						new SelectService().setVisible(true);
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Transaction Terminated Worng Account Type");
						dispose();
						new WelcomePage().setVisible(true);
					}
			}
		});
		btnCurrent.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCurrent.setBounds(426, 196, 97, 25);
		panel.add(btnCurrent);
	}

}
