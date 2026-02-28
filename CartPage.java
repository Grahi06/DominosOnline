package gui;

import exception.EmptyCartException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.Cart;
import service.OrderService;

public class CartPage extends Application {

    private Cart cart;
    private String username;

    public CartPage() {
    }

    // Constructor for passing cart + username
    public CartPage(Cart cart, String username) {
        this.cart = cart;
        this.username = username;
    }

    @Override
    public void start(Stage stage) {

        Label title = new Label("Your Cart");

        TextArea cartArea = new TextArea();
        cartArea.setEditable(false);
  
        Button deliveredBtn = new Button("Order Received");
        deliveredBtn.setDisable(true);

        Button refreshBtn = new Button("Show Cart");
        Button confirmBtn = new Button("Confirm Order");

        Label messageLabel = new Label();

        OrderService orderService = new OrderService();

refreshBtn.setOnAction(e -> {

    if (cart == null || cart.isEmpty()) {
        cartArea.setText("Cart is empty");
        return;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < cart.getItemList().size(); i++) {

        sb.append(i + 1)
                .append(". ")
                .append(cart.getItemList().get(i).getName())
                .append(" | Qty: ")
                .append(cart.getQuantityList().get(i))
                .append("\n");
    }

    sb.append("\nTotal Bill: ₹")
            .append(cart.calculateTotal());

    cartArea.setText(sb.toString());
});
        
    
confirmBtn.setOnAction(e -> {

    if (cart == null || cart.isEmpty()) {
        messageLabel.setText("Cart is empty!");
        return;
    }

    orderService.placeOrder(cart, username, deliveredBtn);

    cart.getItemList().clear();
    cart.getQuantityList().clear();

    cartArea.clear();   // cart display clear

    messageLabel.setText("Order Confirmed!");
});


        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                title,
                cartArea,
                refreshBtn,
                confirmBtn,
                messageLabel
        );
        layout.getChildren().add(deliveredBtn);

        Scene scene = new Scene(layout, 650, 750);
        stage.setScene(scene);
        stage.setTitle("Cart Page");
        stage.show();
    }
}