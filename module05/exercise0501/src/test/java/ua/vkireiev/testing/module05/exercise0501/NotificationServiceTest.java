package ua.vkireiev.testing.module05.exercise0501;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.vkireiev.testing.module05.exercise0501.exception.InvalidAlertException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    AlertGateway alertGatewayMock;

    @InjectMocks
    NotificationService notificationService;

    @ParameterizedTest
    @NullAndEmptySource
    void sendAlert_WhenCallWithInvalidMMessage_ThenException(String testMessage) {

        assertTrue(Objects.isNull(testMessage) || testMessage.isEmpty());

        InvalidAlertException exception = assertThrows(
            InvalidAlertException.class,
            () -> notificationService.sendAlert(testMessage));

        assertTrue(exception.getMessage().equalsIgnoreCase("Alert message is invalid"));

        Mockito.verifyNoInteractions(alertGatewayMock);
    }

    @Test
    void sendAlert_WhenCallWithValidMessage_ThenSendMessage() {
        String testMessage = "Test message";

        assertNotNull(testMessage);
        assertFalse(testMessage.isEmpty());

        Mockito.doNothing().when(alertGatewayMock).send(testMessage);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        notificationService.sendAlert(testMessage);

        Mockito.verify(alertGatewayMock).send(messageCaptor.capture());
        String capturedMessage = messageCaptor.getValue();
        assertTrue(capturedMessage.contains(testMessage));

        Mockito.verify(alertGatewayMock, Mockito.times(1)).send(testMessage);
        Mockito.verifyNoMoreInteractions(alertGatewayMock);
    }
}
