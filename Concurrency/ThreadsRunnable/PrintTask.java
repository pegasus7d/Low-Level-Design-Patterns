package Concurrency.ThreadsRunnable;

/**
 * Concurrency topic 1: Thread class and Runnable interface.
 * TODO: Implement Runnable — run() should print "Hello from thread: " + threadName 3 times (use a loop).
 */
public class PrintTask implements Runnable {
    private final String threadName;

    public PrintTask(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // TODO: for i = 0..2, print "Hello from thread: " + threadName
    }
}
