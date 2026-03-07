package Priority3.Visitor.ShapeVisitorExample;

public class Circle implements Shape {
    private final double radius;
    public Circle(double r) { radius = r; }
    public double getRadius() { return radius; }
    public void accept(ShapeVisitor v) { v.visitCircle(this); }
}
