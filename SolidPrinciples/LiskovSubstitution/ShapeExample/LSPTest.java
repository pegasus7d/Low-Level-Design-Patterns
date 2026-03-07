package SolidPrinciples.LiskovSubstitution.ShapeExample;

/**
 * Tests for Liskov Substitution Principle: use Rectangle and Square correctly so
 * behavior is predictable (no surprise when substituting).
 * TODO: Implement testLiskovSubstitution() — use Square and verify its area.
 */
public class LSPTest {

    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle Tests ===\n");

        testLiskovSubstitution();
        testRectangle();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Create a Square with side 4. Assert its area is 16.0.
    // Using a separate Square class (not extending Rectangle) respects LSP.
    private static void testLiskovSubstitution() {
        System.out.println("Test 1: Square as its own type (your assignment)");

        // TODO: Square square = new Square(4); assert square.area() == 16.0;
        Square square = new Square(4);
        assert Math.abs(square.area() - 16.0) < 0.001 : "Square area should be 16.0";

        System.out.println("  Square area: " + square.area());
        System.out.println("  ✓ Passed\n");
    }

    private static void testRectangle() {
        System.out.println("Test 2: Rectangle");
        Rectangle r = new Rectangle(3, 4);
        assert Math.abs(r.area() - 12.0) < 0.001 : "Rectangle area";
        r.setWidth(5);
        assert Math.abs(r.area() - 20.0) < 0.001 : "After setWidth";
        System.out.println("  ✓ Passed\n");
    }
}
