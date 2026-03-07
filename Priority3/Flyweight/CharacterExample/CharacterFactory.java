package Priority3.Flyweight.CharacterExample;

// Flyweight factory - reuses FlyweightCharacter by character (shared state)
// TODO: Hold Map<Character, FlyweightCharacter>. getCharacter(char c) returns existing or new, caches it.
import java.util.HashMap;
import java.util.Map;
public class CharacterFactory {
    private final Map<Character, FlyweightCharacter> pool = new HashMap<>();
    public FlyweightCharacter getCharacter(char c) {
        // TODO: if pool has c return it; else create new FlyweightCharacter(c), put in pool, return
        return pool.computeIfAbsent(c, FlyweightCharacter::new);
    }
}
