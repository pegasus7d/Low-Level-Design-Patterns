// Visitor - operations on elements (double-dispatch)
package Priority3.Visitor.ShapeVisitorExample;

public interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitSquare(Square square);
}
