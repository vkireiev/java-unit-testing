package ua.vkireiev.testing.module03.exercise0302;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeEach
    void beforeEach() {
        assertNotNull(calculator);
    }

    @AfterEach
    void afterEach() {
        calculator = null;
    }

    @ParameterizedTest(name = "testing add(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForAdditionMethod")
    void add_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {
        assertEquals(paramResult, calculator.add(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing sub(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForSubtractionMethod")
    void sub_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {
        assertEquals(paramResult, calculator.sub(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing mult(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForMultiplicationMethod")
    void mult_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {
        assertEquals(paramResult, calculator.mult(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing div(a, b) with (a={0}, b={1}) => expecting ArithmeticException")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForDivisionMethodWithException")
    void div_WhenCall_ThenException(
        double paramA, double paramB) {
        assertThrows(ArithmeticException.class, () -> calculator.div(paramA, paramB));
    }

    @ParameterizedTest(name = "testing div(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForDivisionMethod")
    void div_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {
        assertEquals(paramResult, calculator.div(paramA, paramB), 0.001d);
    }
}
