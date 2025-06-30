package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ShapeViaTemplateTest {

    @TestTemplate
    @ExtendWith(ShapeTestInvocationContextProvider.class)
    void test5(Shape shape) {
        System.out.println("[Test]   Executing test with shape: " + shape.getName());
        assertDoesNotThrow(shape::calculateArea);
    }
}
