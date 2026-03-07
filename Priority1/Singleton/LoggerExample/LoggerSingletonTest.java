package Priority1.Singleton.LoggerExample;

// Test for Singleton (Logger)
// TODO: Implement testGetInstance() - get the singleton and verify it's the same instance

public class LoggerSingletonTest {

    public static void main(String[] args) {
        System.out.println("=== Singleton (Logger) Tests ===\n");
        testGetInstance();
        testSameInstance();
        testLog();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Get Logger instance via Logger.getInstance(), then assert it is not null
    private static void testGetInstance() {
        System.out.println("Test 1: Get Instance");
        Logger logger = null; // TODO: replace with Logger.getInstance()
        assert logger != null : "Logger instance should not be null";
        System.out.println("  Got logger instance");
        System.out.println("  ✓ Passed\n");
    }

    private static void testSameInstance() {
        System.out.println("Test 2: Same Instance");
        Logger a = Logger.getInstance();
        Logger b = Logger.getInstance();
        assert a == b : "Both should be the same instance";
        System.out.println("  Same instance: " + (a == b));
        System.out.println("  ✓ Passed\n");
    }

    private static void testLog() {
        System.out.println("Test 3: Log Method");
        Logger logger = Logger.getInstance();
        logger.log("Hello from singleton");
        System.out.println("  ✓ Passed\n");
    }
}
