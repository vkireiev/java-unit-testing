package ua.vkireiev.testing.module03.exercise0302;

public interface CalculatorService {
    double add(double a, double b);

    double sub(double a, double b);

    double mult(double a, double b);

    double div(double a, double b) throws ArithmeticException;
}
