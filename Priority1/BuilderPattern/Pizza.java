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


    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean olives;
    private final String crust;

    // TODO: Create private constructor that takes PizzaBuilder
    // Only the Builder can create Pizza objects
    // Assign all fields from builder to this object

    private Pizza(PizzaBuilder builder){
        this.size=builder.size;
        this.cheese=builder.cheese;
        this.pepperoni=builder.pepperoni;
        this.mushrooms=builder.mushrooms;
        this.olives=builder.olives;
        this.crust=builder.crust;
    }

    // TODO: Add getter methods for all fields
    // Note: For boolean fields, use hasXxx() naming convention


    public String getSize() { return size; }
    public boolean hasCheese() { return cheese; }
    public boolean hasPepperoni() {return pepperoni; }
    public boolean hasMushrooms(){return mushrooms;}
    public boolean hasOlives(){return olives;}
    public String getCrust() { return crust;}


    // TODO: Create static inner class PizzaBuilder
    // The builder will have the same fields but mutable
    // Each setter method returns 'this' for method chaining

    public static class PizzaBuilder {
        // TODO: Add same fields as Pizza but WITHOUT final
        // Set default values (size = "Medium", crust = "Regular")


        private String size = "Medium";
        private boolean cheese;      // false by default
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean olives;
        private String crust = "Regular";


        // TODO: Implement setter methods:
        // - size(String size) - returns PizzaBuilder
        // - addCheese() - returns PizzaBuilder (sets cheese = true)
        // - addPepperoni() - returns PizzaBuilder
        // - addMushrooms() - returns PizzaBuilder
        // - addOlives() - returns PizzaBuilder
        // - crust(String crust) - returns PizzaBuilder


        public PizzaBuilder size(String size){
            this.size=size;
            return this;
        }

        public PizzaBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public PizzaBuilder addOlives() {
            this.olives = true;
            return this;
        }

        public PizzaBuilder crust(String crust) {
            this.crust = crust;
            return this;
        }


        // TODO: Implement build() method
        // Creates and returns new Pizza(this)

        public Pizza build(){
            return new Pizza(this);
        }
    }
}