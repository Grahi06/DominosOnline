package thread;

import model.Order;
import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class OrderProcessingThread extends Thread {

    private Order order;
    private Button deliveredBtn;

    public OrderProcessingThread(Order order, Button deliveredBtn) {
        this.order = order;
        this.deliveredBtn = deliveredBtn;
    }

    @Override
    public void run() {

        try {

            order.setStatus("Processing");
            System.out.println("Order Processing Started...");

            Thread.sleep(5000);

            order.setStatus("Completed");
            order.setReceivedTime(LocalDateTime.now());

            System.out.println("Order Completed!");

            Platform.runLater(() -> {
                deliveredBtn.setDisable(false);
            });

        } catch (Exception e) {
            System.out.println("Thread Error!");
        }
    }
}