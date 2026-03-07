package Priority1.Strategy.PaymentStrategyExample;

// Test for Strategy (Payment)
// TODO: Implement testPayWithCreditCard() - set credit card strategy on cart and call pay(100)

public class StrategyTest {

    public static void main(String[] args) {
        System.out.println("=== Strategy (Payment) Tests ===\n");
        testPayWithCreditCard();
        testPayWithPayPal();
        testSwitchStrategy();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: cart.setStrategy(new CreditCardStrategy()); cart.pay(100.0);
    private static void testPayWithCreditCard() {
        System.out.println("Test 1: Pay with Credit Card");
        ShoppingCart cart = new ShoppingCart();
        // TODO: cart.setStrategy(new CreditCardStrategy()); cart.pay(100.0);
        assert cart != null : "Cart should not be null";
        cart.pay(100.0); // will no-op until you set strategy above
        System.out.println("  ✓ Passed\n");
    }

    private static void testPayWithPayPal() {
        System.out.println("Test 2: Pay with PayPal");
        ShoppingCart cart = new ShoppingCart();
        cart.setStrategy(new PayPalStrategy());
        cart.pay(50.0);
        System.out.println("  ✓ Passed\n");
    }

    private static void testSwitchStrategy() {
        System.out.println("Test 3: Switch strategy at runtime");
        ShoppingCart cart = new ShoppingCart();
        cart.setStrategy(new CreditCardStrategy());
        cart.pay(10.0);
        cart.setStrategy(new PayPalStrategy());
        cart.pay(10.0);
        System.out.println("  ✓ Passed\n");
    }
}
