package ua.vkireiev.testing.module04.exercise0403;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PaymentProcessorTest {

    @Test
    void testProcessPaymentSuccess() throws InsufficientFundsException {
        BankService bankServiceSpy = Mockito.spy(new BankService());
        PaymentProcessor paymentProcessor = new PaymentProcessor(bankServiceSpy);
        AccountDetails testAccountDetails = new AccountDetails(1, BigDecimal.valueOf(1000), false);
        BigDecimal testAmount = BigDecimal.valueOf(250);

        Mockito.when(bankServiceSpy.performPayment(testAccountDetails, testAmount)).thenReturn(true);

        assertTrue(paymentProcessor.processPayment(testAccountDetails, testAmount));

        Mockito.verify(bankServiceSpy, Mockito.atMostOnce()).performPayment(testAccountDetails, testAmount);
    }
}
