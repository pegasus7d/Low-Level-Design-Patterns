package Priority3.Memento.EditorExample;

// Originator - creates and restores from memento
public class Editor {
    private String content = "";
    public void setContent(String s) { content = s; System.out.println("Content: " + content); }
    public String getContent() { return content; }
    public Memento save() { return new Memento(content); }
    public void restore(Memento m) { if (m != null) content = m.getState(); }
}
