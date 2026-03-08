package Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Concurrency topic 7: Semaphore — limit concurrent access (e.g. 2 permits).
 * TODO: In run(), acquire permit, print thread name + " has permit", sleep 100ms, release permit.
 */
public class PermitTask implements Runnable {
    private final Semaphore semaphore;

    public PermitTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        // TODO: acquire permit, print thread name + " has permit", sleep 100ms, release permit
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " has permit");
            Thread.sleep(100);
            semaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
