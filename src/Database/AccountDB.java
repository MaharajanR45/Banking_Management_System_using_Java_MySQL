package Database;

import Models.Account;
import Models.Transaction;

import java.sql.*;
import java.util.Scanner;

public class AccountDB {

	private TransactionDB transactionDB = new TransactionDB();
	
	public void createAccount(Account account) {
		
		String insert = "insert into Account values (?,?,?,?)";
		
		try
		{
			Connection con = DatabaseConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, account.getAccount_No());
			ps.setInt(2, account.getCustomer_Id());
			ps.setInt(3, account.getPIN_No());
			ps.setDouble(4, account.getBalance());
			ps.executeUpdate();	
			System.out.println("Account Created Successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Account Already Exists");
		}
	}
	
	public void deposit(int acc_no,double Amount) {
		String query = "update account set balance = balance + ? where Account_No = ?";
		
		try {
			Connection con = DatabaseConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, Amount);
			ps.setInt(2, acc_no);
			ps.executeUpdate();
			System.out.println("Amount Credited Successfully");
			
			Transaction transaction = new Transaction();
			transaction.setAccount_No(acc_no);
			transaction.setType("DEPOSIT");
			transaction.setAmount(Amount);
			transactionDB.createTransaction(transaction);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void withdraw(int acc_no,double Amount) {
		String updatequery = "update account set balance = balance - ? where Account_No = ?";
		String balancequery = "select balance from account where account_no = ?";
		
		try
		{
			Connection con = DatabaseConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(updatequery);
			PreparedStatement ps1 = con.prepareStatement(balancequery);
			ps1.setInt(1, acc_no);
			ResultSet rs = ps1.executeQuery();
			if(rs.next() && rs.getDouble("balance")>=Amount)
			{
				ps.setDouble(1, Amount);
				ps.setInt(2, acc_no);
				ps.executeUpdate();
				System.out.println("Amount Withdraw Successfully");
				double currbal = rs.getDouble("Balance") - Amount;
				System.out.println("Your Current Balance: " + currbal );
				
				Transaction transaction = new Transaction();
				transaction.setAccount_No(acc_no);
				transaction.setType("WITHDRAWAL");
				transaction.setAmount(Amount);
				transactionDB.createTransaction(transaction);
				
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
