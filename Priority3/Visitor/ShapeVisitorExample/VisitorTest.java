// Test for Visitor (Shape area)
// TODO: Implement testArea() - create Circle(1), Square(2), AreaVisitor; shapes accept visitor; assert totalArea
package Priority3.Visitor.ShapeVisitorExample;

public class VisitorTest {

    public static void main(String[] args) {
        System.out.println("=== Visitor (Shape Area) Tests ===\n");
        testArea();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Shape[] shapes = { new Circle(1), new Square(2) }; AreaVisitor v = new AreaVisitor(); for (Shape s : shapes) s.accept(v); assert v.getTotalArea() > 0
    private static void testArea() {
        System.out.println("Test 1: Area Visitor");
        Shape[] shapes = null; // TODO: { new Circle(1), new Square(2) }
        AreaVisitor visitor = null; // TODO: new AreaVisitor(), each shape.accept(visitor)
        assert visitor != null : "Visitor should not be null";
        assert visitor.getTotalArea() > 0 : "Total area should be positive";
        System.out.println("  Total area: " + (visitor != null ? visitor.getTotalArea() : 0));
        System.out.println("  ✓ Passed\n");
    }
}
