package Priority1.Decorator.CoffeeExample;

// Test for Decorator (Coffee)
// TODO: Implement testDecoratedCoffee() - create coffee with Milk and Whip, assert cost/description

public class CoffeeDecoratorTest {

    public static void main(String[] args) {
        System.out.println("=== Decorator (Coffee) Tests ===\n");
        testDecoratedCoffee();
        testSimpleCoffee();
        testMilkOnly();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Beverage b = new WhipDecorator(new MilkDecorator(new SimpleCoffee()));
    //       assert cost and description contain "Milk" and "Whip"
    private static void testDecoratedCoffee() {
        System.out.println("Test 1: Coffee with Milk and Whip");
        Beverage coffee = null; // TODO: new WhipDecorator(new MilkDecorator(new SimpleCoffee()))
        assert coffee != null : "Coffee should not be null";
        assert coffee.getDescription().contains("Milk") : "Should have Milk";
        assert coffee.getDescription().contains("Whip") : "Should have Whip";
        assert coffee.getCost() > 2.0 : "Cost should be more than simple coffee";
        System.out.println("  " + coffee.getDescription() + " = " + coffee.getCost());
        System.out.println("  ✓ Passed\n");
    }

    private static void testSimpleCoffee() {
        System.out.println("Test 2: Simple Coffee");
        Beverage coffee = new SimpleCoffee();
        assert coffee.getCost() == 2.0 : "Simple coffee cost 2.0";
        System.out.println("  ✓ Passed\n");
    }

    private static void testMilkOnly() {
        System.out.println("Test 3: Coffee with Milk only");
        Beverage coffee = new MilkDecorator(new SimpleCoffee());
        assert coffee.getDescription().contains("Milk");
        assert coffee.getCost() == 2.5;
        System.out.println("  ✓ Passed\n");
    }
}
