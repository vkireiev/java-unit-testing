package ua.vkireiev.testing.module04.exercise0403;

import java.math.BigDecimal;

public class BankService {

    public boolean performPayment(AccountDetails details, BigDecimal amount) throws InsufficientFundsException {
        if (details.getBalance().compareTo(amount) >= 0) {
            details.reduceBalance(amount);
            
            return true;
        } else {
            throw new InsufficientFundsException("Insufficient funds (accountId = " + details.getId()
                + "; accountBalance=" + details.getBalance()
                + "; amount=" + amount + ")");
        }
    }
}
