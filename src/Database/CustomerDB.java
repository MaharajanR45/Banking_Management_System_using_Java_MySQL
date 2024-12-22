package Database;

import java.sql.*;

import Models.Customer;

public class CustomerDB {

	public void addCustomer(Customer customer) {
		String insert = "Insert into customers values (?,?,?,?,?)";
		
		try
		{
			Connection con = DatabaseConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, customer.getCustomer_Id());
			ps.setString(2, customer.getCustomer_Name());
			ps.setString(3, customer.getEmail());
			ps.setLong(4,customer.getPhoneNumber());
			ps.setString(5, customer.getaccTYpe());
			ps.executeUpdate();
			System.out.println("Customer Added Successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
