package SolidPrinciples.DependencyInversion.NotificationExample;

/**
 * DIP: UserService depends on MessageSender (abstraction), not EmailSender (concretion).
 * The sender is injected so we can test or swap implementations.
 *
 * TODO: Add a field: private final MessageSender messageSender;
 * TODO: Add constructor UserService(MessageSender messageSender) and assign the field.
 * TODO: Implement notifyUser(String userId, String message) to call messageSender.send(userId, message).
 */
public class UserService {

    // Injected abstraction (DIP)
    private final MessageSender messageSender;

    public UserService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void notifyUser(String userId, String message) {
        // TODO: messageSender.send(userId, message);
        messageSender.send(userId,message);
    }
}
