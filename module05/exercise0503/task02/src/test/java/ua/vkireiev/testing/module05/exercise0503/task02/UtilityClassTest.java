package ua.vkireiev.testing.module05.exercise0503.task02;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UtilityClass.class})
public class UtilityClassTest {

    // Ignored because parrent module uses JDK17
    // To run this @Test - open this task as an independent project and remove @Ignore
    @Ignore
    @Test
    public void test() {
        String expectedResult = "Mocked Status";
        PowerMockito.mockStatic(UtilityClass.class);

        PowerMockito.when(UtilityClass.getStatus()).thenReturn(expectedResult);

        String returnedResult = UtilityClass.getStatus();

        assertEquals(expectedResult, returnedResult);

        PowerMockito.verifyStatic(UtilityClass.class);
        UtilityClass.getStatus();
    }
}
