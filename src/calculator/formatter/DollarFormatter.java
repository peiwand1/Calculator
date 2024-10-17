package calculator.formatter;

//Formatter for dollar notation: $ 1,234.57
public class DollarFormatter implements Formatter {
	@Override
	public String format(double number) {
		return String.format("$ %,.2f", number);
	}
}