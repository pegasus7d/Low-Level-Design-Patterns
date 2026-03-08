package Concurrency.Synchronization;

/**
 * Test: Multiple threads increment shared Counter; without sync result < 1000, with sync = 1000.
 * TODO: Create Counter, start 10 threads each incrementing 100 times, join all, assert getCount() == 1000.
 */
public class SynchronizationTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Synchronization Test ===\n");
        Counter counter = new Counter();
        int numThreads = 10;
        int incrementsPerThread = 100;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        int result = counter.getCount();
        System.out.println("Count: " + result + " (expected 1000)");
        assert result == 1000 : "Expected 1000, got " + result;
        System.out.println("=== Done ===");
    }
}
