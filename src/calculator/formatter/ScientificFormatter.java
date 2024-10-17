package calculator.formatter;

//Formatter for scientific notation: 1,23456789 E3
public class ScientificFormatter implements Formatter {
	@Override
	public String format(double number) {
		return String.format("%,.8E", number);
	}
}
