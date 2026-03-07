// Concrete prototype - circle
// TODO: Implement Shape, hold radius (int), clone() returns new Circle with same radius
package Priority2.Prototype.ShapeExample;

public class Circle implements Shape {
    private int radius;
    public Circle(int radius) { this.radius = radius; }
    public void draw() { System.out.println("Drawing Circle radius=" + radius); }
    public Shape clone() {
        return new Circle(this.radius); // TODO: you implement clone (copy radius to new Circle)
    }
    public int getRadius() { return radius; }
}
