package ua.vkireiev.testing.module05.exercise0503.task01;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

class UtilityClassTest {

    @Test
    void test() {
        try (MockedStatic<UtilityClass> mockedUtilityClass = mockStatic(UtilityClass.class)) {
            String expectedResult = "Mocked Status";

            mockedUtilityClass.when(UtilityClass::getStatus).thenReturn(expectedResult);

            String returnedResult = UtilityClass.getStatus();

            assertEquals(expectedResult, returnedResult);

            mockedUtilityClass.verify(UtilityClass::getStatus, times(1));
            mockedUtilityClass.verifyNoMoreInteractions();
        }
    }
}
