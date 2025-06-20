package ua.vkireiev.testing.module04.exercise0405;

public class OrderItem {
    private String itemName;
    private double price;

    public OrderItem(String itemName, double price) {
        super();
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return this.itemName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem [itemName=" + itemName
            + ", price=" + price
            + "]";
    }
}
