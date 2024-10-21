package calculator;

public class Main {
    public static void main(String[] args) {
        String formatterType = "scientific";  // options: "decimal", "dollar", "euro", "scientific"

        // Make a calculator by sending config to a factory
        Calculator calculator = CalculatorFactory.createCalculator(formatterType);

        // Test output
        double result = calculator.add(1234.56789, 8765.4321);
        System.out.println(calculator.getFormattedResult(result));
    }
}
