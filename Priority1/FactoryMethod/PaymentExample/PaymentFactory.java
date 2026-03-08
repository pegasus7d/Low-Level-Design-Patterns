package Priority1.FactoryMethod.PaymentExample;

// Factory: creates Payment based on type (no caller knows concrete class)
// TODO: Implement createPayment(String type):
// - "credit" or "creditcard" -> new CreditCardPayment()
// - "paypal" -> new PayPalPayment()
// - else -> null
public class PaymentFactory {
    public static Payment createPayment(String type) {
        // TODO: return correct Payment implementation based on type ("credit"/"creditcard" -> CreditCardPayment, "paypal" -> PayPalPayment)
        switch (type){
            case "credit", "creditcard": return new CreditCardPayment();
            case "paypal": return new PayPalPayment();
            default: return null;
        }
    }
}
