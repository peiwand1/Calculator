package calculator.factory;

import calculator.Calculator;
import calculator.formatter.Formatter;

public class CalculatorFactory extends GenericFactory {
	private String formatterClassName; // Store the formatter class name

	public CalculatorFactory(String formatterClassName) {
		this.formatterClassName = formatterClassName;
	}

	public Calculator createCalculator() {
		// Use the generic factory method to create the formatter from the class name
		Formatter formatter = (Formatter) createFromClassName(formatterClassName);
		return new Calculator(formatter);
	}
}
