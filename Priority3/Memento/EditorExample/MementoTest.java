package Priority3.Memento.EditorExample;

// Test for Memento (Editor undo)
// TODO: Implement testUndo() - Editor editor = new Editor(); editor.setContent("Hello"); History hist = new History(); hist.push(editor.save()); editor.setContent("World"); editor.restore(hist.pop()); assert "Hello"

public class MementoTest {

    public static void main(String[] args) {
        System.out.println("=== Memento (Editor) Tests ===\n");
        testUndo();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: editor.setContent("Hello"); hist.push(editor.save()); editor.setContent("World"); editor.restore(hist.pop()); assert editor.getContent().equals("Hello")
    private static void testUndo() {
        System.out.println("Test 1: Undo");
        Editor editor = new Editor();
        History hist = new History();
        editor.setContent("Hello");
        hist.push(editor.save());
        editor.setContent("World");
        editor.restore(hist.pop());
        assert "Hello".equals(editor.getContent()) : "Restore should get Hello";
        System.out.println("  ✓ Passed\n");
    }
}
