package calculator.formatter;

import calculator.factory.DependencyInjectable;

//Formatter for euro notation: € 1.234,57
public class EuroFormatter implements Formatter, DependencyInjectable {
	@Override
	public String format(double number) {
		// swap . and ,
		// placeholder symbol # used for swapping
		return String.format("€ %,.2f", number).replace(",", "#").replace(".", ",").replace("#", ".");
	}
}