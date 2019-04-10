package dbConnectivity;

import java.sql.*;

import javax.swing.JOptionPane;

import main.UserLogin;



public class My_function {

	public static boolean verifyUser(String card, String pin) {
		boolean status=false;
		try {
		Connection con=dbConnectivity.Connectivity.dbConnect();
		String qry="select * from accountDetails where CardNo ='"+card+"'  and Pin='"+pin+"'";
		Statement st=con.createStatement();
		ResultSet rst=st.executeQuery(qry);
		if(rst.next()) {
			status=true;
			UserLogin.availBal=rst.getString(4);
			UserLogin.accountType=rst.getString(6);
			UserLogin.userName=rst.getString(5);
			UserLogin.accountno=rst.getString(1);
		}
		}catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
	}

	public static boolean cashWithdraw(String amount, String card, String pin) {
		String Accountno=UserLogin.accountno;
		String oldBal=UserLogin.availBal;
		int availBal1=(Integer.parseInt(UserLogin.availBal));
		int amount1=Integer.parseInt(amount);
		availBal1=availBal1-amount1;
		UserLogin.availBal=Integer.toString(availBal1);
		
		boolean statusa=false;
		boolean statusb=false;
		boolean status=false;
		try {
			int i=0;
			Connection con=dbConnectivity.Connectivity.dbConnect();
		    String qry="insert into transaction(AccountNo,CardNo,Debit,oldBal,availBal) Values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(qry);
			pst.setString(1, Accountno);
			pst.setString(2, card);
			pst.setString(3, amount);
			pst.setString(4, oldBal);
			pst.setString(5, UserLogin.availBal);
			
			i=pst.executeUpdate();
			if(i>0)
				 statusa=true;
			qry="Update accountDetails set AvailBal = ? where CardNo = ? and AccountNo=?";
			pst=con.prepareStatement(qry);
			pst.setString(1, UserLogin.availBal);
			pst.setString(2, card);
			pst.setString(3, Accountno);
			i=pst.executeUpdate();
			if(i>0)
				 statusb=true;
			if(statusa&&statusb)
				status=true;
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
		}

	public static boolean pinChange(String old, String new1, String card,String Accountno) {
		boolean status=false;
		try {
			int i=0;
			Connection con=dbConnectivity.Connectivity.dbConnect();
		    String qry="Update accountDetails set Pin = ? where CardNo = ? and AccountNo=?";
			PreparedStatement pst=con.prepareStatement(qry);
			pst.setString(1, new1);
			pst.setString(2, card);
			pst.setString(3, Accountno);
			i=pst.executeUpdate();
			if(i>0)
				 status=true;
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
		}

	public static boolean cashDeposit(String amount, String card, String pin) {
		String Accountno=UserLogin.accountno;
		String oldBal=UserLogin.availBal;
		int availBal1=(Integer.parseInt(UserLogin.availBal));
		int amount1=Integer.parseInt(amount);
		availBal1=availBal1+amount1;
		UserLogin.availBal=Integer.toString(availBal1);
		
		boolean statusa=false;
		boolean statusb=false;
		boolean status=false;
		try {
			int i=0;
			Connection con=dbConnectivity.Connectivity.dbConnect();
		    String qry="insert into transaction(AccountNo,CardNo,Credit,oldBal,availBal) Values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(qry);
			pst.setString(1, Accountno);
			pst.setString(2, card);
			pst.setString(3, amount);
			pst.setString(4, oldBal);
			pst.setString(5, UserLogin.availBal);
			
			i=pst.executeUpdate();
			if(i>0)
				 statusa=true;
			qry="Update accountDetails set AvailBal = ? where CardNo = ? and AccountNo=?";
			pst=con.prepareStatement(qry);
			pst.setString(1, UserLogin.availBal);
			pst.setString(2, card);
			pst.setString(3, Accountno);
			i=pst.executeUpdate();
			if(i>0)
				 statusb=true;
			if(statusa&&statusb)
				status=true;
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
		}
	}

	


