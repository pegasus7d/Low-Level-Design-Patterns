package Concurrency.ThreadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Test: Submit SumTask via executor and get result from Future.
 * TODO: executor.submit(new SumTask(3, 5)); Future.get() and print result (should be 8).
 */
public class ThreadExecutorsTest {

    public static void main(String[] args) throws Exception {
        System.out.println("=== Thread Executors Test ===\n");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new SumTask(3, 5));
        int result = future.get();
        System.out.println("Sum: " + result);
        assert result == 8 : "Expected 3+5=8, got " + result;
        executor.shutdown();
        System.out.println("=== Done ===");
    }
}
