// Product class - what we are building
// TODO: Make this class immutable (all fields final, no setters)

public class Pizza {

    // TODO: Add these fields with final modifier:
    // - size (String)
    // - cheese (boolean)
    // - pepperoni (boolean)
    // - mushrooms (boolean)
    // - olives (boolean)
    // - crust (String)

    // TODO: Create private constructor that takes PizzaBuilder
    // Only the Builder can create Pizza objects
    // Assign all fields from builder to this object

    // TODO: Add getter methods for all fields
    // Note: For boolean fields, use hasXxx() naming convention

    // TODO: Create static inner class PizzaBuilder
    // The builder will have the same fields but mutable
    // Each setter method returns 'this' for method chaining

    public static class PizzaBuilder {
        // TODO: Add same fields as Pizza but WITHOUT final
        // Set default values (size = "Medium", crust = "Regular")

        // TODO: Implement setter methods:
        // - size(String size) - returns PizzaBuilder
        // - addCheese() - returns PizzaBuilder (sets cheese = true)
        // - addPepperoni() - returns PizzaBuilder
        // - addMushrooms() - returns PizzaBuilder
        // - addOlives() - returns PizzaBuilder
        // - crust(String crust) - returns PizzaBuilder

        // TODO: Implement build() method
        // Creates and returns new Pizza(this)
    }
}