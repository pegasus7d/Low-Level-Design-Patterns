package Priority1.FactoryMethod.PaymentExample;

// Concrete product - PayPal payment
public class PayPalPayment implements Payment {
    public void processPayment(double amount) { System.out.println("PayPal: " + amount); }
}
