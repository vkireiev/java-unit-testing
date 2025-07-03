package ua.vkireiev.testing.module08.exercise0801;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Viktor Kireiev
 **/
@ExtendWith(MockitoExtension.class)
class DiscountCalculatorTest {

    @Mock
    private Customer customerMock;

    private DiscountCalculator discountCalculator;

    @BeforeEach
    void baforeEach() {
        discountCalculator = new DiscountCalculator();
        Mockito.clearInvocations(customerMock);
        assertNotNull(discountCalculator);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyLessThen5AndAgeLessThen65AndPurchaseAmountLessThen100_ThenReturnZero() {
        long yearsOfLoyalty = 0L;
        int age = 0;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty < 5L);
        assertTrue(age < 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.0d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyEquals5ndAgeLessThen65AndPurchaseAmountLessThen100_ThenReturnZero() {
        long yearsOfLoyalty = 5L;
        int age = 0;
        double purchaseAmount = 0.0d;

        assertEquals(5L, yearsOfLoyalty);
        assertTrue(age < 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.0d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyMoreThen5AndAgeLessThen65AndPurchaseAmountLessThen100_ThenReturnFivePercent() {
        long yearsOfLoyalty = 6L;
        int age = 0;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty > 5L);
        assertTrue(age < 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.05d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyLessThen5AndAgeEquals65AndPurchaseAmountLessThen100_ThenReturnZero() {
        long yearsOfLoyalty = 0L;
        int age = 65;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty < 5L);
        assertEquals(65, age);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.00d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyEquals5AndAgeEquals65AndPurchaseAmountLessThen100_ThenReturnZero() {
        long yearsOfLoyalty = 5L;
        int age = 65;
        double purchaseAmount = 0.0d;

        assertEquals(5L, yearsOfLoyalty);
        assertEquals(65, age);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.00d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyMoreThen5AndAgeEquals65AndPurchaseAmountLessThen100_ThenReturnFivePercent() {
        long yearsOfLoyalty = 6L;
        int age = 65;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty > 5L);
        assertEquals(65, age);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.05d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyLessThen5AndAgeMoreThen65AndPurchaseAmountLessThen100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 0L;
        int age = 66;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty < 5L);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyEquals5AndAgeMoreThen65AndPurchaseAmountLessThen100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 5L;
        int age = 66;
        double purchaseAmount = 0.0d;

        assertEquals(5L, yearsOfLoyalty);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyMoreThen5AndAgeMoreThen65AndPurchaseAmountLessThen100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 6L;
        int age = 66;
        double purchaseAmount = 0.0d;

        assertTrue(yearsOfLoyalty > 5L);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) < 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyLessThen5AndAgeMoreThen65AndPurchaseAmountMoreThen100_ThenReturnFifteenPercent() {
        long yearsOfLoyalty = 0L;
        int age = 66;
        double purchaseAmount = 101.0d;

        assertTrue(yearsOfLoyalty < 5L);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) > 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.15d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyEquals5AndAgeMoreThen65AndPurchaseAmountMoreThen100_ThenReturnFifteenPercent() {
        long yearsOfLoyalty = 5L;
        int age = 66;
        double purchaseAmount = 101.0d;

        assertEquals(5L, yearsOfLoyalty);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) > 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.15d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyMoreThen5AndAgeMoreThen65AndPurchaseAmountMoreThen100_ThenReturnFifteenPercent() {
        long yearsOfLoyalty = 6L;
        int age = 66;
        double purchaseAmount = 101.0d;

        assertTrue(yearsOfLoyalty > 5L);
        assertTrue(age > 65);
        assertTrue(Double.valueOf(purchaseAmount).compareTo(100.0d) > 0);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.15d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    // added
    @Test
    void calculateDiscount_WhenYearsOfLoyaltyLessThen5AndAgeMoreThen65AndPurchaseAmountEquals100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 0L;
        int age = 66;
        double purchaseAmount = 100.0d;

        assertTrue(yearsOfLoyalty < 5L);
        assertTrue(age > 65);
        assertEquals(100.0d, purchaseAmount, 0.0001d);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyEquals5AndAgeMoreThen65AndPurchaseAmountEquals100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 5L;
        int age = 66;
        double purchaseAmount = 100.0d;

        assertEquals(5L, yearsOfLoyalty);
        assertTrue(age > 65);
        assertEquals(100.0d, purchaseAmount, 0.0001d);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }

    @Test
    void calculateDiscount_WhenYearsOfLoyaltyMoreThen5AndAgeMoreThen65AndPurchaseAmountEquals100_ThenReturnTenPercent() {
        long yearsOfLoyalty = 6L;
        int age = 66;
        double purchaseAmount = 100.0d;

        assertTrue(yearsOfLoyalty > 5L);
        assertTrue(age > 65);
        assertEquals(100.0d, purchaseAmount, 0.0001d);

        Mockito.when(customerMock.getYearsOfLoyalty()).thenReturn(yearsOfLoyalty);
        Mockito.when(customerMock.getAge()).thenReturn(age);
        Mockito.when(customerMock.getPurchaseAmount()).thenReturn(purchaseAmount);

        double returnedResult = discountCalculator.calculateDiscount(customerMock);

        assertEquals(0.1d, returnedResult, 0.0001d);

        Mockito.verify(customerMock, Mockito.times(1)).getYearsOfLoyalty();
        Mockito.verify(customerMock, Mockito.times(1)).getAge();
        Mockito.verify(customerMock, Mockito.times(1)).getPurchaseAmount();
        Mockito.verifyNoMoreInteractions(customerMock);
    }
}
