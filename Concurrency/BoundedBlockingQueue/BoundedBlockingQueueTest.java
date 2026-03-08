package Concurrency.BoundedBlockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Test: Producer enqueues 1,2,3; consumer dequeues; assert order 1,2,3. Capacity 2.
 */
public class BoundedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Bounded Blocking Queue Test ===\n");
        BoundedBlockingQueue q = new BoundedBlockingQueue(2);
        List<Integer> consumed = new ArrayList<>();
        Thread producer = new Thread(() -> {
            try {
                q.enqueue(1); q.enqueue(2); q.enqueue(3);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    int x = q.dequeue();
                    consumed.add(x);
                    System.out.println("Dequeue: " + x);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        consumer.start();
        Thread.sleep(50);
        producer.start();
        producer.join();
        consumer.join();
        assert consumed.size() == 3 && consumed.get(0) == 1 && consumed.get(1) == 2 && consumed.get(2) == 3
                : "Expected [1,2,3], got " + consumed;
        System.out.println("=== Done ===");
    }
}
