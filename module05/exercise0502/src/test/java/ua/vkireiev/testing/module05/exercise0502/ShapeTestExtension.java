package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ShapeTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final String SHAPE_KEY = "testShape";
    private static final ThreadLocal<Shape> CURRENT_SHAPE = new ThreadLocal<>();

    public static Shape getCurrentShape() {
        return CURRENT_SHAPE.get();
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        Shape shape = new Circle("Small Circle", 1.0d);
        context.getStore(ExtensionContext.Namespace.GLOBAL).put(SHAPE_KEY, shape);
        System.out.println("[Before] Testing shape: " + shape + ", " + shape.getName());
        CURRENT_SHAPE.set(shape);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Shape shape = context.getStore(ExtensionContext.Namespace.GLOBAL).get(SHAPE_KEY, Shape.class);
        if (shape.getName() == null || shape.getName().isEmpty()) {
            throw new IllegalStateException("Shape name must not be null or empty after test execution!");
        }
        System.out.println("[After]  Testing shape: " + shape + ", " + shape.getName());
        CURRENT_SHAPE.remove();
    }
}
