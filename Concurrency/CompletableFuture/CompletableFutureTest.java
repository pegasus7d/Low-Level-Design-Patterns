package Concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Concurrency topic 9: Future and CompletableFuture.
 * TODO: Create CompletableFuture.supplyAsync(() -> "Hello"), then .thenApply(s -> s + " World"), then get() and print.
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("=== CompletableFuture Test ===\n");
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World");
        String result = future.get();
        System.out.println("Result: " + result);
        assert "Hello World".equals(result);
        System.out.println("=== Done ===");
    }
}
