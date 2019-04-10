package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashDeposit extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashDeposit frame = new CashDeposit();
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
	public CashDeposit() {
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
		
		JLabel lblCashDeposit = new JLabel("Cash Deposit");
		lblCashDeposit.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCashDeposit.setBounds(291, 29, 214, 44);
		panel.add(lblCashDeposit);
		
		JLabel lblThanksForUsing = new JLabel("Thanks for using Our ATM service we will happy to serve to in future");
		lblThanksForUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForUsing.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThanksForUsing.setBounds(12, 384, 758, 80);
		panel.add(lblThanksForUsing);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount ");
		lblEnterAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterAmount.setBounds(180, 194, 158, 27);
		panel.add(lblEnterAmount);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(414, 198, 116, 22);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Amount=txtAmount.getText();
				boolean Status =My_function.cashDeposit(Amount,UserLogin.card,UserLogin.pin);
				if(Status) {
					JOptionPane.showMessageDialog(null, "Cash Deposited Succesful \n Available Balance = "+UserLogin.availBal);
					new WelcomePage().setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cash Deposited Unsuccesful");
					new WelcomePage().setVisible(true);
					dispose();
				}
			}
		});
		btnProceed.setBounds(187, 298, 97, 25);
		panel.add(btnProceed);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText(null);
				dispose();
				new WelcomePage().setVisible(true);
			}
		});
		btnClear.setBounds(342, 298, 97, 25);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomePage().setVisible(true);
			}
		});
		btnExit.setBounds(492, 298, 97, 25);
		panel.add(btnExit);
	}

}
