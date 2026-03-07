package Priority1.Decorator.CoffeeExample;

// Abstract decorator - holds a Beverage, delegates and adds behavior
public abstract class CoffeeDecorator implements Beverage {
    protected Beverage wrapped;
    public CoffeeDecorator(Beverage b) { this.wrapped = b; }
}
