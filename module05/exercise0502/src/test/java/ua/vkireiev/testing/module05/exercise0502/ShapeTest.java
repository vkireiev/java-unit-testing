package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ShapeTest {

    @Test
    void test1() {
        Shape shapeMock = Mockito.mock(Shape.class);
        final String expectedResult = "Shape#Name";
        final double expectedArea = 42.0;

        Mockito.when(shapeMock.getName()).thenReturn(expectedResult);
        Mockito.when(shapeMock.calculateArea()).thenReturn(expectedArea);

        String actualResult = shapeMock.getName();
        double actualArea = shapeMock.calculateArea();

        assertEquals(expectedArea, actualArea);
        assertEquals(expectedResult, actualResult);

        Mockito.verify(shapeMock, Mockito.times(1)).getName();
        Mockito.verify(shapeMock, Mockito.times(1)).calculateArea();
        Mockito.verifyNoMoreInteractions(shapeMock);
    }

    @Test
    void test2() {
        final String expectedResult = "Shape#Name";
        Shape shape = new Shape("Shape#Name") {
            @Override
            public double calculateArea() {
                throw new UnsupportedOperationException("Not implemented yet");
            }
        };

        String actualResult = shape.getName();

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "[{index}] Shape={0}, expectedResult={1}")
    @MethodSource("provideShapeAndExpectedResultForCalculateAreaMethod")
    void test3(Shape parameterizedShape, double expectedResult) {
        assertEquals(expectedResult, parameterizedShape.calculateArea(), 0.001d);
    }

    @Test
    @ExtendWith(ShapeTestExtension.class)
    void test5() {
        Shape testShape = ShapeTestExtension.getCurrentShape();
        System.out.println("[method] Testing shape: " + testShape + ", " + testShape.getName());
        assertDoesNotThrow(testShape::calculateArea);
    }

    private static Stream<Arguments> provideShapeAndExpectedResultForCalculateAreaMethod() {
        return Stream.of(
            Arguments.of(new Circle(1.0d), Math.PI * 1.0d * 1.0d),
            Arguments.of(new Circle(2.0d), Math.PI * 2.0d * 2.0d),
            Arguments.of(new Square(1.0d), 1.0d),
            Arguments.of(new Square(3.0d), 9.0d));
    }
}
