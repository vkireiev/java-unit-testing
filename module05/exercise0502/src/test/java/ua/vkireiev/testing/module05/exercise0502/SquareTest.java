package ua.vkireiev.testing.module05.exercise0502;

import java.util.List;

class SquareTest extends AbstractShapeTest {

    @Override
    protected Shape createInstance() {
        return new Square(3.0d);
    }

    @Override
    protected List<TestCase> getTestCases() {
        return List.of(
            new TestCase(new Square("Small Square", 1.0d), "Small Square"),
            new TestCase(new Square("Middle Square", 2.0d), "Middle Square"),
            new TestCase(new Square("Big Square", 3.0d), "Big Square"));
    }
}
