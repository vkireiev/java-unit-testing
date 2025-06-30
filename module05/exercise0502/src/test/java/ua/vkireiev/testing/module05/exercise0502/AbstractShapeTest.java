package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class AbstractShapeTest {
    Shape testShape = createInstance();

    @Test
    void calculateArea_ResultMustBeGreaterThan0() {
        assertTrue(Double.compare(testShape.calculateArea(), 0.0d) > 0,
            "The shape area must be greater than 0.");
    }

    @TestFactory
    Collection<DynamicTest> test4() {
        List<TestCase> listTestCasesForGetNameMethod = getTestCases();

        return listTestCasesForGetNameMethod.stream()
            .flatMap(testCase -> Stream.of(
                DynamicTest.dynamicTest(
                    "Testing getName() for '" + testCase.getShape().getName() + "'",
                    () -> assertEquals(testCase.getExpectedName(), testCase.getShape().getName())),
                DynamicTest.dynamicTest(
                    "Testing calculateArea() for '" + testCase.getShape().getName() + "'",
                    () -> {
                        if (testCase.getShape() instanceof Circle circle) {
                            assertEquals(
                                Math.PI * circle.getRadius() * circle.getRadius(),
                                circle.calculateArea(),
                                0.001d);
                        } else if (testCase.getShape() instanceof Square square) {
                            assertEquals(
                                square.getSide() * square.getSide(),
                                square.calculateArea(),
                                0.001d);
                        } else {
                            throw new UnsupportedOperationException(
                                "Test for " + testCase.getShape().getClass().getSimpleName()
                                    + " is not implemented yet");
                        }
                    })))
            .toList();
    }

    protected abstract Shape createInstance();

    protected abstract List<TestCase> getTestCases();

    static class TestCase {
        protected Shape shape;
        protected String expectedName;

        public TestCase(Shape shape, String expectedName) {
            this.shape = shape;
            this.expectedName = expectedName;
        }

        public Shape getShape() {
            return this.shape;
        }

        public String getExpectedName() {
            return this.expectedName;
        }
    }
}
