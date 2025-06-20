package ua.vkireiev.testing.module05.exercise0501;

import ua.vkireiev.testing.module05.exercise0501.exception.InvalidAlertException;

public class NotificationService {
    private final AlertGateway gateway;

    public NotificationService(AlertGateway gateway) {
        this.gateway = gateway;
    }

    public void sendAlert(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new InvalidAlertException("Alert message is invalid");
        }
        
        gateway.send(message);
    }
}
