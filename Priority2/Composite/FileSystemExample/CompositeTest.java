package Priority2.Composite.FileSystemExample;

// Test for Composite (File System)
// TODO: Implement testTreeStructure() - create root Folder, add subfolder and files, call show(0)

public class CompositeTest {

    public static void main(String[] args) {
        System.out.println("=== Composite (File System) Tests ===\n");
        testTreeStructure();
        testSingleFile();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Folder root = new Folder("root"); root.add(new File("a.txt")); Folder sub = new Folder("src"); sub.add(new File("Main.java")); root.add(sub); root.show(0);
    private static void testTreeStructure() {
        System.out.println("Test 1: Tree Structure");
        Folder root = null; // TODO: new Folder("root"), add File("a.txt"), add sub Folder("src") with File("Main.java"), root.show(0)
        assert root != null : "Root should not be null";
        root.show(0);
        System.out.println("  ✓ Passed\n");
    }

    private static void testSingleFile() {
        System.out.println("Test 2: Single File");
        File f = new File("readme.txt");
        f.show(0);
        System.out.println("  ✓ Passed\n");
    }
}
