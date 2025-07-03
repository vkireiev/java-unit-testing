package ua.vkireiev.testing.module08.exercise0802;

import ua.vkireiev.testing.module08.exercise0802.controller.BookController;

/**
 * @author Viktor Kireiev
 */
public class MainApp {
    public static void main(String[] args) {
        new MainApp().start();
    }

    public void start() {
        BookController controller = new BookController();
        controller.run();
    }
}
