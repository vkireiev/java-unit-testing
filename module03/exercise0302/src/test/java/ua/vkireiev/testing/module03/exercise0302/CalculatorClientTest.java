package ua.vkireiev.testing.module03.exercise0302;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorClientTest {

    @Mock
    Calculator calculatorMock;

    @InjectMocks
    CalculatorClient calculatorClient;

    @BeforeEach
    void beforeEach() {
        assertNotNull(calculatorMock);
        assertNotNull(calculatorClient);
    }

    @AfterEach
    void afterEach() {
        Mockito.reset(calculatorMock);
    }

    @ParameterizedTest(name = "testing performAddition(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForAdditionMethod")
    void performAddition_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {

        Mockito.when(calculatorMock.add(paramA, paramB)).thenReturn(paramResult);

        assertEquals(paramResult, calculatorClient.performAddition(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing performSubtraction(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForSubtractionMethod")
    void performSubtraction_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {

        Mockito.when(calculatorMock.sub(paramA, paramB)).thenReturn(paramResult);

        assertEquals(paramResult, calculatorClient.performSubtraction(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing performMultiplication(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForMultiplicationMethod")
    void performMultiplication_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {

        Mockito.when(calculatorMock.mult(paramA, paramB)).thenReturn(paramResult);

        assertEquals(paramResult, calculatorClient.performMultiplication(paramA, paramB), 0.001d);
    }

    @ParameterizedTest(name = "testing performDivision(a, b) with (a={0}, b={1}) => expecting ArithmeticException")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForDivisionMethodWithException")
    void performDivision_WhenCall_ThenException(
        double paramA, double paramB) {

        Mockito.when(calculatorMock.div(paramA, paramB)).thenThrow(new ArithmeticException());

        assertThrows(ArithmeticException.class, () -> calculatorClient.performDivision(paramA, paramB));
    }

    @ParameterizedTest(name = "testing performDivision(a, b) with (a={0}, b={1}) => expecting result={2}")
    @MethodSource("ua.vkireiev.testing.module03.exercise0302.ArgumentsProvider#provideArgumentsForDivisionMethod")
    void performDivision_WhenCall_ThenReturnResult(
        double paramA, double paramB, double paramResult) {

        Mockito.when(calculatorMock.div(paramA, paramB)).thenReturn(paramResult);

        assertEquals(paramResult, calculatorClient.performDivision(paramA, paramB), 0.001d);
    }
}
