package ua.vkireiev.testing.module07.exercise0702;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private InventoryManager inventoryManager;
    @Mock
    private PaymentGateway paymentGateway;

    private OrderService orderService;

    @BeforeEach
    void beforeEach() {
        orderService = new OrderService(inventoryManager, paymentGateway);
        assertNotNull(orderService);
    }

    @Test
    void processOrder_GivenItemInStockAndProcessPaymentSuccess_ThenReturnTrue() {
        // Given
        Item testItem = new Item(1, "Item #1", 100.0d);
        BDDMockito.given(inventoryManager.isInStock(Mockito.any(Item.class))).willReturn(true);
        BDDMockito.given(paymentGateway.processPayment(anyDouble())).willReturn(true);

        // When
        boolean returnedResult = orderService.processOrder(new Order(1, testItem, testItem.getPrice()));

        // Then
        assertTrue(returnedResult, "Order should be processed successfully");

        // Verify the interaction with the mock
        BDDMockito.then(inventoryManager).should().isInStock(testItem);
        BDDMockito.then(inventoryManager).shouldHaveNoMoreInteractions();
        BDDMockito.then(paymentGateway).should().processPayment(testItem.getPrice());
        BDDMockito.then(paymentGateway).shouldHaveNoMoreInteractions();
    }

    @Test
    void processOrder_GivenItemOutOfStock_ThenException() {
        // Given
        Item testItem = new Item(1, "Item #1", 100.0d);
        BDDMockito.given(inventoryManager.isInStock(Mockito.any(Item.class))).willReturn(false);

        // When & Then
        OutOfStockException exception = assertThrows(OutOfStockException.class,
            () -> orderService.processOrder(new Order(1, testItem, testItem.getPrice())));
        assertTrue(exception.getMessage().equalsIgnoreCase("Item out of stock"));

        // Verify the interaction with the mock
        BDDMockito.then(inventoryManager).should().isInStock(testItem);
        BDDMockito.then(inventoryManager).shouldHaveNoMoreInteractions();
        BDDMockito.then(paymentGateway).shouldHaveNoInteractions();
    }

    @Test
    void processOrder_GivenItemInStockAndProcessPaymentFailed_ThenReturnFalse() {
        // Given
        Item testItem = new Item(1, "Item #1", 100.0d);
        BDDMockito.given(inventoryManager.isInStock(Mockito.any(Item.class))).willReturn(true);
        BDDMockito.given(paymentGateway.processPayment(anyDouble())).willReturn(false);

        // When
        boolean returnedResult = orderService.processOrder(new Order(1, testItem, testItem.getPrice()));

        // Then
        assertFalse(returnedResult, "Order should be not processed successfully");

        // Verify the interaction with the mock
        BDDMockito.then(inventoryManager).should().isInStock(testItem);
        BDDMockito.then(inventoryManager).shouldHaveNoMoreInteractions();
        BDDMockito.then(paymentGateway).should().processPayment(testItem.getPrice());
        BDDMockito.then(paymentGateway).shouldHaveNoMoreInteractions();
    }
}
