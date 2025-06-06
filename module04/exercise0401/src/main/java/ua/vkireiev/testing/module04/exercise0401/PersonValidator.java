package ua.vkireiev.testing.module04.exercise0401;

public class PersonValidator {

    public boolean validatePersonAge(Person person) {
        return (person != null
            && person.getAge() >= 18
            && person.getAge() <= 65);
    }
}
