package Models;

public class Customer {

	private int Customer_Id;
	private String Customer_Name;
	private String Email;
	private Long PhoneNumber;
	private String accType;
	
	public int getCustomer_Id() 
	{
		return Customer_Id;
	}
	public void setCustomer_Id(int Customer_Id)
	{
		this.Customer_Id = Customer_Id;
	}
	public String getCustomer_Name() 
	{
		return Customer_Name;
	}
	public void setCustomer_Name(String Customer_Name)
	{
		this.Customer_Name = Customer_Name;
	}
	public String getEmail() 
	{
		return Email;
	}
	public void setEmail(String Email)
	{
		this.Email = Email;
	}
	public Long getPhoneNumber() 
	{
		return PhoneNumber;
	}
	public void setPhoneNumber(Long PhoneNumber)
	{
		this.PhoneNumber = PhoneNumber;
	}
	public String getaccTYpe() 
	{
		return accType;
	}
	public void setaccType(String accType)
	{
		this.accType = accType;
	}
	
	
}
