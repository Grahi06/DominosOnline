package service;

import model.*;
import thread.OrderProcessingThread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class OrderService {

    public static ArrayList<Order> orderList = new ArrayList<>();

    public synchronized void placeOrder(Cart cart, String username, Button deliveredBtn) {

    if (cart.isEmpty()) {
        System.out.println("Cart is empty!");
        return;
    }

    int orderId = orderList.size() + 1;

    for (int i = 0; i < cart.getItemList().size(); i++) {

        Order order = new Order(
                orderId,
                username,
                cart.getItemList().get(i).getName(),
                cart.getQuantityList().get(i),
                cart.getItemList().get(i).calculatePrice(
                        cart.getQuantityList().get(i)
                )
        );

        orderList.add(order);
        saveOrderToFile(order);

        // ✅ Start thread for EACH order
        OrderProcessingThread thread =
              new OrderProcessingThread(order, deliveredBtn);

        thread.start();
    }

    System.out.println("Order placed successfully!");
}

     public void saveDeliveryRecord(String username, String food) {

    try {

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("data/delivery.txt", true));

        bw.write(username + " | " + food + " | Order received");
        bw.newLine();

        bw.close();

    } catch (Exception e) {
        System.out.println("Delivery file error!");
    }
}
    // Save order in txt file
    private void saveOrderToFile(Order order) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("data/orders.txt", true));

            bw.write(order.toFileString());
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("Order file writing error!");
        }
    }

    // Get Order Status
    public void showOrders(String username) {

        for (Order order : orderList) {

            if (order.getUsername().equals(username)) {

                System.out.println(order);
                System.out.println("-------------");
            }
        }
    }

    // Update Order Received Time
    public void receiveOrder(Order order) {
        order.setReceivedTime(LocalDateTime.now());
        order.setStatus("Completed");
    }
}