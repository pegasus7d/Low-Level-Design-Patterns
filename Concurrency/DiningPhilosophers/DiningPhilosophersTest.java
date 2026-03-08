package Concurrency.DiningPhilosophers;

/**
 * Test: 5 philosophers each eat a few times (no deadlock).
 */
public class DiningPhilosophersTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Dining Philosophers Test ===\n");
        DiningPhilosophers dp = new DiningPhilosophers();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < 2; j++) {
                        dp.wantsToEat(id,
                                () -> System.out.println(id + " pick left"),
                                () -> System.out.println(id + " pick right"),
                                () -> System.out.println(id + " eat"),
                                () -> {},
                                () -> {});
                    }
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("=== Done ===");
    }
}
