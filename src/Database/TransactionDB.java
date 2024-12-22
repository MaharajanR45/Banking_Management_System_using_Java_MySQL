package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Transaction;

public class TransactionDB {

	public void createTransaction(Transaction transaction) {
		String query = "INSERT INTO transactions (account_no, type, amount) VALUES (?, ?, ?)";
		
		try {
			Connection con = DatabaseConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, transaction.getAccount_No());
			ps.setString(2,transaction.getType());
			ps.setDouble(3, transaction.getAmount());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
