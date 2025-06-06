package ua.vkireiev.testing.module03.exercise0303;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ua.vkireiev.testing.module03.exercise0303.exception.InsufficientFundsException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @ParameterizedTest(name = "[{index}] withdrawal amount = {0} < balance = {1} => throw InsufficientFundsException")
    @MethodSource("provideArgumentsForInsufficientFundsExceptionScenario")
    void withdraw_WhenCallAndWithdrawalAmountBiggerThanBalance_ThenInsufficientFundsException(
        double initialBalance, double withdrawalAmount) {

        assertTrue(Double.compare(initialBalance, withdrawalAmount) < 0);

        Exception exception = assertThrows(
            InsufficientFundsException.class,
            () -> {
                new BankAccount(initialBalance).withdraw(withdrawalAmount);
            });

        assertInstanceOf(InsufficientFundsException.class, exception);
        assertTrue(exception.getMessage().contains("Insufficient funds for withdrawal"));
    }

    @ParameterizedTest(name = "[{index}] withdrawal amount = {0} < 0 => throw IllegalArgumentException")
    @ValueSource(doubles = {-0.001d, -1.0d})
    void withdraw_WhenCallAndWithdrawalAmountIsNegative_ThenIllegalArgumentException(double withdrawalAmount) {

        assertTrue(Double.compare(0.0d, withdrawalAmount) > 0);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                new BankAccount(0.0d).withdraw(withdrawalAmount);
            });
        assertInstanceOf(IllegalArgumentException.class, exception);
        assertTrue(exception.getMessage().contains("Withdrawal amount can not be less than 0"));
    }

    @ParameterizedTest(name = "[{index}] withdrawal amount = {0} >= balance = {1} => change balance")
    @MethodSource("provideArgumentsForSuccessScenario")
    void withdraw_WithdrawalAmountEqualsOrSmallerThanBalance_ThenChangeBalance(
        double initialBalance, double withdrawalAmount) throws InsufficientFundsException {

        BankAccount bankAccount = new BankAccount(initialBalance);
        double balanceBeforeWithdrawal = bankAccount.getBalance();

        bankAccount.withdraw(withdrawalAmount);

        double balanceAfterWithdrawal = bankAccount.getBalance();

        assertNotEquals(balanceBeforeWithdrawal, balanceAfterWithdrawal, 0.00001d);
    }

    private static Stream<Arguments> provideArgumentsForInsufficientFundsExceptionScenario() {
        return Stream.of(
            Arguments.of(0.0d, 0.001d),
            Arguments.of(1.0d, 2.0d));
    }

    private static Stream<Arguments> provideArgumentsForSuccessScenario() {
        return Stream.of(
            Arguments.of(1.0d, 0.001d),
            Arguments.of(1.0d, 1.0d),
            Arguments.of(10.0d, 2.0d));
    }
}
