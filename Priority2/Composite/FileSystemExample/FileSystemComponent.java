package Priority2.Composite.FileSystemExample;

// Component - file or folder (uniform interface)
public interface FileSystemComponent {
    void show(int indent);
    String getName();
}
