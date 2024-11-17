package com.Josh;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	TextField outputField;
	Font standardFont = new Font("Arial", 18);
	double buttonWidth = 100;
	double buttonHeight = 50;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Setting the window
			Stage window = primaryStage;
			window.setTitle("Calculator App");

			// Creating TextField
			outputField = new TextField();
			outputField.setEditable(false);
			outputField.setStyle("-fx-opacity: 1; -fx-background-color: lightgrey;");
			outputField.setFont(standardFont);
			outputField.setPrefWidth(200); // Set the preferred width to 200 pixels
			outputField.setPrefHeight(50); // Set the preferred height to 50 pixels

			// Creating Buttons
			Button button_1 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "1", outputField);
			Button button_2 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "2", outputField);
			Button button_3 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "3", outputField);
			Button button_4 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "4", outputField);
			Button button_5 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "5", outputField);
			Button button_6 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "6", outputField);
			Button button_7 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "7", outputField);
			Button button_8 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "8", outputField);
			Button button_9 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "9", outputField);
			Button button_0 = Buttons.createNumberButton(standardFont, buttonWidth, 
					buttonHeight, "0", outputField);
			Button button_Comma = Buttons.createCommaButton(standardFont, buttonWidth, 
					buttonHeight, ",", outputField);
			Button button_DEL = Buttons.createDeleteButton(standardFont, buttonWidth, 
					buttonHeight, "DEL", outputField);
			Button button_AC = Buttons.createAllClearButton(standardFont, buttonWidth, 
					buttonHeight, "AC", outputField);
			Button button_Multiplication = Buttons.createOperatorButton(standardFont, 
					buttonWidth, buttonHeight, "x",
					outputField);
			Button button_Division = Buttons.createOperatorButton(standardFont, 
					buttonWidth, buttonHeight, "/",
					outputField);
			Button button_Addition = Buttons.createOperatorButton(standardFont, 
					buttonWidth, buttonHeight, "+",
					outputField);
			Button button_Subtraction = Buttons.createOperatorButton(standardFont, 
					buttonWidth, buttonHeight, "-",
					outputField);
			Button button_Result = Buttons.createResultButton(standardFont, 
					buttonWidth, buttonHeight, "=",
					outputField);

			// Setting up GridPane
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new Insets(10, 10, 10, 10));
			gridpane.setVgap(8);
			gridpane.setHgap(10);

			GridPane.setColumnSpan(outputField, 5);

			GridPane.setConstraints(button_7, 0, 1);// GridPane First Row
			GridPane.setConstraints(button_8, 1, 1);
			GridPane.setConstraints(button_9, 2, 1);
			GridPane.setConstraints(button_DEL, 3, 1);
			GridPane.setConstraints(button_AC, 4, 1);

			GridPane.setConstraints(button_4, 0, 2);// GridPane Second Row
			GridPane.setConstraints(button_5, 1, 2);
			GridPane.setConstraints(button_6, 2, 2);
			GridPane.setConstraints(button_Multiplication, 3, 2);
			GridPane.setConstraints(button_Division, 4, 2);

			GridPane.setConstraints(button_1, 0, 3);// GridPane Third Row
			GridPane.setConstraints(button_2, 1, 3);
			GridPane.setConstraints(button_3, 2, 3);
			GridPane.setConstraints(button_Addition, 3, 3);
			GridPane.setConstraints(button_Subtraction, 4, 3);

			GridPane.setConstraints(button_0, 0, 4);// GridPane Fourth Row
			GridPane.setConstraints(button_Comma, 1, 4);
			GridPane.setConstraints(button_Result, 2, 4);

			// Accumulating Children
			gridpane.getChildren().addAll(outputField, button_7, button_8, button_9, button_DEL, 
					button_AC, button_4, button_5, button_6, button_Multiplication, button_Division,
					button_1, button_2, button_3, button_Addition, button_Subtraction, button_0, 
					button_Comma, button_Result);

			// Setting the scene
			Scene scene = new Scene(gridpane, 400, 300);

			// Displaying the window
			window.setScene(scene); 
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
