// Concrete visitor - compute area
package Priority3.Visitor.ShapeVisitorExample;

public class AreaVisitor implements ShapeVisitor {
    private double totalArea;
    public void visitCircle(Circle c) { totalArea += Math.PI * c.getRadius() * c.getRadius(); }
    public void visitSquare(Square s) { totalArea += s.getSide() * s.getSide(); }
    public double getTotalArea() { return totalArea; }
}