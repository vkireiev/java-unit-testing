package ua.vkireiev.testing.module04.exercise0401;

public class PersonService {
    private final PersonValidator validationPersonService;

    public PersonService(PersonValidator validationPersonService) {
        super();
        this.validationPersonService = validationPersonService;
    }

    public boolean verifyPerson(Person person) {
        return validationPersonService.validatePersonAge(person);
    }
}
