package Concurrency.Locks;

/**
 * Test: Multiple threads increment ResourceWithLock; result should be 1000.
 */
public class LocksTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Locks Test ===\n");
        ResourceWithLock resource = new ResourceWithLock();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) resource.increment();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Count: " + resource.getCount() + " (expected 1000)");
        assert resource.getCount() == 1000;
        System.out.println("=== Done ===");
    }
}
