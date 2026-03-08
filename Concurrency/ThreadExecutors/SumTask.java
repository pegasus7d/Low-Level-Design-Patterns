package Concurrency.ThreadExecutors;

import java.util.concurrent.Callable;

/**
 * Concurrency topic 3: Thread Executors — submit Callable and get Future.
 * TODO: Implement Callable<Integer>: return a + b (constructor takes int a, int b).
 */
public class SumTask implements Callable<Integer> {
    private final int a;
    private final int b;

    public SumTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() {
        // TODO: return a + b;
        return 0;
    }
}
