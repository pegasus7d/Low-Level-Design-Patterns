package Concurrency.BoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Concurrency interview: Design Bounded Blocking Queue (LeetCode 1188).
 * Capacity c: enqueue blocks when full, dequeue blocks when empty.
 *
 * TODO: Implement enqueue (block when size == capacity) and dequeue (block when empty). Use wait/notify or ReentrantLock+Condition.
 */
public class BoundedBlockingQueue {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        // TODO: synchronized (queue): while (size==capacity) wait(); queue.add(element); notifyAll();
    }

    public int dequeue() throws InterruptedException {
        // TODO: synchronized (queue): while (empty) wait(); int x = queue.remove(); notifyAll(); return x;
        return -1;
    }

    public int size() {
        return queue.size();
    }
}
