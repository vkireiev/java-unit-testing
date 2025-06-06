package ua.vkireiev.testing.module04.exercise0401;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @Mock
    PersonValidator personValidatorMock;

    @InjectMocks
    PersonService personService;

    @ParameterizedTest
    @MethodSource("provideArgumentsForSuccessScenario")
    void test_WhenCallWithSuccessScenario(Person testPerson, int testLeftBound, int testRightBound) {

        when(personValidatorMock.validatePersonAge(
            Mockito.argThat(new CustomPersonAgeMatcher(testLeftBound, testRightBound))))
            .thenReturn(true);

        assertTrue(personService.verifyPerson(testPerson));

        verify(personValidatorMock).validatePersonAge(testPerson);
    }

    private static Stream<Arguments> provideArgumentsForSuccessScenario() {
        return Stream.of(
            Arguments.of(new Person(18), 18, 65),
            Arguments.of(new Person(65), 18, 65),
            Arguments.of(new Person(25), 18, 65));
    }
}
