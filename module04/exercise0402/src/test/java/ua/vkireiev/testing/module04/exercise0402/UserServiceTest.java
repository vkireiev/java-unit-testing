package ua.vkireiev.testing.module04.exercise0402;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.invocation.InterceptedInvocation;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.MethodInvocationReport;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    long defaultAnswer = -1L;
    long stubbedAnswer = 10L;
    private List<String> invocations;

    private InvocationListener listener = new InvocationListener() {
        @Override
        public void reportInvocation(MethodInvocationReport invocationReport) {
            StringBuilder str = new StringBuilder();
            str.append(((InterceptedInvocation) invocationReport.getInvocation()).getMethod().getName());
            str.append(Stream.of(((InterceptedInvocation) invocationReport.getInvocation()).getMethod().getParameters())
                .map(t -> t.getType().getSimpleName() + " " + t.getName())
                .collect(Collectors.joining(", ", "(", ")")));

            invocations.add(str.toString());
        }
    };

    private UserRepository userRepositoryMock = mock(UserRepository.class,
        withSettings()
            .serializable()
            .verboseLogging()
            .invocationListeners(listener)
            .defaultAnswer(invocation -> defaultAnswer));
    
    private UserService userService = new UserService(userRepositoryMock);

    @BeforeEach
    void beforeEach() {
        invocations = new LinkedList<>();
        invocations.add("===== START invocations =====");
    }

    @AfterEach
    void afterEach() {
        invocations.add("=====  END  invocations =====");
        invocations.add("");
        invocations.forEach(System.out::println);
    }

    @Test
    void test_WithUnstubbedCall() {
        long actualResult = userService.countByLock(true);

        assertEquals(defaultAnswer, actualResult);
        assertNotEquals(stubbedAnswer, actualResult);

        Mockito.verify(userRepositoryMock, Mockito.atMostOnce()).countByLock(true);
        Mockito.verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    void test_WithStubbedCall() {

        Mockito.when(userRepositoryMock.countByLock(true))
            .thenReturn(stubbedAnswer);

        long actualResult = userService.countByLock(true);

        assertEquals(stubbedAnswer, actualResult);
        assertNotEquals(defaultAnswer, actualResult);

        Mockito.verify(userRepositoryMock, Mockito.atMostOnce()).countByLock(true);
        Mockito.verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    void test() {
        UserRepository testUserRepositoryMock = mock(UserRepository.class,
            withSettings()
                .serializable()
                .verboseLogging()
                .invocationListeners(listener)
                .defaultAnswer(invocation -> {
                    if (invocation.getMethod().getReturnType().equals(long.class)) {
                        return defaultAnswer;
                    }
                    if (invocation.getMethod().getReturnType().equals(String.class)) {
                        return "Default answer";
                    }
                    if (invocation.getMethod().getReturnType().equals(User.class)) {
                        return new User(1, "john", "qwerty");
                    }

                    return "Default answer";
                }));
        UserService testUserService = new UserService(testUserRepositoryMock);

        System.out.println("==================");
        System.out.println(testUserService.get(5L));
        System.out.println(testUserService.countByLock(true));
        System.out.println(testUserService.countByLock(false));
        System.out.println("==================\n");

        Mockito.when(testUserRepositoryMock.countByLock(true))
            .thenReturn(stubbedAnswer);
        Mockito.when(testUserRepositoryMock.get(5L))
            .thenReturn(new User(2, "Viktor", "qwerty"));

        System.out.println("==================");
        System.out.println(testUserService.get(5L));
        System.out.println(testUserService.countByLock(true));
        System.out.println(testUserService.countByLock(false));
        System.out.println("==================\n");

        long actualResult = testUserService.countByLock(true);

        assertEquals(stubbedAnswer, actualResult);
        assertNotEquals(defaultAnswer, actualResult);

        Mockito.verify(testUserRepositoryMock, Mockito.times(3)).countByLock(true);
        Mockito.verify(testUserRepositoryMock, Mockito.times(2)).countByLock(false);
        Mockito.verify(testUserRepositoryMock, Mockito.times(2)).get(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(testUserRepositoryMock);
    }
}
