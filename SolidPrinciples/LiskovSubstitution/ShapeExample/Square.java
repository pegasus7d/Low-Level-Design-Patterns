package SolidPrinciples.LiskovSubstitution.ShapeExample;

/**
 * LSP: Square IS-A Rectangle, but if we extend Rectangle and override setWidth/setHeight
 * to set both dimensions, code that expects "setWidth only changes width" breaks.
 *
 * Fix: Don't extend Rectangle. Make Square a separate class with its own side length;
 * area() = side * side.
 *
 * TODO: Add field: private final double side;
 * TODO: Constructor Square(double side)
 * TODO: public double area() { return side * side; }
 */
public class Square {
    // TODO: private final double side; constructor Square(double side)
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    // TODO: return side * side
    public double area() {
        return 0;
    }
}
