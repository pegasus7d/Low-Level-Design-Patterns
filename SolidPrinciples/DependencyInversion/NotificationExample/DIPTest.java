package SolidPrinciples.DependencyInversion.NotificationExample;

/**
 * Tests for Dependency Inversion: UserService depends on MessageSender interface.
 * TODO: In testDependencyInversion(), create UserService with an EmailSender and call notifyUser.
 */
public class DIPTest {

    public static void main(String[] args) {
        System.out.println("=== Dependency Inversion Principle Tests ===\n");

        testDependencyInversion();
        testWithEmailSender();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Apply DIP: create MessageSender sender = new EmailSender(),
    // then UserService service = new UserService(sender), then service.notifyUser("user1", "Hello")
    private static void testDependencyInversion() {
        System.out.println("Test 1: UserService with injected MessageSender (your assignment)");

        MessageSender sender = new EmailSender();
        UserService service = new UserService(sender);
        service.notifyUser("user1", "Hello");

        System.out.println("  ✓ Passed\n");
    }

    private static void testWithEmailSender() {
        System.out.println("Test 2: EmailSender implements MessageSender");
        MessageSender s = new EmailSender();
        s.send("test@example.com", "Test message");
        System.out.println("  ✓ Passed\n");
    }
}
