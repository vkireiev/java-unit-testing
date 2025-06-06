package ua.vkireiev.testing.module03.exercise0303;

import ua.vkireiev.testing.module03.exercise0303.exception.InsufficientFundsException;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (Double.compare(0.0d, amount) > 0) {
            throw new IllegalArgumentException("Withdrawal amount can not be less than 0");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }

        this.balance -= amount;
    }
}
