package Concurrency.ThreadPoolLifecycle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test: Use a fixed thread pool (e.g. 2 threads), submit 3 workers, shutdown, awaitTermination.
 * TODO: Create ExecutorService with Executors.newFixedThreadPool(2), submit 3 Worker tasks, shutdown(), awaitTermination(5, TimeUnit.SECONDS).
 */
public class ThreadPoolLifecycleTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Pool & Lifecycle Test ===\n");
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            pool.submit(new Worker());
        }
        pool.shutdown();
        boolean done = pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Pool shutdown: " + done);
        assert done : "Pool should terminate within 5 seconds";
        System.out.println("=== Done ===");
    }
}
