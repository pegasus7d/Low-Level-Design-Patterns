package Priority1.Strategy.PaymentStrategyExample;

// Concrete strategy - pay by credit card
public class CreditCardStrategy implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid " + amount + " by Credit Card"); }
}
