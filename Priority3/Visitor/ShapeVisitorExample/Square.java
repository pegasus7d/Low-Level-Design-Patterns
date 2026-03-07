package Priority3.Visitor.ShapeVisitorExample;

public class Square implements Shape {
    private final double side;
    public Square(double s) { side = s; }
    public double getSide() { return side; }
    public void accept(ShapeVisitor v) { v.visitSquare(this); }
}
