package ua.vkireiev.testing.module04.exercise0404;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        this.items.add(item);
    }

    public String removeItem(int index) {
        if (index >= 0 && index < this.items.size()) {
            return this.items.remove(index);
        }

        return null;
    }

    // Other business logic methods...
}
