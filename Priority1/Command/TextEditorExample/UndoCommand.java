package Priority1.Command.TextEditorExample;

// Concrete command - undoes last write
public class UndoCommand implements Command {
    private final TextEditor editor;
    public UndoCommand(TextEditor editor) { this.editor = editor; }
    public void execute() { editor.undo(); }
}
