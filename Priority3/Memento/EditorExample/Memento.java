package Priority3.Memento.EditorExample;

// Memento - holds saved state (immutable snapshot)
public class Memento {
    private final String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}
