package ua.vkireiev.testing.module07.exercise0702;

import java.util.Objects;

public class Order {
    private long id;
    private Item item;
    private double amount;

    public Order(long id, Item item, double amount) {
        super();
        this.id = id;
        this.item = item;
        this.amount = amount;
    }

    public long getId() {
        return this.id;
    }

    public Item getItem() {
        return this.item;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order [id=" + this.id +
            ", item=" + this.item +
            ", amount=" + this.amount +
            "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return this.id == other.id;
    }
}
