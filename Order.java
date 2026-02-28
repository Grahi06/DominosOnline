package model;

import java.time.LocalDateTime;

public class Order {

    private int orderId;
    private String username;

    private String itemName;
    private int quantity;
    private double totalPrice;

    private LocalDateTime orderTime;
    private LocalDateTime receivedTime;

    private String status;   // Pending, Processing, Completed

    // Constructor
    public Order(int orderId, String username,
                 String itemName, int quantity,
                 double totalPrice) {

        this.orderId = orderId;
        this.username = username;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;

        this.orderTime = LocalDateTime.now();
        this.status = "Pending";
    }

    // Getter and Setter
    public int getOrderId() {
        return orderId;
    }

    public String getUsername() {
        return username;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getReceivedTime() {
        return receivedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setReceivedTime(LocalDateTime receivedTime) {
        this.receivedTime = receivedTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // File storage format (important for txt file saving)
    public String toFileString() {

        return orderId + "," +
                username + "," +
                itemName + "," +
                quantity + "," +
                totalPrice + "," +
                orderTime + "," +
                receivedTime + "," +
                status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nUser: " + username +
                "\nItem: " + itemName +
                "\nQuantity: " + quantity +
                "\nTotal: ₹" + totalPrice +
                "\nStatus: " + status;
    }
}