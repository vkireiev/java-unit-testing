package ua.vkireiev.testing.module07.exercise0702;

public class OrderService {
    private final InventoryManager inventoryManager;
    private final PaymentGateway paymentGateway;

    public OrderService(InventoryManager inventoryManager, PaymentGateway paymentGateway) {
        this.inventoryManager = inventoryManager;
        this.paymentGateway = paymentGateway;
    }

    public boolean processOrder(Order order) {
        if (inventoryManager.isInStock(order.getItem())) {
            return paymentGateway.processPayment(order.getAmount());
        } else {
            throw new OutOfStockException("Item out of stock");
        }
    }
}
