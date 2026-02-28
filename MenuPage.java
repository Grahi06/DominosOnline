package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;

import model.Cart;
import model.Item;
import service.MenuService;
import service.OrderService;
import javafx.scene.shape.Line;
import java.util.ArrayList;
import java.util.List;

public class MenuPage extends Application {

     
    private MenuService menuService = new MenuService();
    private OrderService orderService = new OrderService();
    private Cart cart = new Cart();
    private Button deliveredBtn = new Button("Order Received"); 
    private String username;
    private ComboBox<String> sizeBox = new ComboBox<>();
    private List<Item> displayItemList = new ArrayList<>(); 



    public MenuPage(String username) {
           this.username = username;
    }
     

    @Override
    public void start(Stage stage) {


          VBox layout = new VBox();
          layout.setAlignment(Pos.CENTER);
          layout.setSpacing(18);
          layout.setPadding(new javafx.geometry.Insets(20));
          layout.setStyle("-fx-background-color: #ccffff;");

        deliveredBtn.setDisable(true);
          layout.setAlignment(Pos.CENTER);

        Label title = new Label("Pizza & Drink Menu");

        title.setStyle(
        "-fx-font-size: 24px;" +
        "-fx-font-weight: bold;"
        );  

        ListView<String> menuListView = new ListView<>();

menuListView.setStyle(
        "-fx-font-family: monospace;" +
        "-fx-font-size: 13px;"
);

displayItemList.clear();
menuListView.getItems().clear();

for (Item item : menuService.getMenu()) {

    displayItemList.add(item);

    double price = item.getPrice();

    if (item instanceof model.Pizza) {

        double mediumPrice = price + 100;
        double largePrice = price + 200;

        menuListView.getItems().add(
                String.format("%-20s Medium ₹%-10.2f Large ₹%.2f",
                        item.getName(),
                        mediumPrice,
                        largePrice)
        );
    }
    else {

        menuListView.getItems().add(
                String.format("%-20s ₹%.2f",
                        item.getName(),
                        price)
        );
    }
}
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter Quantity");
         
        sizeBox.getItems().addAll(
        "Medium",
        "Large"
        );

        sizeBox.setPromptText("Select Pizza Size");       

        Label totalLabel = new Label("Total Bill: ₹0");


        Button addCartBtn = new Button("Add To Cart");
        Button placeOrderBtn = new Button("Place Order");

        Label messageLabel = new Label();

        // ADD TO CART
        addCartBtn.setOnAction(e -> {

            try {

                int index = menuListView.getSelectionModel().getSelectedIndex();

                if (index == -1) {
                    messageLabel.setText("Select item first!");
                    return;
                }

                if (quantityField.getText().isEmpty()) {
                    messageLabel.setText("Enter quantity!");
                    return;
                }

                int quantity;

                try {
                    quantity = Integer.parseInt(quantityField.getText());

                    if (quantity <= 0) {
                        messageLabel.setText("Quantity must be greater than 0!");
                        return;
                    }

                } catch (Exception ex) {
                    messageLabel.setText("Invalid quantity!");
                    return;
                }

Item selectedItem = displayItemList.get(index);

if (selectedItem instanceof model.Pizza) {

    if (sizeBox.getValue() == null ||
        sizeBox.getValue().contains("Select")) {

        messageLabel.setText("Select pizza size!");
        return;
    }

    String size = sizeBox.getValue();

    selectedItem = new model.Pizza(
            selectedItem.getItemId(),
            selectedItem.getName(),
            selectedItem.getPrice(),
            size
    );
}

cart.addItem(selectedItem, quantity);

                double total = cart.calculateTotal();

                totalLabel.setText("Total Bill: ₹" + total);

                messageLabel.setText("Added to cart!");

            } catch (Exception ex) {
                messageLabel.setText("Something went wrong!");
            }
        });

        // PLACE ORDER
placeOrderBtn.setOnAction(e -> {

    if (cart.isEmpty()) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Cart is empty!");
        alert.show();
        return;
    }

    orderService.placeOrder(cart, username, deliveredBtn);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Order Status");
    alert.setHeaderText(null);
    alert.setContentText("Your order is confirmed!");
    alert.show();

    // Reset cart after order
    cart = new Cart();
    totalLabel.setText("Total Bill: ₹0");
    messageLabel.setText("");
});
 
 
// Delivered Button
deliveredBtn.setOnAction(e -> {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Thank You");
    alert.setContentText("Your order is delivered. Thank you!");
    alert.show();

    OrderService orderService = new OrderService();
    orderService.saveDeliveryRecord(username, "Order");

}); 

layout.getChildren().addAll(
        title,
        menuListView,
        sizeBox,
        quantityField,
        addCartBtn,
        placeOrderBtn,
        totalLabel,
        deliveredBtn,
        messageLabel
);

        Scene scene = new Scene(layout, 550, 650);
        stage.setScene(scene);
        stage.setTitle("Menu Page");
        stage.show();
    }
}