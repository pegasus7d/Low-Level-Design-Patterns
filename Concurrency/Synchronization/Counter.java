package Concurrency.Synchronization;

/**
 * Concurrency topic 4: Thread Synchronization — avoid race condition on shared counter.
 * TODO: Add synchronized to increment() so that count++ is atomic (or use synchronized block).
 */
public class Counter {
    private int count = 0;

    public void increment() {
        // TODO: make this method thread-safe (add synchronized to method or use synchronized block)
        count++;
    }

    public int getCount() {
        return count;
    }
}
