package Priority1.Strategy.PaymentStrategyExample;

// Concrete strategy - pay by PayPal
public class PayPalStrategy implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid " + amount + " by PayPal"); }
}
