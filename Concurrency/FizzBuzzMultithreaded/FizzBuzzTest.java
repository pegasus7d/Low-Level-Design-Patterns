package Concurrency.FizzBuzzMultithreaded;

/**
 * Test: Run fizz(), buzz(), fizzbuzz(), number() from 4 threads for n=15.
 */
public class FizzBuzzTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== FizzBuzz Multithreaded Test ===\n");
        FizzBuzz fb = new FizzBuzz(15);
        Thread tFizz = new Thread(() -> { try { fb.fizz(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread tBuzz = new Thread(() -> { try { fb.buzz(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread tFizzBuzz = new Thread(() -> { try { fb.fizzbuzz(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread tNumber = new Thread(() -> { try { fb.number(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        tFizz.start(); tBuzz.start(); tFizzBuzz.start(); tNumber.start();
        tFizz.join(); tBuzz.join(); tFizzBuzz.join(); tNumber.join();
        System.out.println("\n=== Done ===");
    }
}
