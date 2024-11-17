package com.Josh;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Buttons {

	private static String expression = " ";
	private static String lastOperator = " ";

	public static Button createNumberButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField textField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			if (!(expression.equals("Syntaxerror"))) {
				expression = Utils.appendText(textField, button.getText(), expression);
				textField.setText(textField.getText() + buttonName);
				System.out.println(expression);
			}
		});
		return button;

	}

	public static Button createCommaButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField textField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			if (!(textField.getText().contains(".") | (expression.isBlank()) | 
					(expression.equals("Syntaxerror")))) {
				expression = Utils.appendText(textField, ".", expression);
				textField.setText(textField.getText() + ".");
				System.out.println(expression);
			}
		});
		return button;

	}   // Handle case of hitting button without prior number :Clear

	public static Button createOperatorButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField textField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			if (!(expression.isBlank() | (expression.equals("Syntaxerror")))) {
				String operator = "";
				switch (buttonName) {
				case "+":
					operator = "+";
					break;
				case "-":
					operator = "-";
					break;
				case "x":
					operator = "*";
					break;
				case "/":
					operator = "/";
					break;
				}
				lastOperator = operator;
				expression = Utils.appendOperator(textField, lastOperator, expression);
				System.out.println(expression);
				textField.clear();

			}
		});
		return button;

	}   // Fix exception when clicking button without choosing a prior number :Clear

	public static Button createResultButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField textField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			expression = Utils.calculate(expression, textField);
			System.out.println(expression);
			
		});
		return button;

	}   // Handle invalid expression exception :Clear
		// Make up for Rounding errors :Clear

	public static Button createDeleteButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField textField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			expression = Utils.deleteLastValue(expression, textField, lastOperator);
			System.out.println(expression);
			
		});
		return button;

	}

	public static Button createAllClearButton(Font standardFont, double buttonWidth, 
			double buttonHeight, String buttonName, TextField outputField) {

		Button button = new Button(buttonName);
		button.setPrefWidth(buttonWidth);
		button.setPrefHeight(buttonHeight);
		button.setFont(standardFont);
		button.setOnAction(e -> {
			outputField.setText("");
			expression = " ";
			System.out.println(expression);
			
		});
		return button;

	}

}
