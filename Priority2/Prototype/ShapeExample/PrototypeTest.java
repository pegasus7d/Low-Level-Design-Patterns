// Test for Prototype (Shape)
// TODO: Implement testCloneCircle() - create Circle(5), clone it, assert cloned radius is 5
package Priority2.Prototype.ShapeExample;

public class PrototypeTest {

    public static void main(String[] args) {
        System.out.println("=== Prototype (Shape) Tests ===\n");
        testCloneCircle();
        testCloneIsIndependent();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Circle original = new Circle(5); Shape cloned = original.clone(); assert ((Circle)cloned).getRadius() == 5
    private static void testCloneCircle() {
        System.out.println("Test 1: Clone Circle");
        Circle original = new Circle(5);
        Shape cloned = null; // TODO: original.clone()
        assert cloned != null : "Cloned should not be null";
        assert cloned instanceof Circle : "Cloned should be Circle";
        assert ((Circle) cloned).getRadius() == 5 : "Cloned radius should be 5";
        System.out.println("  ✓ Passed\n");
    }

    private static void testCloneIsIndependent() {
        System.out.println("Test 2: Clone is independent");
        Circle original = new Circle(10);
        Shape cloned = original.clone();
        original.draw();
        cloned.draw();
        System.out.println("  ✓ Passed\n");
    }
}
