package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import service.AuthService;

public class RegisterPage {
  
    private AuthService authService = LoginPage.authService;

    public void start(Stage stage) {


        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button registerBtn = new Button("Register");

        Label messageLabel = new Label();

        registerBtn.setOnAction(e -> {

            authService.registerUser(
                    usernameField.getText(),
                    passwordField.getText(),
                    emailField.getText()
            );

            messageLabel.setText("Registration Successful!");
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                new Label("User Registration"),
                usernameField,
                passwordField,
                emailField,
                registerBtn,
                messageLabel
        );

        Scene scene = new Scene(layout, 550, 650);
        stage.setScene(scene);
        stage.setTitle("Register Page");
        stage.show();
    }
}