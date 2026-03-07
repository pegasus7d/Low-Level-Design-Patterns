package SolidPrinciples.InterfaceSegregation.WorkerExample;

/**
 * Tests for Interface Segregation: Robot depends only on Workable, not Eatable.
 * TODO: In testInterfaceSegregation(), use a Robot as Workable and verify work().
 */
public class ISPTest {

    public static void main(String[] args) {
        System.out.println("=== Interface Segregation Principle Tests ===\n");

        testInterfaceSegregation();
        testHuman();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Apply ISP: create a Robot, use it as Workable (e.g. Workable w = new Robot()),
    // call w.work() and assert the result contains "Robot" (or "working").
    private static void testInterfaceSegregation() {
        System.out.println("Test 1: Robot as Workable only (your assignment)");

        Workable w = new Robot();
        String result = w.work();
        assert result != null && result.contains("Robot") : "Robot.work() should return string containing 'Robot'";

        System.out.println("  " + result);
        System.out.println("  ✓ Passed\n");
    }

    private static void testHuman() {
        System.out.println("Test 2: Human implements both");
        Human h = new Human();
        assert "Human working".equals(h.work()) : "work";
        assert "Human eating".equals(h.eat()) : "eat";
        System.out.println("  ✓ Passed\n");
    }
}
