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

import dbConnectivity.My_function;
import main.UserLogin;
import main.WelcomePage;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashWithdraw extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashWithdraw frame = new CashWithdraw();
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
	public CashWithdraw() {
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
		
		JLabel lblCashWithdrawal = new JLabel("Cash Withdrawal");
		lblCashWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCashWithdrawal.setBounds(296, 54, 188, 43);
		panel.add(lblCashWithdrawal);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter The multiples of  100 only ");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe.setBounds(177, 122, 418, 16);
		panel.add(lblPleaseEnterThe);
		
		JLabel lblNewLabel_1 = new JLabel("Availble Denominations are    \r\n100,   200,   500,   2000");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(221, 151, 381, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount ");
		lblEnterAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterAmount.setBounds(177, 239, 118, 16);
		panel.add(lblEnterAmount);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(388, 236, 116, 22);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Amount =txtAmount.getText();
				
				boolean Status=My_function.cashWithdraw(Amount,UserLogin.card,UserLogin.pin);
				if(Status)
				{
					JOptionPane.showMessageDialog(null, "Transaction Complete \n Avialable Balance = "+UserLogin.availBal);
					dispose();
					new WelcomePage().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Transaction Terminated \nTry again later");
					dispose();
					new WelcomePage().setVisible(true);
				}
					
			
			}
		});
		btnProceed.setBounds(198, 310, 97, 25);
		panel.add(btnProceed);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText(null);
			}
		});
		btnClear.setBounds(334, 310, 97, 25);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WelcomePage().setVisible(true);
				dispose();
				}
		});
		btnExit.setBounds(462, 310, 97, 25);
		panel.add(btnExit);
	}

}
