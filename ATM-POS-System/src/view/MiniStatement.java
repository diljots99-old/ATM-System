package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import main.UserLogin;
import main.WelcomePage;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniStatement frame = new MiniStatement();
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
	public MiniStatement() {
		try {
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
	
		Connection con=dbConnectivity.Connectivity.dbConnect();
		String qry="select * from transaction where AccountNo ='"+UserLogin.accountno+"' LIMIT 10";
		Statement st=con.createStatement();
		ResultSet rst=st.executeQuery(qry);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 251, 782, 753);
		contentPane.add(panel);
		
		JLabel lblMiniStatement = new JLabel("Mini Statement");
		lblMiniStatement.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblMiniStatement.setBounds(265, 0, 334, 65);
		panel.add(lblMiniStatement);
		Object tar[][]= new Object[11][7]	;
		tar[0][0]="Account Number";
		tar[0][1]="Card Number";
		tar[0][2]="Credit";
		tar[0][3]="Debit";
		tar[0][4]="Old Balance";
		tar[0][5]="New Balance";
		tar[0][6]="Date";
		for(int i=1;rst.next();i++){
			for(int j=0;j<7;j++) {
			tar[i][j]=rst.getString(j+1);
			System.out.println(tar[i][j]);
			}
			
		}
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
				tar,
			new String[] {
				"Account Number", "Card Number", "Credit", "Debit", "Old Balance", "New Balance", "Date"
			}
		));
		for(int i=0;i<7;i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(75);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(35, 152, 699, 261);
		panel.add(table);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
