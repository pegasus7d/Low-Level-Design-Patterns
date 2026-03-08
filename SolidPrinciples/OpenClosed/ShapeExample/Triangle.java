package SolidPrinciples.OpenClosed.ShapeExample;

/**
 * OCP: New shape added without modifying Circle or Rectangle.
 *
 * TODO: Implement Shape. For triangle with base b and height h, area = 0.5 * b * h.
 */
public class Triangle implements Shape {

    // TODO: Add fields for base and height (e.g. double base, double height)
    private double base;
    private double height;
    // TODO: Add constructor Triangle(double base, double height)
    public Triangle(double base,double height){
        this.base=base;
        this.height=height;
    }
    @Override
    public double area() {
        // TODO: return 0.5 * base * height
        return 0.5*base*height;
    }
}
