package Priority1.BuilderPattern.LaptopExample;

// Product class - what we are building (Laptop)
// TODO: Make this class immutable (all fields final, no setters)

public class Laptop {

    // TODO: Add these fields with final modifier:
    // - brand (String)
    // - ramGB (int)
    // - storageGB (int)
    // - processor (String)
    // - ssd (boolean)
    // - touchScreen (boolean)

    private final String brand;
    private final int ramGB;
    private final int storageGB;
    private final String processor;
    private final boolean ssd;
    private final boolean touchScreen;


    // TODO: Create private constructor that takes LaptopBuilder
    // Only the Builder can create Laptop objects
    // Assign all fields from builder to this object

    private Laptop(LaptopBuilder builder){
       this.brand=builder.brand;
       this.ramGB=builder.ramGB;
       this.storageGB=builder.storageGB;
       this.processor=builder.processor;
       this.ssd=builder.ssd;
       this.touchScreen=builder.touchScreen;

    }


    // TODO: Add getter methods for all fields
    // Note: For boolean fields, use hasXxx() naming convention (e.g. hasSSD(), hasTouchScreen())


    public String getBrand() {
        return brand;
    }

    public int getRamGB() {
        return ramGB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public String getProcessor() {
        return processor;
    }

    public boolean hasSSD() {
        return ssd;
    }

    public boolean hasTouchScreen() {
        return touchScreen;
    }

    // TODO: Create static inner class LaptopBuilder
    // The builder will have the same fields but mutable
    // Each setter method returns 'this' for method chaining

    public static class LaptopBuilder {
        // TODO: Add same fields as Laptop but WITHOUT final
        // Set default values: brand = "Generic", ramGB = 8, storageGB = 256, processor = "Intel i5", ssd = true, touchScreen = false
        private  String brand="Generic";
        private  int ramGB=8;
        private  int storageGB=256;
        private  String processor="Intel i5";
        private  boolean ssd=true;
        private  boolean touchScreen=false;

        // TODO: Implement setter methods (each returns LaptopBuilder):
        // - brand(String brand)
        // - ramGB(int ramGB)
        // - storageGB(int storageGB)
        // - processor(String processor)
        // - withSSD()  (sets ssd = true)
        // - noSSD()    (sets ssd = false)
        // - touchScreen() (sets touchScreen = true)



        public LaptopBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public LaptopBuilder ramGB(int ramGB) {
            this.ramGB = ramGB;
            return this;
        }

        public LaptopBuilder storageGB(int storageGB) {
            this.storageGB = storageGB;
            return this;
        }

        public LaptopBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public LaptopBuilder withSSD() {
            this.ssd = true;
            return this;
        }

        public LaptopBuilder noSSD() {
            this.ssd = false;
            return this;
        }

        public LaptopBuilder touchScreen() {
            this.touchScreen = true;
            return this;
        }

        // TODO: Implement build() method
        // Creates and returns new Laptop(this)
        public Laptop build(){
            return  new Laptop(this);
        }
    }
}
