package Priority1.BuilderPattern.LaptopExample;

// Product class - what we are building (Laptop)
// TODO: Make this class immutable (all fields final, no setters)

public class Laptop {

    // TODO: Add these fields with final modifier:
    // - brand (String)
    // - ramGB (int)
    // - storageGB (int)
    // - processor (String)
    // - hasSSD (boolean)
    // - touchScreen (boolean)

    // TODO: Create private constructor that takes LaptopBuilder
    // Only the Builder can create Laptop objects
    // Assign all fields from builder to this object

    // TODO: Add getter methods for all fields
    // Note: For boolean fields, use hasXxx() naming convention (e.g. hasSSD(), hasTouchScreen())

    // TODO: Create static inner class LaptopBuilder
    // The builder will have the same fields but mutable
    // Each setter method returns 'this' for method chaining

    public static class LaptopBuilder {
        // TODO: Add same fields as Laptop but WITHOUT final
        // Set default values: brand = "Generic", ramGB = 8, storageGB = 256, processor = "Intel i5", hasSSD = true, touchScreen = false

        // TODO: Implement setter methods (each returns LaptopBuilder):
        // - brand(String brand)
        // - ramGB(int ramGB)
        // - storageGB(int storageGB)
        // - processor(String processor)
        // - withSSD()  (sets hasSSD = true)
        // - noSSD()    (sets hasSSD = false)
        // - touchScreen() (sets touchScreen = true)

        // TODO: Implement build() method
        // Creates and returns new Laptop(this)
    }
}
