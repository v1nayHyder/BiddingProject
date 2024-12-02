package com.binding;

import com.binding.models.Binding;
import com.binding.models.BuyerBid;
import com.binding.services.BindingService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("✨ Welcome to my Bidding Application! 🚀");
        System.out.println("Where innovation meets efficiency. Let's get started!");
        Scanner scanner = new Scanner(System.in);
        BindingService bindingService = new BindingService();

        while (true) {
            System.out.println("1. Create a Seller Binding");
            System.out.println("2. View all Seller Bids");
            System.out.println("3. Create a Buyer Binding");
            System.out.println("4. View all Buyer Bids");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Seller Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String description = scanner.nextLine();
                    LocalDateTime createdAt = LocalDateTime.now();
                    System.out.print("Enter Bid Amount: ");
                    Double bidAmount = scanner.nextDouble();
                    bindingService.createBinding(name, description,createdAt,bidAmount);
                    System.out.println("Product Created At: " + createdAt);
                    System.out.println("Product created successfully!");
                    break;
                case 2:
                    List<Binding> bindings = bindingService.getAllBindings();
                    for (Binding binding : bindings) {
                        System.out.println("ID: " + binding.getId() + ",Seller Name: " + binding.getSellerName() + ", Product: " + binding.getProduct() + ", Bid Amount: " + binding.getBidAmount());
                    }
                    break;
                case 3:
                    System.out.print("Enter Buyer Name: ");
                    String bidName = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String product = scanner.nextLine();
                    System.out.print("Enter Bid Amount: ");
                    Double totalAmount = scanner.nextDouble();
                    LocalDateTime created = LocalDateTime.now();
                    bindingService.createBuyerBid(bidName,product,totalAmount);
                    System.out.println("Binding Created At: " + created);
                    System.out.println("Bid created successfully!");
                case 4:
                    List<BuyerBid> buyerBids = bindingService.getAllBuyerBid();
                    for (BuyerBid buyerBid : buyerBids) {
                        System.out.println("ID: " + buyerBid.getId() + ", Buyer Name: " + buyerBid.getBuyerName() + ", Product: " + buyerBid.getProduct()+ ", Bid Amount: " + buyerBid.getBidAmount());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}