package ua.vkireiev.testing.module02.exercise0202;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InterestCalculatorTest {
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

    @DisplayName("WhenCallWithZeroValues_ThenReturnZero")
    @ParameterizedTest(name = "[{index}] Must return 0 => principal={0}, rate={1}, time={2}")
    @MethodSource("provideArgumentsForZeroResult")
    void calculateInterest_WhenCallWithZeroValues_ThenReturnZero(
        double principal, double rate, double time) {
        assertEquals(0.0, testCalculator.calculateInterest(principal, rate, time), 0.0);
    }

    @DisplayName("WhenCallWithNonZeroValues_ThenReturnNonZero")
    @ParameterizedTest(name = "[{index}] Must return {3} => principal={0}, rate={1}, time={2}")
    @MethodSource("provideArgumentsForNonZeroResult")
    void calculateInterest_WhenCallWithNonZeroValues_ThenReturnNonZero(
        double principal, double rate, double time, double expectedResult) {
        assertEquals(expectedResult, testCalculator.calculateInterest(principal, rate, time), 0.0);
    }

    static Stream<Arguments> provideArgumentsForZeroResult() {
        return Stream.of(
            Arguments.of(0.00, 0.05, 1),
            Arguments.of(1000.00, 0.00, 1),
            Arguments.of(1000.00, 0.05, 0),
            Arguments.of(0.00, 0.00, 0.00));
    }

    static Stream<Arguments> provideArgumentsForNonZeroResult() {
        return Stream.of(
            Arguments.of(1.00, 1.00, 1.00, 1.00),
            Arguments.of(1000.00, 0.05, 1, 50.00),
            Arguments.of(1.00, 0.05, 1000, 50.00),
            Arguments.of(1.00, 50.0, 1, 50.00));
    }
}
