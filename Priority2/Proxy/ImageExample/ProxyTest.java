package Priority2.Proxy.ImageExample;

// Test for Proxy (Lazy Image)
// TODO: Implement testLazyLoad() - create ImageProxy("photo.jpg"), call display() twice (load once, use cached)

public class ProxyTest {

    public static void main(String[] args) {
        System.out.println("=== Proxy (Lazy Image) Tests ===\n");
        testLazyLoad();
        testDisplay();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Image img = new ImageProxy("photo.jpg"); img.display(); img.display(); (second call should not load again)
    private static void testLazyLoad() {
        System.out.println("Test 1: Lazy Load");
        Image img = null; // TODO: new ImageProxy("photo.jpg")
        assert img != null : "Image should not be null";
        img.display();
        img.display();
        System.out.println("  ✓ Passed\n");
    }

    private static void testDisplay() {
        System.out.println("Test 2: Display");
        Image img = new ImageProxy("test.png");
        img.display();
        System.out.println("  ✓ Passed\n");
    }
}
