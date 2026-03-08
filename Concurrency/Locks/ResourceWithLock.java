package Concurrency.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Concurrency topic 6: Locks — ReentrantLock instead of synchronized.
 * TODO: In increment(), lock.lock() before count++, then lock.unlock() in finally.
 */
public class ResourceWithLock {
    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        // TODO: lock.lock(); try { count++; } finally { lock.unlock(); }
    }

    public int getCount() {
        // TODO: lock, try return count, finally unlock
        return count;
    }
}
