package ua.vkireiev.testing.module02.exercise0203;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {
    private static final double zeroValue = 0.00d;
    private static final double principalInvalidValue1 = -100.00d;
    private static final double principalValidValue1 = 100.00d;
    private static final double rateValidValue1 = 5.00d;
    private static final double rateValidValue2 = -5.00d;
    private static final double timeInvalidValue1 = -14.70d;
    private static final double timeValidValue1 = 14.70d;
    private static final double timeValidValue2 = 0.70d;

    private static final double interestValidResult1 = 7000.00d;
    private static final double interestValidResult2 = -7000.00d;

    private InterestCalculator testCalculator;

    @BeforeEach
    void beforeEach() {
        testCalculator = new InterestCalculator();
        assertNotNull(testCalculator);
    }

    @AfterEach
    void afterEach() {
        testCalculator = null;
    }

    @Test
    @DisplayName("WhenCallWithInvalidPrincipal_ThenException")
    void calculateInterest_WhenCallWithInvalidPrincipal_ThenException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> testCalculator.calculateInterest(
                principalInvalidValue1,
                rateValidValue2,
                timeValidValue1));
        assertTrue(exception.getMessage().contains("Principal"));
        assertTrue(exception.getMessage().contains("value must be greater than 0"));
    }

    @Test
    @DisplayName("WhenCallWithNegativeTime_ThenException")
    void calculateInterest_WhenCallWithNegativeTime_ThenException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> testCalculator.calculateInterest(
                principalValidValue1,
                rateValidValue1,
                timeInvalidValue1));
        assertTrue(exception.getMessage().contains("Time"));
        assertTrue(exception.getMessage().contains("value must be greater than 0"));
    }

    @Test
    @DisplayName("WhenCallWithZeroAsTime_ThenException")
    void calculateInterest_WhenCallWithZeroAsTime_ThenException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> testCalculator.calculateInterest(
                principalValidValue1,
                rateValidValue1,
                zeroValue));
        assertTrue(exception.getMessage().contains("Time"));
        assertTrue(exception.getMessage().contains("value cannot be 0"));
    }

    @ParameterizedTest(name = "[{index}] interest={3} => principal={0}, rate={1}, time={2}")
    @DisplayName("WhenCallWithValidValues_ThenReturnInterest")
    @MethodSource("provideArgumentsWhenCallWithValidValues")
    void calculateInterest_WhenCallWithValidValues_ThenReturnInterest(
        double principal, double rate, double time, double expectedResult) {
        assertEquals(expectedResult, testCalculator.calculateInterest(principal, rate, time), 0.0);
    }

    static Stream<Arguments> provideArgumentsWhenCallWithValidValues() {
        return Stream.of(
            Arguments.of(principalValidValue1, rateValidValue1, timeValidValue1, interestValidResult1),
            Arguments.of(principalValidValue1, rateValidValue2, timeValidValue1, interestValidResult2),
            Arguments.of(principalValidValue1, zeroValue, timeValidValue1, zeroValue),
            Arguments.of(principalValidValue1, rateValidValue1, timeValidValue2, zeroValue),
            Arguments.of(principalValidValue1, rateValidValue2, timeValidValue2, zeroValue),
            Arguments.of(principalValidValue1, zeroValue, timeValidValue2, zeroValue),

            Arguments.of(zeroValue, rateValidValue1, timeValidValue1, zeroValue),
            Arguments.of(zeroValue, rateValidValue2, timeValidValue1, zeroValue),
            Arguments.of(zeroValue, zeroValue, timeValidValue1, zeroValue),
            Arguments.of(zeroValue, rateValidValue1, timeValidValue2, zeroValue),
            Arguments.of(zeroValue, rateValidValue2, timeValidValue2, zeroValue),
            Arguments.of(zeroValue, zeroValue, timeValidValue2, zeroValue)
        );
    }
}
