package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.Order;
import service.OrderService;

public class OrderStatusPage extends Application {

    private String username;

    public OrderStatusPage() {
    }

    public OrderStatusPage(String username) {
        this.username = username;
    }

    @Override
    public void start(Stage stage) {

        Label title = new Label("Order Status");

        TextArea statusArea = new TextArea();
        statusArea.setEditable(false);

        Button refreshBtn = new Button("Refresh Status");

        OrderService orderService = new OrderService();

        refreshBtn.setOnAction(e -> {

            StringBuilder sb = new StringBuilder();

            for (Order order : OrderService.orderList) {

                if (order.getUsername().equals(username)) {

                    sb.append(order.toString());
                    sb.append("\n-----------------\n");
                }
            }

            statusArea.setText(sb.toString());
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

layout.getChildren().addAll(
        title,
        statusArea,
        refreshBtn
);

layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Order Status Page");
        stage.show();
    }
}