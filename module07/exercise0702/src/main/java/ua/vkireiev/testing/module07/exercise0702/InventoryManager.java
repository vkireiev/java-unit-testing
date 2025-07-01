package ua.vkireiev.testing.module07.exercise0702;

import java.util.Map;

public class InventoryManager {
    private static Map<Item, Integer> stock = Map.of();

    public boolean isInStock(Item item) {
        return (stock.containsKey(item) && stock.get(item) > 0);
    }
}
