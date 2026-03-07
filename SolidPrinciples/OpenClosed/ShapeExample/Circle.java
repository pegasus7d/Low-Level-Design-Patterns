package SolidPrinciples.OpenClosed.ShapeExample;

/**
 * OCP: Add new shapes by implementing Shape; no need to modify existing code.
 */
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
