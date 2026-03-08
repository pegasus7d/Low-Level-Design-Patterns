package Concurrency.ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Concurrency topic 8: Java Concurrent Collections — ConcurrentHashMap, AtomicInteger.
 * TODO: Use ConcurrentHashMap<String, Integer> and AtomicInteger (or CHM) to count words from multiple threads.
 * Example: 4 threads each put "hello" 100 times; total count for "hello" should be 400.
 */
public class ConcurrentCollectionsTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Concurrent Collections Test ===\n");
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        String key = "hello";
        map.put(key, new AtomicInteger(0));
        int numThreads = 4;
        int perThread = 100;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < perThread; j++) {
                    map.get(key).incrementAndGet();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        int total = map.get(key).get();
        System.out.println("Count for 'hello': " + total + " (expected 400)");
        assert total == 400;
        System.out.println("=== Done ===");
    }
}
