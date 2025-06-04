package ua.vkireiev.testing.module02.exercise0201;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalculatorTest {
    private Calculator calculatorTest;

    @BeforeEach
    void beforeEach() {
        calculatorTest = new Calculator();
        assertNotNull(calculatorTest);
    }

    @AfterEach
    void afterEach() {
        calculatorTest = null;
    }

    @Nested
    @DisplayName("Tests related to addition and subtraction")
    class AdditionSubtractionTests {

        @Test
        @DisplayName("Test related to addition with two zero values")
        void addition_WhenCalledWithTwoZeroValues_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.addition(0.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to addition with first zero value")
        void addition_WhenCalledWithFirstZeroValue_ThenReturnSecondValue() {
            assertEquals(1.0, calculatorTest.addition(0.0, 1.0), 0.0);
        }

        @Test
        @DisplayName("Test related to addition with second zero value")
        void addition_WhenCalledWithSecondZeroValue_ThenReturnFirstValue() {
            assertEquals(1.0, calculatorTest.addition(1.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to addition with two non zero values")
        void addition_WhenCalledWithTwoNonZeroValues_ThenReturnAddition() {
            assertEquals(2.0, calculatorTest.addition(1.0, 1.0), 0.0);
        }

        @Test
        @DisplayName("Test related to subtraction with two zero values")
        void subtraction_WhenCalledWithTwoZeroValues_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.subtraction(0.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to subtraction with first zero value")
        void subtraction_WhenCalledWithFirstZeroValue_ThenReturnNegativeSecondValue() {
            assertEquals(-1.0, calculatorTest.subtraction(0.0, 1.0), 0.0);
        }

        @Test
        @DisplayName("Test related to subtraction with second zero value")
        void subtraction_WhenCalledWithSecondZeroValue_ThenReturnFirstValue() {
            assertEquals(1.0, calculatorTest.subtraction(1.0, 0.0), 0.0);
        }

        // @Disabled("Temporary disabled")
        @Test
        @DisplayName("Test related to subtraction with two non zero values")
        void subtraction_WhenCalledWithTwoNonZeroValues_ThenReturnSubtraction() {
            assertEquals(0.0, calculatorTest.subtraction(1.0, 1.0), 0.0);
        }

    }

    // @Disabled("Temporary disabled")
    @Nested
    @DisplayName("Tests related to multiplication and division")
    class MultiplicationDivisionTests {

        @Test
        @DisplayName("Test related to multiplication with two zero values")
        void multiplication_WhenCalledWithTwoZeroValues_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.multiplication(0.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to multiplication with first zero value")
        void multiplication_WhenCalledWithFirstZeroValue_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.multiplication(0.0, 1.0), 0.0);
        }

        @Test
        @DisplayName("Test related to multiplication with second zero value")
        void multiplication_WhenCalledWithSecondZeroValue_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.multiplication(1.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to multiplication with two non zero values")
        void multiplication_WhenCalledWithTwoNonZeroValues_ThenReturnMultiplication() {
            assertEquals(10.0, calculatorTest.multiplication(5.0, 2.0), 0.0);
        }

        @Test
        @DisplayName("Test related to division with two zero values")
        void division_WhenCalledWithTwoZeroValues_ThenReturnNaN() {
            assertEquals(Double.NaN, calculatorTest.division(0.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to division with first zero values")
        void division_WhenCalledWithFirstZeroValue_ThenReturnZero() {
            assertEquals(0.0, calculatorTest.division(0.0, 1.0), 0.0);
        }

        @Test
        @DisplayName("Test related to division with first positive and second zero values")
        void division_WhenCalledWithFirstPositiveAndSecondZeroValues_ThenReturnPositiveInfinity() {
            assertEquals(Double.POSITIVE_INFINITY, calculatorTest.division(1.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to division with first negative and second zero values")
        void division_WhenCalledWithFirstNegativeAndSecondZeroValues_ThenReturnNegativeInfinity() {
            assertEquals(Double.NEGATIVE_INFINITY, calculatorTest.division(-1.0, 0.0), 0.0);
        }

        @Test
        @DisplayName("Test related to division with two non zero values")
        void division_WhenCalledWithTwoNonZeroValues_ThenReturnDivision() {
            assertEquals(2.5, calculatorTest.division(5.0, 2.0), 0.0);
        }
    }
}
