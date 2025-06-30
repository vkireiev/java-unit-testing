package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ShapeTestExecutionCallback implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private final Shape shape;

    public ShapeTestExecutionCallback(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (shape.getName() == null || shape.getName().isBlank()) {
            throw new IllegalStateException("Shape name must not be null or empty");
        }
        System.out.println("[After]  Testing shape: " + shape.getName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("[Before] Testing shape: " + shape.getName());
    }
}
