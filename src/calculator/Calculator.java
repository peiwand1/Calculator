package calculator;

import calculator.formatter.Formatter;
import java.lang.Math;

public class Calculator {
	private Formatter formatter;

	// constructor
	public Calculator(Formatter formatter) {
		this.formatter = formatter;
	}

	public double add(double a, double b) {
		return a + b;
	}

	public double subtract(double a, double b) {
		return a - b;
	}

	public double divide(double a, double b) {
		return a / b;
	}

	public double multiply(double a, double b) {
		return a * b;
	}
	
	public double power(double a, double b) {
        return Math.pow(a, b);
    }

	// return result based on formatter
	public String getFormattedResult(double result) {
		return formatter.format(result);
	}
}
