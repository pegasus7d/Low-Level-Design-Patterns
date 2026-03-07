package Priority1.Decorator.CoffeeExample;

// Concrete decorator - adds milk
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Beverage b) { super(b); }
    public String getDescription() { return wrapped.getDescription() + ", Milk"; }
    public double getCost() { return wrapped.getCost() + 0.5; }
}
