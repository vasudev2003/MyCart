package main.java.repositiories;

import main.java.entities.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    private Connection connection;

    public BillRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Bill bill) {
        String query = "INSERT INTO bills (user_id, total_amount, discounted_amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bill.getUserId());
            statement.setDouble(2, bill.getTotalAmount());
            statement.setDouble(3, bill.getDiscountedAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String query = "SELECT * FROM bills";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Bill bill = new Bill(resultSet.getString("user_id"),
                        null, // Assuming products are not stored in the bill table
                        resultSet.getDouble("total_amount"),
                        resultSet.getDouble("discounted_amount"));
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }


}
