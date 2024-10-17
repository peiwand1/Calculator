package calculator;

import calculator.formatter.*;

public class CalculatorFactory {
    // make a calculator with the right formatter
    public static Calculator createCalculator(String formatterType) {
        Formatter formatter;

        switch (formatterType.toLowerCase()) {
            case "decimal":
                formatter = new DecimalFormatter();
                break;
            case "dollar":
                formatter = new DollarFormatter();
                break;
            case "euro":
                formatter = new EuroFormatter();
                break;
            case "scientific":
                formatter = new ScientificFormatter();
                break;
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + formatterType);
        }

        // return calculator with formatter
        return new Calculator(formatter);
    }
}
