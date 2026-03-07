package Priority2.Composite.FileSystemExample;

// Leaf - single file
public class File implements FileSystemComponent {
    private String name;
    public File(String name) { this.name = name; }
    public String getName() { return name; }
    public void show(int indent) {
        for (int i = 0; i < indent; i++) System.out.print("  ");
        System.out.println("File: " + name);
    }
}
