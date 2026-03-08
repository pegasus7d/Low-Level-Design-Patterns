package Concurrency.FizzBuzzMultithreaded;

/**
 * Concurrency interview: Fizz Buzz Multithreaded (LeetCode 1195 style).
 * Four threads: fizz() prints "fizz" for multiples of 3, buzz() for 5, fizzbuzz() for 15, number() for others.
 * Run from 1 to n in order.
 *
 * TODO: Implement using synchronized + wait/notify or conditions so numbers print in order 1..n.
 */
public class FizzBuzz {
    private final int n;
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // TODO: print "fizz" only when current is divisible by 3 and not 5; increment current; notify others
    public void fizz() throws InterruptedException {
    }

    // TODO: print "buzz" only when current is divisible by 5 and not 3
    public void buzz() throws InterruptedException {
    }

    // TODO: print "fizzbuzz" when current is divisible by 15
    public void fizzbuzz() throws InterruptedException {
    }

    // TODO: print number when not divisible by 3 or 5
    public void number() throws InterruptedException {
    }
}
