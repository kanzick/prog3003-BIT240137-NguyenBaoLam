package com.mycompany.ex04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Temperature Converter");
        titleLabel.setFont(new Font("Arial", 20));

        Label inputLabel = new Label("Enter temperature (°C):");
        inputLabel.setFont(new Font("Arial", 14));

        TextField celsiusField = new TextField();
        celsiusField.setPromptText("e.g. 100");
        celsiusField.setMaxWidth(200);
        celsiusField.setFont(new Font("Arial", 14));

        Button convertButton = new Button("Convert to °F");
        convertButton.setFont(new Font("Arial", 14));
        convertButton.setStyle(
                "-fx-background-color: #2196F3;"
                + "-fx-text-fill: white;"
                + "-fx-padding: 8 20;"
                + "-fx-cursor: hand;"
        );

        Label resultLabel = new Label("Result will appear here");
        resultLabel.setFont(new Font("Arial", 16));
        resultLabel.setStyle("-fx-text-fill: #333333;");

        convertButton.setOnAction(event -> {
            String input = celsiusField.getText().trim();
            if (input.isEmpty()) {
                resultLabel.setText("Please enter a temperature value!");
                resultLabel.setStyle("-fx-text-fill: #E53935;");
                return;
            }
            try {
                double celsius = Double.parseDouble(input);
                double fahrenheit = celsius * 9.0 / 5.0 + 32;
                resultLabel.setText(String.format("%.2f°C  =  %.2f°F", celsius, fahrenheit));
                resultLabel.setStyle("-fx-text-fill: #1565C0; -fx-font-weight: bold;");
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a number!");
                resultLabel.setStyle("-fx-text-fill: #E53935;");
            }
        });

        celsiusField.setOnAction(event -> convertButton.fire());

        VBox root = new VBox(15, titleLabel, inputLabel, celsiusField, convertButton, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #F5F5F5;");

        Scene scene = new Scene(root, 380, 280);
        primaryStage.setTitle("Celsius to Fahrenheit Converter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
