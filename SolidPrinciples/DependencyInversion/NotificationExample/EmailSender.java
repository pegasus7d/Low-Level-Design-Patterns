package SolidPrinciples.DependencyInversion.NotificationExample;

/**
 * Concrete implementation of MessageSender. High-level code depends on MessageSender, not this class.
 */
public class EmailSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Email to " + to + ": " + message);
    }
}
