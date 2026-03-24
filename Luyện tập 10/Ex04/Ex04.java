package com.ex04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex04 extends Application {

    private Label display;
    private Label subDisplay;

    private double firstOperand = 0;
    private double memoryValue = 0;
    private String currentOperator = "";
    private boolean startNewNumber = true;
    private boolean hasResult = false;

    @Override
    public void start(Stage stage) {
        subDisplay = new Label("");
        subDisplay.setFont(Font.font("Segoe UI", 14));
        subDisplay.setMaxWidth(Double.MAX_VALUE);
        subDisplay.setAlignment(Pos.CENTER_RIGHT);
        subDisplay.setPadding(new Insets(5, 15, 0, 15));
        subDisplay.setStyle("-fx-text-fill: #636363;");
        subDisplay.setMinHeight(25);

        display = new Label("0");
        display.setFont(Font.font("Segoe UI Semibold", 40));
        display.setMaxWidth(Double.MAX_VALUE);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPadding(new Insets(0, 15, 5, 15));
        display.setStyle("-fx-text-fill: #000000;");
        display.setMinHeight(60);

        VBox displayBox = new VBox(subDisplay, display);
        displayBox.setStyle("-fx-background-color: #F9F9F9;");

        String[] memLabels = {"MC", "MR", "M+", "M-", "MS"};
        HBox memoryRow = createButtonRow(memLabels, "#F9F9F9", "#000000", 13, 36);
        memoryRow.setPadding(new Insets(2, 2, 2, 2));

        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(2));

        String[][] buttons = {
            {"%", "CE", "C", "⌫"},
            {"⅟ₓ", "x²", "√x", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "−"},
            {"1", "2", "3", "+"},
            {"±", "0", ".", "="}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                Button btn = createCalcButton(text, row, col);
                GridPane.setHgrow(btn, Priority.ALWAYS);
                GridPane.setVgrow(btn, Priority.ALWAYS);
                grid.add(btn, col, row);
            }
        }

        for (int i = 0; i < 4; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(25);
            grid.getColumnConstraints().add(cc);
        }
        for (int i = 0; i < 6; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0 / 6);
            grid.getRowConstraints().add(rc);
        }

        VBox root = new VBox(displayBox, memoryRow, grid);
        VBox.setVgrow(grid, Priority.ALWAYS);
        root.setStyle("-fx-background-color: #E6E6E6;");

        Scene scene = new Scene(root, 322, 500);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPress);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setMinWidth(260);
        stage.setMinHeight(400);
        stage.show();
    }

    private Button createCalcButton(String text, int row, int col) {
        Button btn = new Button(text);
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn.setFont(Font.font("Segoe UI", 18));
        btn.setFocusTraversable(false);

        String bgColor;
        String textColor = "#000000";

        if (text.equals("=")) {
            bgColor = "#4CA2E0";
            textColor = "#FFFFFF";
        } else if (isDigitOrDot(text) || text.equals("±")) {
            bgColor = "#FFFFFF";
        } else {
            bgColor = "#F0F0F0";
        }

        String style = String.format(
                "-fx-background-color: %s; -fx-text-fill: %s; -fx-background-radius: 2; -fx-border-color: transparent; -fx-cursor: hand;",
                bgColor, textColor
        );
        String hoverStyle = String.format(
                "-fx-background-color: derive(%s, -10%%); -fx-text-fill: %s; -fx-background-radius: 2; -fx-border-color: transparent; -fx-cursor: hand;",
                bgColor, textColor
        );

        btn.setStyle(style);
        btn.setOnMouseEntered(e -> btn.setStyle(hoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(style));
        btn.setOnAction(e -> handleButton(text));

        return btn;
    }

    private HBox createButtonRow(String[] labels, String bg, String fg, double fontSize, double height) {
        HBox row = new HBox(2);
        for (String label : labels) {
            Button btn = new Button(label);
            btn.setFont(Font.font("Segoe UI", fontSize));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setPrefHeight(height);
            btn.setFocusTraversable(false);
            HBox.setHgrow(btn, Priority.ALWAYS);
            String style = String.format(
                    "-fx-background-color: %s; -fx-text-fill: %s; -fx-background-radius: 2; -fx-border-color: transparent; -fx-cursor: hand;",
                    bg, fg
            );
            btn.setStyle(style);
            btn.setOnMouseEntered(e -> btn.setStyle(style.replace(bg, "derive(" + bg + ", -8%)")));
            btn.setOnMouseExited(e -> btn.setStyle(style));
            btn.setOnAction(e -> handleButton(label));
            row.getChildren().add(btn);
        }
        return row;
    }

    private void handleButton(String text) {
        switch (text) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                handleDigit(text);
                break;
            case ".":
                handleDecimal();
                break;
            case "+":
            case "−":
            case "×":
            case "÷":
                handleOperator(text);
                break;
            case "=":
                handleEquals();
                break;
            case "C":
                handleClear();
                break;
            case "CE":
                handleClearEntry();
                break;
            case "⌫":
                handleBackspace();
                break;
            case "±":
                handleNegate();
                break;
            case "%":
                handlePercent();
                break;
            case "⅟ₓ":
                handleReciprocal();
                break;
            case "x²":
                handleSquare();
                break;
            case "√x":
                handleSquareRoot();
                break;
            case "MC":
                memoryValue = 0;
                break;
            case "MR":
                display.setText(formatNumber(memoryValue));
                startNewNumber = true;
                break;
            case "M+":
                memoryValue += getDisplayValue();
                break;
            case "M-":
                memoryValue -= getDisplayValue();
                break;
            case "MS":
                memoryValue = getDisplayValue();
                break;
            default:
                break;
        }
    }

    private void handleDigit(String digit) {
        if (startNewNumber || display.getText().equals("0")) {
            display.setText(digit);
            startNewNumber = false;
            hasResult = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void handleDecimal() {
        if (startNewNumber) {
            display.setText("0.");
            startNewNumber = false;
            hasResult = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void handleOperator(String op) {
        if (!currentOperator.isEmpty() && !startNewNumber) {
            calculateResult();
        }
        firstOperand = getDisplayValue();
        currentOperator = op;
        subDisplay.setText(formatNumber(firstOperand) + " " + op);
        startNewNumber = true;
        hasResult = false;
    }

    private void handleEquals() {
        if (!currentOperator.isEmpty()) {
            double secondOperand = getDisplayValue();
            subDisplay.setText(formatNumber(firstOperand) + " " + currentOperator + " " + formatNumber(secondOperand) + " =");
            calculateResult();
            currentOperator = "";
            hasResult = true;
        }
    }

    private void calculateResult() {
        double secondOperand = getDisplayValue();
        double result = 0;

        switch (currentOperator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "−":
                result = firstOperand - secondOperand;
                break;
            case "×":
                result = firstOperand * secondOperand;
                break;
            case "÷":
                if (secondOperand == 0) {
                    display.setText("Cannot divide by zero");
                    startNewNumber = true;
                    currentOperator = "";
                    subDisplay.setText("");
                    return;
                }
                result = firstOperand / secondOperand;
                break;
            default:
                result = secondOperand;
                break;
        }

        display.setText(formatNumber(result));
        firstOperand = result;
        startNewNumber = true;
    }

    private void handleClear() {
        display.setText("0");
        subDisplay.setText("");
        firstOperand = 0;
        currentOperator = "";
        startNewNumber = true;
        hasResult = false;
    }

    private void handleClearEntry() {
        display.setText("0");
        startNewNumber = true;
    }

    private void handleBackspace() {
        String current = display.getText();
        if (current.length() > 1) {
            display.setText(current.substring(0, current.length() - 1));
        } else {
            display.setText("0");
            startNewNumber = true;
        }
    }

    private void handleNegate() {
        double value = getDisplayValue();
        if (value != 0) {
            display.setText(formatNumber(-value));
        }
    }

    private void handlePercent() {
        double value = getDisplayValue();
        if (!currentOperator.isEmpty()) {
            value = firstOperand * value / 100;
        } else {
            value = value / 100;
        }
        display.setText(formatNumber(value));
        startNewNumber = true;
    }

    private void handleReciprocal() {
        double value = getDisplayValue();
        if (value == 0) {
            display.setText("Cannot divide by zero");
            startNewNumber = true;
            return;
        }
        subDisplay.setText("1/(" + formatNumber(value) + ")");
        display.setText(formatNumber(1.0 / value));
        startNewNumber = true;
    }

    private void handleSquare() {
        double value = getDisplayValue();
        subDisplay.setText("sqr(" + formatNumber(value) + ")");
        display.setText(formatNumber(value * value));
        startNewNumber = true;
    }

    private void handleSquareRoot() {
        double value = getDisplayValue();
        if (value < 0) {
            display.setText("Invalid input");
            startNewNumber = true;
            return;
        }
        subDisplay.setText("√(" + formatNumber(value) + ")");
        display.setText(formatNumber(Math.sqrt(value)));
        startNewNumber = true;
    }

    private double getDisplayValue() {
        try {
            return Double.parseDouble(display.getText().replace(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String formatNumber(double value) {
        if (value == (long) value && Math.abs(value) < 1e15) {
            return String.valueOf((long) value);
        }
        String result = String.valueOf(value);
        if (result.endsWith(".0")) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }

    private boolean isDigitOrDot(String text) {
        return text.matches("[0-9.]");
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case DIGIT0:
            case NUMPAD0:
                handleButton("0");
                break;
            case DIGIT1:
            case NUMPAD1:
                handleButton("1");
                break;
            case DIGIT2:
            case NUMPAD2:
                handleButton("2");
                break;
            case DIGIT3:
            case NUMPAD3:
                handleButton("3");
                break;
            case DIGIT4:
            case NUMPAD4:
                handleButton("4");
                break;
            case DIGIT5:
            case NUMPAD5:
                handleButton("5");
                break;
            case DIGIT6:
            case NUMPAD6:
                handleButton("6");
                break;
            case DIGIT7:
            case NUMPAD7:
                handleButton("7");
                break;
            case DIGIT8:
            case NUMPAD8:
                handleButton("8");
                break;
            case DIGIT9:
            case NUMPAD9:
                handleButton("9");
                break;
            case ADD:
                handleButton("+");
                break;
            case SUBTRACT:
                handleButton("−");
                break;
            case MULTIPLY:
                handleButton("×");
                break;
            case DIVIDE:
                handleButton("÷");
                break;
            case ENTER:
                handleButton("=");
                break;
            case EQUALS:
                handleButton("=");
                break;
            case PERIOD:
            case DECIMAL:
                handleButton(".");
                break;
            case BACK_SPACE:
                handleButton("⌫");
                break;
            case ESCAPE:
                handleButton("C");
                break;
            case DELETE:
                handleButton("CE");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
