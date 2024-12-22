package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Database.AccountDB;
import Database.CustomerDB;
import Database.DatabaseConnect;
import Database.TransactionDB;
import Models.Account;
import Models.Customer;

public class Main {
	public static void main(String args[])
	{
		AccountDB accountDB = new AccountDB();
		CustomerDB customerDB = new CustomerDB();
		TransactionDB transactionDB = new TransactionDB();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("\n1.New Customer Creation");
			System.out.println("2.Create Account");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Check Balance");
			System.out.println("6.Exit");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				Customer customer = new Customer();
				System.out.println("Enter Customer Id:");
				customer.setCustomer_Id(sc.nextInt());
				System.out.println("Enter Customer Name:");
				customer.setCustomer_Name(sc.next());
				System.out.println("Enter Email:");
				customer.setEmail(sc.next());
				System.out.println("Enter Phone Number:");
				customer.setPhoneNumber(sc.nextLong());
				System.out.println("Enter Account Type:");
				customer.setaccType(sc.next());
				customerDB.addCustomer(customer);
				break;
				
			case 2:
				Account account = new Account();
				System.out.println("Enter Account Number:");
				account.setAccount_No(sc.nextInt());
				System.out.println("Enter Customer_Id:");
				account.setCustomer_Id(sc.nextInt());
				System.out.println("Enter PIN:");
				int PIN = sc.nextInt();
				account.setPIN_No(PIN);
				System.out.println("Confirm PIN:");
				int ConfirmPIN = sc.nextInt();
				if(PIN != ConfirmPIN) {
					System.out.println("PIN Number Doesn't match");
				}
				else {
					System.out.println("Initial Amount for Account Creation:");
					account.setBalance(sc.nextDouble());
					accountDB.createAccount(account);
				}
				break;
				
			case 3:
				System.out.println("Enter Your Account Number:");
				int acc_no = sc.nextInt();
				System.out.println("Enter Your PIN:");
				int pin_no = sc.nextInt();
				
				String query = "select * from Account where Account_No = ? ";
				
				try
				{
					Connection con = DatabaseConnect.getConnection();
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, acc_no);
					ResultSet rs = ps.executeQuery();
					if(rs.next() && rs.getInt("PIN_No") == pin_no)
					{
						System.out.println("Enter the amount You want to Deposit:");
						double Amount = sc.nextDouble();
						accountDB.deposit(acc_no,Amount);
					}
					else {
						System.out.println("Invalid Data");
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Enter Your Account Number:");
				acc_no = sc.nextInt();
				System.out.println("Enter Your PIN:");
				pin_no = sc.nextInt();
				
				query = "Select * from account where account_no = ?";
				
				try
				{
					Connection con = DatabaseConnect.getConnection();
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, acc_no);
					ResultSet rs = ps.executeQuery();
					if(rs.next() && rs.getInt("PIN_No") == pin_no)
					{
						System.out.println("Enter the amount You want to Withdraw:");
						double Amount = sc.nextDouble();
						accountDB.withdraw(acc_no,Amount);
					}
					else {
						System.out.println("Invalid Data");
					}
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Enter Your Account Number:");
				acc_no = sc.nextInt();
				System.out.println("Enter Your PIN:");
				pin_no = sc.nextInt();
				
				query = "Select * from account where account_no = ?";
				
				try {
					Connection con = DatabaseConnect.getConnection();
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, acc_no);
					ResultSet rs = ps.executeQuery();
					if(rs.next() && rs.getInt("PIN_No") == pin_no) {
						System.out.println("Your Current Balance: "+ rs.getDouble("Balance"));
					}
					else {
						System.out.println("Invalid Data");
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				break;
					
			case 6:
				System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid Choice!");
				
			}
		}
	}

}
