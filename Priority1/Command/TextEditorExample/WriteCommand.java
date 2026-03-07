package Priority1.Command.TextEditorExample;

// Concrete command - writes text to editor
// TODO: Same pattern for UndoCommand (hold editor, execute() -> editor.undo())
public class WriteCommand implements Command {
    private final TextEditor editor;
    private final String text;
    public WriteCommand(TextEditor editor, String text) { this.editor = editor; this.text = text; }
    public void execute() { editor.write(text); }
}
