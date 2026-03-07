package Priority2.Iterator.CollectionExample;

// Test for Iterator (Simple Collection)
// TODO: Implement testIterate() - create SimpleCollection, add "A","B","C", get iterator, loop hasNext/next and print

public class IteratorTest {

    public static void main(String[] args) {
        System.out.println("=== Iterator (Collection) Tests ===\n");
        testIterate();
        testEmptyCollection();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: SimpleCollection col = new SimpleCollection(); col.add("A"); col.add("B"); col.add("C");
    //       SimpleIterator it = col.getIterator(); while (it.hasNext()) print it.next();
    private static void testIterate() {
        System.out.println("Test 1: Iterate");
        SimpleCollection col = null; // TODO: new SimpleCollection(), add items, get iterator, loop
        assert col != null : "Collection should not be null";
        SimpleIterator it = col.getIterator();
        while (it.hasNext()) System.out.println("  " + it.next());
        System.out.println("  ✓ Passed\n");
    }

    private static void testEmptyCollection() {
        System.out.println("Test 2: Empty collection");
        SimpleCollection col = new SimpleCollection();
        SimpleIterator it = col.getIterator();
        assert !it.hasNext() : "Empty should not have next";
        System.out.println("  ✓ Passed\n");
    }
}
