package calculator.gui;

import javax.swing.*;

import calculator.Calculator;
import calculator.CalculatorFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
	public static void main(String[] args) {
		// Create the frame (window)
		JFrame frame = new JFrame("Simple Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new GridLayout(6, 2)); // Grid layout for arranging components
		frame.setLocationRelativeTo(null); // null causesthe window to center on screen
		
		Font defaultFont = new Font("Arial", Font.PLAIN, 18);
		Font boldFont = new Font("Arial", Font.BOLD, 16);
		
		// Create input fields and labels
		JLabel label1 = new JLabel("Number 1:");
		JTextField numberField1 = new JTextField();
		label1.setFont(boldFont);
		numberField1.setFont(defaultFont);

		JLabel label2 = new JLabel("Number 2:");
		JTextField numberField2 = new JTextField();
		label2.setFont(boldFont);
		numberField2.setFont(defaultFont);

		// Create a dropdown for arithmetic operations
		JLabel operationLabel = new JLabel("Select Operation:");
		String[] operations = { "+", "-", "*", "/", "^" };
		JComboBox<String> operationComboBox = new JComboBox<>(operations);
		operationLabel.setFont(boldFont);
		operationComboBox.setFont(defaultFont);

		// Create a dropdown for format options
		JLabel formatterLabel = new JLabel("Select Format:");
		String[] formatOptions = { "decimal", "dollar", "euro", "scientific" };
		JComboBox<String> formatterComboBox = new JComboBox<>(formatOptions);
		formatterLabel.setFont(boldFont);
		formatterComboBox.setFont(defaultFont);

		// Create a button to perform the calculation
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setFont(defaultFont);

		// Create a label to display the result
		JLabel resultLabel = new JLabel("Result: ");
		JTextField resultField = new JTextField();
		resultField.setEditable(false); // Make the result field non-editable
		resultLabel.setFont(boldFont);
		resultField.setFont(defaultFont);

		// Add components to the frame
		frame.add(label1);
		frame.add(numberField1);
		frame.add(operationLabel);
		frame.add(operationComboBox);
		frame.add(label2);
		frame.add(numberField2);
		frame.add(formatterLabel);
		frame.add(formatterComboBox);
		frame.add(new JLabel()); // Empty label for spacing
		frame.add(calculateButton);
		frame.add(resultLabel);
		frame.add(resultField);

		// Add action listener to the calculate button
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Parse the input numbers
					// replace commas with decimal points for parsing
					double num1 = Double.parseDouble(numberField1.getText().replace(",", "."));
					double num2 = Double.parseDouble(numberField2.getText().replace(",", "."));

					// Get the selected formatter type from the dropdown
					String selectedFormat = (String) formatterComboBox.getSelectedItem();

					// Create the calculator with the chosen formatter using the factory
					Calculator calculator = CalculatorFactory.createCalculator(selectedFormat);

					String selectedOperation = (String) operationComboBox.getSelectedItem();

					// Perform the calculation (addition in this case)
					double result = 0;
					switch (selectedOperation) {
					case "+":
						result = calculator.add(num1, num2);
						break;
					case "-":
						result = calculator.subtract(num1, num2);
						break;
					case "/":
						result = calculator.divide(num1, num2);
						break;
					case "*":
						result = calculator.multiply(num1, num2);
						break;
					case "^":
						result = calculator.power(num1, num2);
						break;
					}

					// Format and display the result
					String formattedResult = calculator.getFormattedResult(result);
					resultField.setText(formattedResult);

				} catch (NumberFormatException ex) {
					// Handle invalid input (e.g., if the user enters non-numeric values)
					JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException ex) {
					// Handle any other errors (like an unknown formatter)
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Show the window
		frame.setVisible(true);
	}
}
