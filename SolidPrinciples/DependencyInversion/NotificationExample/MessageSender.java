package SolidPrinciples.DependencyInversion.NotificationExample;

/**
 * DIP: High-level modules should depend on abstractions, not concretions.
 * This interface is the abstraction; EmailSender and SmsSender implement it.
 */
public interface MessageSender {
    void send(String to, String message);
}
