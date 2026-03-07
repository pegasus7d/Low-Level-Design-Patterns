package Priority1.FactoryMethod.PaymentExample;

// Concrete product - credit card payment
public class CreditCardPayment implements Payment {
    public void processPayment(double amount) { System.out.println("CreditCard: " + amount); }
}
