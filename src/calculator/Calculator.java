package calculator;

import calculator.formatter.Formatter;

public class Calculator {
    private Formatter formatter;

    // constructor
    public Calculator(Formatter formatter) {
        this.formatter = formatter;
    }

    public double add(double a, double b) {
        return a + b;
    }

    // return result based on formatter
    public String getFormattedResult(double result) {
        return formatter.format(result);
    }
}
