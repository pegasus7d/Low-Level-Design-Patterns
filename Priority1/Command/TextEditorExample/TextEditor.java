package Priority1.Command.TextEditorExample;

// Receiver - the object that does the work
public class TextEditor {
    private StringBuilder text = new StringBuilder();
    public void write(String s) { text.append(s); System.out.println("Write: " + s); }
    public void undo() { if (text.length() > 0) { text.setLength(text.length() - 1); System.out.println("Undo"); } }
    public String getText() { return text.toString(); }
}
