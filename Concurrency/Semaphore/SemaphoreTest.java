package Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Test: Semaphore(2) — at most 2 threads print "has permit" at a time.
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Semaphore Test ===\n");
        Semaphore sem = new Semaphore(2);
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(new PermitTask(sem), "T" + (i + 1));
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("=== Done ===");
    }
}
