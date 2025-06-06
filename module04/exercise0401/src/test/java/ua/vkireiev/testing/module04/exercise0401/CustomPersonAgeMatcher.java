package ua.vkireiev.testing.module04.exercise0401;

import org.mockito.ArgumentMatcher;

public class CustomPersonAgeMatcher implements ArgumentMatcher<Person> {
    private final int leftBound;
    private final int rightBound;

    public CustomPersonAgeMatcher(int leftBound, int rightBound) {
        super();
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    @Override
    public boolean matches(Person person) {
        return (person != null
            && person.getAge() >= leftBound
            && person.getAge() <= rightBound);
    }
}
