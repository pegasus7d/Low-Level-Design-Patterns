package Priority1.Decorator.CoffeeExample;

// Concrete component - plain coffee
public class SimpleCoffee implements Beverage {
    public String getDescription() { return "Simple Coffee"; }
    public double getCost() { return 2.0; }
}
