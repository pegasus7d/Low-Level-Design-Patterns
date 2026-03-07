package Priority3.Flyweight.CharacterExample;

// Flyweight - shared intrinsic state (character)
public class FlyweightCharacter {
    private final char character;
    public FlyweightCharacter(char c) { this.character = c; }
    public void print() { System.out.print(character); }
    public char getChar() { return character; }
}
