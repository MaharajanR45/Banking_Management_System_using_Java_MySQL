package Models;

public class Account {
	
	private int Account_No;
	private int Customer_Id;
	private int PIN_No;
	private double Balance;
	
	public int getAccount_No() {
		return Account_No;
	}
	public void setAccount_No(int Account_No) {
		this.Account_No = Account_No;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(int Customer_Id) {
		this.Customer_Id = Customer_Id;
	}
	public int getPIN_No() {
		return PIN_No;
	}
	public void setPIN_No(int PIN_No) {
		this.PIN_No = PIN_No;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double Balance) {
		this.Balance = Balance;
	}
}
