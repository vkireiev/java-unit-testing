package ua.vkireiev.testing.module04.exercise0403;

import java.math.BigDecimal;

public class AccountDetails {
    private long id;
    private BigDecimal balance;
    private boolean lock;

    public AccountDetails(long id, BigDecimal balance, boolean lock) {
        super();
        this.id = id;
        this.balance = balance;
        this.lock = lock;
    }

    public long getId() {
        return this.id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public boolean isLock() {
        return this.lock;
    }

    public BigDecimal reduceBalance(BigDecimal amount) {
        this.balance = balance.subtract(amount);

        return this.balance;
    }

    @Override
    public String toString() {
        return "AccountDetails [id=" + this.id
            + ", balance=" + this.balance
            + ", lock=" + this.lock
            + "]";
    }
}
