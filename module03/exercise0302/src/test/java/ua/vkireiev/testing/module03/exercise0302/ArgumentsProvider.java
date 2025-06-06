package ua.vkireiev.testing.module03.exercise0302;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Set;

public class ArgumentsProvider {
    private ArgumentsProvider() {
    }

    protected static Set<Arguments> provideArgumentsForAdditionMethod() {
        return Set.of(
            Arguments.of(0.0d, 0.0d, 0.0d),
            Arguments.of(1.0d, 0.0d, 1.0d),
            Arguments.of(0.0d, 1.0d, 1.0d),
            Arguments.of(1.0d, 1.0d, 2.0d),
            Arguments.of(-1.0d, 1.0d, 0.0d),
            Arguments.of(1.0d, -1.0d, 0.0d),
            Arguments.of(-1.0d, -1.0d, -2.0d));
    }

    protected static Set<Arguments> provideArgumentsForSubtractionMethod() {
        return Set.of(
            Arguments.of(0.0d, 0.0d, 0.0d),
            Arguments.of(1.0d, 0.0d, 1.0d),
            Arguments.of(0.0d, 1.0d, -1.0d),
            Arguments.of(1.0d, 1.0d, 0.0d),
            Arguments.of(-1.0d, 1.0d, -2.0d),
            Arguments.of(1.0d, -1.0d, 2.0d),
            Arguments.of(-1.0d, -1.0d, 0.0d));
    }

    protected static Set<Arguments> provideArgumentsForMultiplicationMethod() {
        return Set.of(
            Arguments.of(0.0d, 0.0d, 0.0d),
            Arguments.of(1.0d, 0.0d, 0.0d),
            Arguments.of(0.0d, 1.0d, 0.0d),
            Arguments.of(1.0d, 1.0d, 1.0d),
            Arguments.of(-1.0d, 1.0d, -1.0d),
            Arguments.of(1.0d, -1.0d, -1.0d),
            Arguments.of(-1.0d, -1.0d, 1.0d));
    }

    protected static Set<Arguments> provideArgumentsForDivisionMethodWithException() {
        return Set.of(
            Arguments.of(0.0d, 0.0d),
            Arguments.of(1.0d, 0.0d),
            Arguments.of(-1.0d, 0.0d));
    }

    protected static Set<Arguments> provideArgumentsForDivisionMethod() {
        return Set.of(
            Arguments.of(0.0d, 1.0d, 0.0d),
            Arguments.of(1.0d, 1.0d, 1.0d),
            Arguments.of(-1.0d, 1.0d, -1.0d),
            Arguments.of(1.0d, -1.0d, -1.0d),
            Arguments.of(-1.0d, -1.0d, 1.0d),

            Arguments.of(5.0d, 2.0d, 2.5d),
            Arguments.of(5.0d, -2.0d, -2.5d),
            Arguments.of(-5.0d, 2.0d, -2.5d),
            Arguments.of(-5.0d, -2.0d, 2.5d),
            Arguments.of(5.0d, 5.0d, 1.0d));
    }
}
