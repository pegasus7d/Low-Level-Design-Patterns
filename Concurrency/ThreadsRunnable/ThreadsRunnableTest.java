package Concurrency.ThreadsRunnable;

/**
 * Test: Create threads using Thread + Runnable and start them.
 * TODO: In testWithRunnable(), create two threads (e.g. Thread with new PrintTask("A"), PrintTask("B")), start both, join both.
 */
public class ThreadsRunnableTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Threads & Runnable Test ===\n");
        testWithRunnable();
        System.out.println("\n=== Done ===");
    }

    private static void testWithRunnable() throws InterruptedException {
        // TODO: Create two threads with new PrintTask("A") and PrintTask("B"), start both, join both
        Thread t1 = new Thread(new PrintTask("A"));
        Thread t2 = new Thread(new PrintTask("B"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
