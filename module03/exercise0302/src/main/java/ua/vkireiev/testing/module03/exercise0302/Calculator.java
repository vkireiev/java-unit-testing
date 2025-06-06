package ua.vkireiev.testing.module03.exercise0302;

public class Calculator implements CalculatorService {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mult(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) throws ArithmeticException {
        if (Double.compare(b, 0.0d) == 0) {
            throw new ArithmeticException("Value cannot be 0.0d");
        }
        return a / b;
    }
}
