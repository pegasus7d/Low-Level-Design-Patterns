package Priority3.ChainOfResponsibility.LoggerExample;

// Test for Chain of Responsibility (Logger)
// TODO: Implement testChain() - build chain: InfoHandler -> ErrorHandler, setNext, call log("ERROR", "fail")

public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility (Logger) Tests ===\n");
        testChain();
        testInfo();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: LogHandler info = new InfoHandler(); LogHandler err = new ErrorHandler(); info.setNext(err); info.log("ERROR", "fail");
    private static void testChain() {
        System.out.println("Test 1: Chain ERROR");
        LogHandler chain = null; // TODO: InfoHandler -> setNext(ErrorHandler), then chain.log("ERROR", "fail")
        assert chain != null : "Chain should not be null";
        chain.log("ERROR", "fail");
        System.out.println("  ✓ Passed\n");
    }

    private static void testInfo() {
        System.out.println("Test 2: Chain INFO");
        LogHandler info = new InfoHandler();
        LogHandler err = new ErrorHandler();
        info.setNext(err);
        info.log("INFO", "hello");
        System.out.println("  ✓ Passed\n");
    }
}
