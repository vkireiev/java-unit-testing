package ua.vkireiev.testing.module08.exercise0801;

import java.time.LocalDate;

/**
 * @author Viktor Kireiev
 **/
public class Customer {
    private long id;
    private int age;
    private LocalDate registered;
    private double PurchaseAmount;

    public Customer(long id, int age, LocalDate registered, double purchaseAmount) {
        super();
        this.id = id;
        this.age = age;
        this.registered = registered;
        PurchaseAmount = purchaseAmount;
    }

    public long getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public long getYearsOfLoyalty() {
        return java.time.temporal.ChronoUnit.YEARS.between(this.registered, LocalDate.now());
    }

    public double getPurchaseAmount() {
        return this.PurchaseAmount;
    }
}
