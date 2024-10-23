package calculator.factory;

import calculator.config.ConfigLoader;
import calculator.formatter.Formatter;

public class FormatterFactory extends GenericFactory {
	private String formatterClassName; // Store the formatter class name

	public FormatterFactory() {
		// Load the formatter class name from the configuration file
		this.formatterClassName = ConfigLoader.loadFormatterClassName();
	}

	public Formatter createFormatter() {
		// Use the generic factory method to create the formatter from the class name
		return (Formatter) createFromClassName(formatterClassName);
	}
}
