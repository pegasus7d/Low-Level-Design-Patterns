package Concurrency.DiningPhilosophers;

/**
 * Concurrency interview: The Dining Philosophers (LeetCode 1226).
 * 5 philosophers, 5 forks (between each pair). Each needs left and right fork to eat.
 * TODO: Prevent deadlock (e.g. pick lower-id fork first, or use semaphore to limit 4 eaters).
 */
public class DiningPhilosophers {
    private final Object[] forks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) forks[i] = new Object();
    }

    // TODO: philosopher 0..4; left fork = philosopher, right = (philosopher+1)%5. Lock both (e.g. lower-id first to avoid deadlock), run pick/eat/put, unlock.
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
    }
}
