package com.binding.daos;

import com.binding.models.Binding;
import com.binding.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BindingDao {

    public void addBinding(Binding binding) {
        String query = "INSERT INTO seller_bids (sellername, product, createdat, bidamount) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, binding.getSellerName());
            stmt.setString(2, binding.getProduct());
            stmt.setTimestamp(3, Timestamp.valueOf(binding.getCreatedAt()));
            stmt.setDouble(4, binding.getBidAmount());
            stmt.executeUpdate();
            System.out.println("Binding created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while creating binding.");
        }
    }


    public List<Binding> getAllBindings() {
        List<Binding> bindings = new ArrayList<>();
        String query = "SELECT * FROM seller_bids";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Binding binding = new Binding(
                        rs.getInt("id"),
                        rs.getString("sellername"),
                        rs.getString("product"),
                        rs.getTimestamp("createdat").toLocalDateTime(),
                        rs.getDouble("bidamount")
                );
                bindings.add(binding);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bindings;
    }
}
