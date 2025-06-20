package ua.vkireiev.testing.module04.exercise0405;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderProcessorTest {
    private final List<OrderItem> items = List.of(
        new OrderItem("Loading", 100.0d),
        new OrderItem("Insurance", 250.0d),
        new OrderItem("Transportation", 1000.0d),
        new OrderItem("Unloading", 100.0d),
        new OrderItem("Storage", 250.0d));

    @Spy
    private OrderProcessor orderProcessor = new OrderProcessor();

    @Captor
    ArgumentCaptor<List<OrderItem>> itemsCaptor;

    @Test
    void test() {
        orderProcessor.processOrders(new ArrayList<>(items));

        Mockito.verify(orderProcessor).processOrders(itemsCaptor.capture());
        List<OrderItem> capturedItems = itemsCaptor.getValue();

        assertNotEquals(items.size(), capturedItems.size());
        List<OrderItem> difference = new ArrayList<>(capturedItems);
        difference.removeAll(items);
        assertFalse(difference.isEmpty());
        assertTrue(difference.stream()
            .anyMatch(item -> item.getItemName().equalsIgnoreCase("Processing Fee")
                && item.getPrice() == 5.0d));
    }
}
