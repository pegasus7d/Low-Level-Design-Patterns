// Test class for Pizza Builder Pattern
// TODO: Implement testBasicPizza() method
package Priority1.BuilderPattern.PizzaExample;

public class PizzaBuilderTest {

    public static void main(String[] args) {
        System.out.println("=== Pizza Builder Pattern Tests ===\n");

        testBasicPizza();
        testFullyLoadedPizza();
        testMinimalPizza();
        testChainedBuilding();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Create a Large pizza with cheese only
    // Use: new Pizza.PizzaBuilder().size("Large").addCheese().build()
    private static void testBasicPizza() {
        System.out.println("Test 1: Basic Pizza");

        // TODO: Create pizza using builder (replace null)
        Pizza pizza = new Pizza.PizzaBuilder()
                .size("Large")
                .addCheese()
                .build();

        assert pizza.getSize().equals("Large") : "Size should be Large";
        assert pizza.hasCheese() : "Should have cheese";
        assert !pizza.hasPepperoni() : "Should not have pepperoni";

        System.out.println("  Size: " + pizza.getSize());
        System.out.println("  Cheese: " + pizza.hasCheese());
        System.out.println("  ✓ Passed\n");
    }

    private static void testFullyLoadedPizza() {
        System.out.println("Test 2: Fully Loaded Pizza");

        Pizza pizza = new Pizza.PizzaBuilder()
                .size("Extra Large")
                .addCheese()
                .addPepperoni()
                .addMushrooms()
                .addOlives()
                .crust("Stuffed")
                .build();

        assert pizza.getSize().equals("Extra Large") : "Size should be Extra Large";
        assert pizza.hasCheese() : "Should have cheese";
        assert pizza.hasPepperoni() : "Should have pepperoni";
        assert pizza.hasMushrooms() : "Should have mushrooms";
        assert pizza.hasOlives() : "Should have olives";
        assert pizza.getCrust().equals("Stuffed") : "Crust should be Stuffed";

        System.out.println("  Size: " + pizza.getSize());
        System.out.println("  Toppings: Cheese=" + pizza.hasCheese() +
                ", Pepperoni=" + pizza.hasPepperoni() +
                ", Mushrooms=" + pizza.hasMushrooms() +
                ", Olives=" + pizza.hasOlives());
        System.out.println("  Crust: " + pizza.getCrust());
        System.out.println("  ✓ Passed\n");
    }

    private static void testMinimalPizza() {
        System.out.println("Test 3: Minimal Pizza (defaults only)");

        Pizza pizza = new Pizza.PizzaBuilder().build();

        assert pizza.getSize().equals("Medium") : "Default size should be Medium";
        assert pizza.getCrust().equals("Regular") : "Default crust should be Regular";
        assert !pizza.hasCheese() : "Default should have no cheese";
        assert !pizza.hasPepperoni() : "Default should have no pepperoni";

        System.out.println("  Size: " + pizza.getSize() + " (default)");
        System.out.println("  Crust: " + pizza.getCrust() + " (default)");
        System.out.println("  ✓ Passed\n");
    }

    private static void testChainedBuilding() {
        System.out.println("Test 4: Method Chaining");

        Pizza pizza = new Pizza.PizzaBuilder()
                .size("Small")
                .addCheese()
                .addPepperoni()
                .crust("Thin")
                .build();

        assert pizza.getSize().equals("Small") : "Size should be Small";
        assert pizza.hasCheese() : "Should have cheese";
        assert pizza.hasPepperoni() : "Should have pepperoni";
        assert pizza.getCrust().equals("Thin") : "Crust should be Thin";

        System.out.println("  Created pizza with chained calls");
        System.out.println("  Size: " + pizza.getSize() + ", Crust: " + pizza.getCrust());
        System.out.println("  ✓ Passed\n");
    }
}
