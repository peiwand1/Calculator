package calculator;

import calculator.config.ConfigLoader;
import calculator.factory.FormatterFactory;

public class Main {
	public static void main(String[] args) {
		ConfigLoader.loadConfig("config.json");

		FormatterFactory factory = new FormatterFactory();
		Calculator calculator = new Calculator(factory.createFormatter());

		// Test output
		double result = calculator.add(1234.56789, 8765.4321);
		System.out.println(calculator.getFormattedResult(result));
	}
}
