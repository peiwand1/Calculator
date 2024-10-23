package calculator;

import calculator.config.ConfigLoader;
import calculator.factory.CalculatorFactory;

public class Main {
	public static void main(String[] args) {
		// Load the formatter class name from the configuration file
		String formatterClassName = ConfigLoader.loadFormatterClassName("config.json");

		CalculatorFactory factory = new CalculatorFactory(formatterClassName);
		Calculator calculator = factory.createCalculator();

		// Test output
		double result = calculator.add(1234.56789, 8765.4321);
		System.out.println(calculator.getFormattedResult(result));
	}
}
