package SolidPrinciples.OpenClosed.ShapeExample;

/**
 * Tests for Open/Closed Principle: add Triangle without modifying existing Shape code.
 * TODO: Implement testNewShapeType() — create a Triangle and verify its area.
 */
public class OpenClosedTest {

    public static void main(String[] args) {
        System.out.println("=== Open/Closed Principle Tests ===\n");

        testNewShapeType();
        testCircle();
        testRectangle();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Apply OCP: create a Triangle with base 4 and height 3; assert area() == 6.0
    private static void testNewShapeType() {
        System.out.println("Test 1: New shape (Triangle) without modifying existing code (your assignment)");

        // TODO: Shape triangle = new Triangle(4, 3); then assert triangle.area() == 6.0
        Shape triangle = new Triangle(4, 3);
        assert Math.abs(triangle.area() - 6.0) < 0.001 : "Triangle area should be 6.0";

        System.out.println("  Triangle area: " + triangle.area());
        System.out.println("  ✓ Passed\n");
    }

    private static void testCircle() {
        System.out.println("Test 2: Circle");
        Shape c = new Circle(2);
        assert Math.abs(c.area() - Math.PI * 4) < 0.001 : "Circle area";
        System.out.println("  ✓ Passed\n");
    }

    private static void testRectangle() {
        System.out.println("Test 3: Rectangle");
        Shape r = new Rectangle(3, 4);
        assert Math.abs(r.area() - 12.0) < 0.001 : "Rectangle area";
        System.out.println("  ✓ Passed\n");
    }
}
