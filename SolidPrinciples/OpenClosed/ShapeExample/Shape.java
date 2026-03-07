package SolidPrinciples.OpenClosed.ShapeExample;

/**
 * OCP: Open/Closed — open for extension (new shapes), closed for modification.
 * New shapes implement this interface without changing existing shape code.
 */
public interface Shape {
    /** Return the area of this shape. */
    double area();
}
