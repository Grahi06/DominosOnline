package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import gui.MenuPage;

import gui.RegisterPage;

import exception.InvalidLoginException;
import service.AuthService;

public class LoginPage extends Application {

    public static AuthService authService = new AuthService();

    @Override
    public void start(Stage stage) {

        Label title = new Label("Domino's Pizza Login");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");

        Label messageLabel = new Label();

loginBtn.setOnAction(e -> {

    String username = usernameField.getText();
    String password = passwordField.getText();

    try {

        if (authService.login(username, password)) {

            messageLabel.setText("Login Successful!");

            // ⭐ Username pass karo
            MenuPage menuPage = new MenuPage(username);
            menuPage.start(new Stage());

            stage.close();
        }

    } catch (InvalidLoginException ex) {
        messageLabel.setText(ex.getMessage());
    }

});
        // ✅ Register Button Action (Important Part 😈)
        registerBtn.setOnAction(e -> {

            RegisterPage registerPage = new RegisterPage();
            registerPage.start(new Stage());

        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginBtn,
                registerBtn,
                messageLabel
        );

        Scene scene = new Scene(layout, 550, 650);
        stage.setScene(scene);
        stage.setTitle("Pizza Ordering System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}