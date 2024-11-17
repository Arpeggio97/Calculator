package com.Josh;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.scene.control.TextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Utils {

	public static String deleteLastValue(String expression, TextField textField, 
			String lastOperator) {
		
		int index = expression.lastIndexOf(lastOperator);
		String extractedString = expression.substring(0, index + 1);
		textField.setText("");
		extractedString = extractedString.trim();
		return extractedString;
	}

	public static String appendText(TextField textField, String textToAppend, String expression) {
		
		expression = expression + textToAppend;
		expression = expression.trim();
		return expression;

	}

	public static String appendOperator(TextField textField, String lastOperator, 
			String expression) {
		
		int index = expression.length() - 1;
		if (expression.charAt(index) == '+' || expression.charAt(index) == '-' 
				|| expression.charAt(index) == '*' || expression.charAt(index) == '/') {
			String extractedString = expression.substring(0, expression.length() - 1);
			expression = extractedString + lastOperator;
		} else
			expression = expression + lastOperator;
		expression = expression.trim();
		return expression;
	}

	public static String calculate(String expression, TextField textField) {

		try {
			double result = evaluateExpression(expression);

			// Check if result has no decimal part
			if (result == (int) result) {
				int intResult = (int) result;
				String resultText = Integer.toString(intResult);
				textField.setText(resultText);
				expression = resultText;

			} else {
				String resultText = Double.toString(result);
				textField.setText(resultText);
				expression = resultText;

			}

		} catch (ArithmeticException e) {
            // Handle divide by zero specifically
            textField.setText("Syntaxerror");
            return "Syntaxerror";
            
        } catch (IllegalArgumentException e) {
            // Handle invalid syntax
            textField.setText("Syntaxerror");
            return "Syntaxerror";
        }
		expression = expression.trim();
		return expression;

	}   

	private static double evaluateExpression(String expression) {
		
		if (!(expression.contains("/"))) {
			
			// Step 1: Parse the expression
			Expression exp = new ExpressionBuilder(expression).build();
			double result = exp.evaluate();

			// Step 2: Find the maximum decimal precision
			int precision = findMaxDecimalPlaces(expression);

			// Step 3: Round the result to the determined precision
			BigDecimal roundedResult = new BigDecimal(result).setScale(precision, 
					RoundingMode.HALF_UP);

			// Print the rounded result
			System.out.println("Rounded Result: " + roundedResult.doubleValue());

			// Return Result
			return roundedResult.doubleValue();
		} else {
			Expression exp = new ExpressionBuilder(expression).build();
			double result = exp.evaluate();
			return result;
		}

	}

	private static int findMaxDecimalPlaces(String expr) {
		String[] parts = expr.split("[^0-9.]+"); // Split by operators
		int maxPrecision = 0;

		for (String part : parts) {
			if (part.contains(".")) {
				int decimalPlaces = part.length() - part.indexOf('.') - 1;
				maxPrecision = Math.max(maxPrecision, decimalPlaces);
			}
		}
		return maxPrecision;
	}

}
