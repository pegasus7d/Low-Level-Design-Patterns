package Priority3.Flyweight.CharacterExample;

// Test for Flyweight (Character)
// TODO: Implement testSharedCharacters() - CharacterFactory f = new CharacterFactory(); get 'a' twice, assert same instance

public class FlyweightTest {

    public static void main(String[] args) {
        System.out.println("=== Flyweight (Character) Tests ===\n");
        testSharedCharacters();
        testPrint();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: CharacterFactory factory = new CharacterFactory(); FlyweightCharacter a1 = factory.getCharacter('a'); FlyweightCharacter a2 = factory.getCharacter('a'); assert a1 == a2
    private static void testSharedCharacters() {
        System.out.println("Test 1: Shared characters");
        CharacterFactory factory = null; // TODO: new CharacterFactory(), getCharacter('a') twice, assert same
        assert factory != null : "Factory should not be null";
        FlyweightCharacter c1 = factory.getCharacter('a');
        FlyweightCharacter c2 = factory.getCharacter('a');
        assert c1 == c2 : "Same character should be same instance";
        System.out.println("  ✓ Passed\n");
    }

    private static void testPrint() {
        System.out.println("Test 2: Print");
        CharacterFactory factory = new CharacterFactory();
        factory.getCharacter('H').print();
        factory.getCharacter('i').print();
        System.out.println();
        System.out.println("  ✓ Passed\n");
    }
}
