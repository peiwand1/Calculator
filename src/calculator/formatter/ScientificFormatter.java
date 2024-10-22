package calculator.formatter;

import calculator.factory.DependencyInjectable;

//Formatter for scientific notation: 1,23456789 E3
public class ScientificFormatter implements Formatter, DependencyInjectable {
	@Override
	public String format(double number) {
		return String.format("%.8e", number);
	}
}
