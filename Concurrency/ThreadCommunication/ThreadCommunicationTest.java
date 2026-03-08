package Concurrency.ThreadCommunication;

/**
 * Test: Producer sets "Hello", consumer waits and prints it.
 */
public class ThreadCommunicationTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Communication (wait/notify) Test ===\n");
        SharedBuffer buffer = new SharedBuffer();
        final String[] received = new String[1];
        Thread consumer = new Thread(() -> {
            try {
                received[0] = buffer.getMessage();
                System.out.println("Consumer got: " + received[0]);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
        Thread.sleep(100);
        buffer.setMessage("Hello");
        consumer.join();
        assert "Hello".equals(received[0]) : "Expected Hello, got " + received[0];
        System.out.println("=== Done ===");
    }
}
