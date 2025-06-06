package ua.vkireiev.testing.module04.exercise0401;

public class Person {
    private int age;

    Person() {
    }

    public Person(int age) {
        super();
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person [age=" + this.age + "]";
    }
}
