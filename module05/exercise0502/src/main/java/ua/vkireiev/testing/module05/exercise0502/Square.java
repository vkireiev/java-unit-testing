package ua.vkireiev.testing.module05.exercise0502;

public class Square extends Shape {
    private final double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Square [side=" + this.side + "]";
    }
}
