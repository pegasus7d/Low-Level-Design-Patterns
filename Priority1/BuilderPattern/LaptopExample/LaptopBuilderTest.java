package Priority1.BuilderPattern.LaptopExample;

// Test class for Laptop Builder Pattern
// TODO: Implement testBasicLaptop() method (create the Laptop using builder)

public class LaptopBuilderTest {

    public static void main(String[] args) {
        System.out.println("=== Laptop Builder Pattern Tests ===\n");

        testBasicLaptop();
        testFullySpecifiedLaptop();
        testMinimalLaptop();
        testChainedBuilding();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Create a Laptop with brand "Dell", 16GB RAM, 512GB storage (use builder)
    // Use: new Laptop.LaptopBuilder().brand("Dell").ramGB(16).storageGB(512).build()
    // Then verify with assertions below
    private static void testBasicLaptop() {
        System.out.println("Test 1: Basic Laptop");

        // TODO: Create laptop using builder (replace null)
        Laptop laptop = null;

        assert laptop.getBrand().equals("Dell") : "Brand should be Dell";
        assert laptop.getRamGB() == 16 : "RAM should be 16GB";
        assert laptop.getStorageGB() == 512 : "Storage should be 512GB";

        System.out.println("  Brand: " + laptop.getBrand());
        System.out.println("  RAM: " + laptop.getRamGB() + "GB");
        System.out.println("  Storage: " + laptop.getStorageGB() + "GB");
        System.out.println("  ✓ Passed\n");
    }

    private static void testFullySpecifiedLaptop() {
        System.out.println("Test 2: Fully Specified Laptop");

        Laptop laptop = new Laptop.LaptopBuilder()
                .brand("MacBook")
                .ramGB(32)
                .storageGB(1024)
                .processor("M3 Pro")
                .withSSD()
                .touchScreen()
                .build();

        assert laptop.getBrand().equals("MacBook") : "Brand should be MacBook";
        assert laptop.getRamGB() == 32 : "RAM should be 32GB";
        assert laptop.getStorageGB() == 1024 : "Storage should be 1024GB";
        assert laptop.getProcessor().equals("M3 Pro") : "Processor should be M3 Pro";
        assert laptop.hasSSD() : "Should have SSD";
        assert laptop.hasTouchScreen() : "Should have touch screen";

        System.out.println("  Brand: " + laptop.getBrand());
        System.out.println("  RAM: " + laptop.getRamGB() + "GB, Storage: " + laptop.getStorageGB() + "GB SSD");
        System.out.println("  Processor: " + laptop.getProcessor());
        System.out.println("  Touch screen: " + laptop.hasTouchScreen());
        System.out.println("  ✓ Passed\n");
    }

    private static void testMinimalLaptop() {
        System.out.println("Test 3: Minimal Laptop (defaults only)");

        Laptop laptop = new Laptop.LaptopBuilder().build();

        assert laptop.getBrand().equals("Generic") : "Default brand should be Generic";
        assert laptop.getRamGB() == 8 : "Default RAM should be 8GB";
        assert laptop.getStorageGB() == 256 : "Default storage should be 256GB";
        assert laptop.getProcessor().equals("Intel i5") : "Default processor should be Intel i5";
        assert laptop.hasSSD() : "Default should have SSD";
        assert !laptop.hasTouchScreen() : "Default should not have touch screen";

        System.out.println("  Brand: " + laptop.getBrand() + " (default)");
        System.out.println("  RAM: " + laptop.getRamGB() + "GB, Storage: " + laptop.getStorageGB() + "GB");
        System.out.println("  ✓ Passed\n");
    }

    private static void testChainedBuilding() {
        System.out.println("Test 4: Method Chaining");

        Laptop laptop = new Laptop.LaptopBuilder()
                .brand("Lenovo")
                .ramGB(16)
                .storageGB(512)
                .processor("AMD Ryzen 7")
                .noSSD()
                .build();

        assert laptop.getBrand().equals("Lenovo") : "Brand should be Lenovo";
        assert laptop.getRamGB() == 16 : "RAM should be 16GB";
        assert !laptop.hasSSD() : "Should not have SSD (noSSD called)";

        System.out.println("  Created laptop with chained calls");
        System.out.println("  Brand: " + laptop.getBrand() + ", Processor: " + laptop.getProcessor());
        System.out.println("  ✓ Passed\n");
    }
}
