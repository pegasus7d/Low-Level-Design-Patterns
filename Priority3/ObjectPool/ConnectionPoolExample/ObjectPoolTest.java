package Priority3.ObjectPool.ConnectionPoolExample;

// Test for Object Pool (Connection Pool)
// TODO: Implement testAcquireRelease() - create pool(2), acquire(), use, release(), acquire again (same instance reused)

public class ObjectPoolTest {

    public static void main(String[] args) {
        System.out.println("=== Object Pool (Connection Pool) Tests ===\n");
        testAcquireRelease();
        testPoolLimit();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: ConnectionPool pool = new ConnectionPool(2); PooledConnection c1 = pool.acquire(); c1.connect(); pool.release(c1); PooledConnection c2 = pool.acquire(); (c2 may be c1)
    private static void testAcquireRelease() {
        System.out.println("Test 1: Acquire and Release");
        ConnectionPool pool = null; // TODO: new ConnectionPool(2), acquire, use, release, acquire again
        assert pool != null : "Pool should not be null";
        PooledConnection c = pool.acquire();
        c.connect();
        pool.release(c);
        System.out.println("  ✓ Passed\n");
    }

    private static void testPoolLimit() {
        System.out.println("Test 2: Pool limit");
        ConnectionPool pool = new ConnectionPool(2);
        PooledConnection c1 = pool.acquire();
        PooledConnection c2 = pool.acquire();
        PooledConnection c3 = pool.acquire();
        assert c1 != null && c2 != null : "First two should be acquired";
        System.out.println("  ✓ Passed\n");
    }
}
