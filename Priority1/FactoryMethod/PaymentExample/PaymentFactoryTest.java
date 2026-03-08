package Priority1.FactoryMethod.PaymentExample;

// Test for Factory Method (Payment)
// TODO: Implement testCreateCreditCard() - use factory to create payment and call processPayment

public class PaymentFactoryTest {

    public static void main(String[] args) {
        System.out.println("=== Factory Method (Payment) Tests ===\n");
        testCreateCreditCard();
        testCreatePayPal();
        testProcessPayment();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Create Payment via PaymentFactory.createPayment("credit"), assert it is CreditCardPayment
    private static void testCreateCreditCard() {
        System.out.println("Test 1: Create Credit Card Payment");
        Payment payment = PaymentFactory.createPayment("credit"); // TODO: PaymentFactory.createPayment("credit")
        assert payment != null : "Payment should not be null";
        assert payment instanceof CreditCardPayment : "Should be CreditCardPayment";
        System.out.println("  ✓ Passed\n");
    }

    private static void testCreatePayPal() {
        System.out.println("Test 2: Create PayPal Payment");
        Payment payment = PaymentFactory.createPayment("paypal");
        assert payment != null : "Payment should not be null";
        assert payment instanceof PayPalPayment : "Should be PayPalPayment";
        System.out.println("  ✓ Passed\n");
    }

    private static void testProcessPayment() {
        System.out.println("Test 3: Process Payment");
        Payment payment = PaymentFactory.createPayment("credit");
        payment.processPayment(100.0);
        System.out.println("  ✓ Passed\n");
    }
}
