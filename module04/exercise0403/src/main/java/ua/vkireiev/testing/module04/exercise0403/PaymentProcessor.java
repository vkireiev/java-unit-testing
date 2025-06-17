package ua.vkireiev.testing.module04.exercise0403;

import java.math.BigDecimal;

public class PaymentProcessor {
    private final BankService bankService;

    public PaymentProcessor(BankService bankService) {
        super();
        this.bankService = bankService;
    }

    public boolean processPayment(AccountDetails details, BigDecimal amount) {
        try {
            return bankService.performPayment(details, amount);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
            return false;
        }
    }
}
