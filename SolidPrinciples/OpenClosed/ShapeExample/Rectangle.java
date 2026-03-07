package SolidPrinciples.OpenClosed.ShapeExample;

/**
 * OCP: Add new shapes by implementing Shape; no need to modify existing code.
 */
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
