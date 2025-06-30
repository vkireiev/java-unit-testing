package ua.vkireiev.testing.module05.exercise0502;

public abstract class Shape {
    private final String name;

    public Shape(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract double calculateArea();
}
