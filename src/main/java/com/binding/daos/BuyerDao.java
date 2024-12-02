package com.binding.daos;

import com.binding.models.Binding;
import com.binding.models.BuyerBid;
import com.binding.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDao {

    public boolean getBidByProductNameAndBidAmount(String product, Double amount) throws SQLException {
        String query = "SELECT * FROM seller_bids WHERE product = ? AND bidamount <= ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product);
            stmt.setDouble(2, amount);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("No bids found for the given product and bid amount.");
                    return false;
                }
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while fetching bids", e);
        }
    }

    public List<BuyerBid> getAllBuyerBid() {
        List<BuyerBid> buyerBids= new ArrayList<>();
        String query = "SELECT * FROM buyer_bids";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                BuyerBid buyerBid= new BuyerBid(
                        rs.getInt("id"),
                        rs.getString("buyername"),
                        rs.getString("product"),
                        rs.getDouble("bidamount")
                );
                buyerBids.add(buyerBid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerBids;
    }




    public BuyerBid createBuyerBid(BuyerBid buyerBid) {
        String query = "INSERT INTO buyer_bids (buyerName, product, bidAmount) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, buyerBid.getBuyerName());
            stmt.setString(2, buyerBid.getProduct());      // Set bidAmount
            stmt.setDouble(3, buyerBid.getBidAmount()); // Assuming BuyerBid has a SellerBinding

            stmt.executeUpdate();   // Execute the insert query
            System.out.println("Buyer Bid added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding buyer bid.");
        }
        return buyerBid;
    }


    public List<Binding> getAllBindings() {
        List<Binding> bindings = new ArrayList<>();
        String query = "SELECT * FROM bindings";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Binding binding = new Binding(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getDouble("bidAmount")
                );
                bindings.add(binding);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bindings;
    }
}
