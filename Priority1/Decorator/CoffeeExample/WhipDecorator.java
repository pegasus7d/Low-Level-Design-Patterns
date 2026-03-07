package Priority1.Decorator.CoffeeExample;

// Concrete decorator - adds whip
public class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Beverage b) { super(b); }
    public String getDescription() { return wrapped.getDescription() + ", Whip"; }
    public double getCost() { return wrapped.getCost() + 0.7; }
}
