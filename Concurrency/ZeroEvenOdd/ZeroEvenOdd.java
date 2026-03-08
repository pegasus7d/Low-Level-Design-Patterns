package Concurrency.ZeroEvenOdd;

/**
 * Concurrency interview: Print Zero Even Odd (LeetCode 1116 style).
 * Given n, print 01020304...0n (zero, then even/odd alternating for 1..n).
 * Three threads: zero() prints 0, even() prints even numbers, odd() prints odd.
 *
 * TODO: Implement using semaphores or synchronized + wait/notify so output order is correct.
 */
public class ZeroEvenOdd {
    private final int n;
    // TODO: add synchronization primitives (e.g. Semaphore zeroSem, oddSem, evenSem)

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // TODO: only zero thread prints 0; then signal odd or even
    public void zero() throws InterruptedException {
    }

    // TODO: odd thread prints 1,3,5,... when allowed
    public void odd() throws InterruptedException {
    }

    // TODO: even thread prints 2,4,6,... when allowed
    public void even() throws InterruptedException {
    }
}
