package Priority3.Memento.EditorExample;

// Caretaker - holds mementos (e.g. stack for undo)
import java.util.Stack;
public class History {
    private final Stack<Memento> stack = new Stack<>();
    public void push(Memento m) { stack.push(m); }
    public Memento pop() { return stack.isEmpty() ? null : stack.pop(); }
}
