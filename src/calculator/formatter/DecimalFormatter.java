package calculator.formatter;

import calculator.factory.DependencyInjectable;

//Formatter for decimal notation: 1234,56789
public class DecimalFormatter implements Formatter, DependencyInjectable {
	@Override
	public String format(double number) {
		return String.format("%,.5f", number);
	}
}