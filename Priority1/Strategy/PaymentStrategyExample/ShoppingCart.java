package Priority1.Strategy.PaymentStrategyExample;

// Context - holds current strategy, delegates pay to it
public class ShoppingCart {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy s) { this.strategy = s; }
    public void pay(double amount) { if (strategy != null) strategy.pay(amount); }
}
