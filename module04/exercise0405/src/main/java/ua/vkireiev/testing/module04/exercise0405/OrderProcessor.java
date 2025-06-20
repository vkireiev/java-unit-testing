package ua.vkireiev.testing.module04.exercise0405;

import java.util.List;

public class OrderProcessor {

    public void processOrders(List<OrderItem> items) {
        items.add(new OrderItem("Processing Fee", 5.0));
    }
}
