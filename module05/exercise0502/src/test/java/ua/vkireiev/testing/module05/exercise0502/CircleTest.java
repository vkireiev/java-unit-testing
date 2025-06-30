package ua.vkireiev.testing.module05.exercise0502;

import java.util.List;

class CircleTest extends AbstractShapeTest {

    @Override
    protected Shape createInstance() {
        return new Circle(1.0d);
    }

    @Override
    protected List<TestCase> getTestCases() {
        return List.of(
            new TestCase(new Circle("Small Circle", 1.0d), "Small Circle"),
            new TestCase(new Circle("Middle Circle", 2.0d), "Middle Circle"),
            new TestCase(new Circle("Big Circle", 3.0d), "Big Circle"));
    }
}
