package Concurrency.ZeroEvenOdd;

/**
 * Test: Run zero(), odd(), even() from 3 threads for n=5; output should be 0102030405.
 */
public class ZeroEvenOddTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Zero Even Odd Test ===\n");
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);
        Thread tZero = new Thread(() -> { try { zeo.zero(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread tOdd  = new Thread(() -> { try { zeo.odd();  } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread tEven = new Thread(() -> { try { zeo.even(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        tZero.start(); tOdd.start(); tEven.start();
        tZero.join(); tOdd.join(); tEven.join();
        System.out.println("\n=== Done ===");
    }
}
