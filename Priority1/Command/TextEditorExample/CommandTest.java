package Priority1.Command.TextEditorExample;

// Test for Command (Text Editor)
// TODO: Implement testExecuteWrite() - create editor, WriteCommand("Hello"), invoker, set command, execute

public class CommandTest {

    public static void main(String[] args) {
        System.out.println("=== Command (Text Editor) Tests ===\n");
        testExecuteWrite();
        testUndo();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: TextEditor editor = new TextEditor(); Command cmd = new WriteCommand(editor, "Hello");
    //       CommandInvoker invoker = new CommandInvoker(); invoker.setCommand(cmd); invoker.executeCommand();
    // TODO: invoker.setCommand(new WriteCommand(editor, "Hello")); invoker.executeCommand();
    private static void testExecuteWrite() {
        System.out.println("Test 1: Execute Write Command");
        TextEditor editor = new TextEditor();
        CommandInvoker invoker = new CommandInvoker();
        // TODO: invoker.setCommand(new WriteCommand(editor, "Hello")); invoker.executeCommand();
        invoker.setCommand(new WriteCommand(editor,"Hello"));
        invoker.executeCommand();
        assert "Hello".equals(editor.getText()) : "Editor should contain Hello";
        System.out.println("  ✓ Passed\n");
    }

    private static void testUndo() {
        System.out.println("Test 2: Undo Command");
        TextEditor editor = new TextEditor();
        CommandInvoker invoker = new CommandInvoker();
        invoker.setCommand(new WriteCommand(editor, "X"));
        invoker.executeCommand();
        invoker.setCommand(new UndoCommand(editor));
        invoker.executeCommand();
        assert editor.getText().isEmpty() : "After undo, text should be empty";
        System.out.println("  ✓ Passed\n");
    }
}
