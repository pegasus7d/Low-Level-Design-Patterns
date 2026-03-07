package Priority2.Composite.FileSystemExample;

// Composite - folder containing files and subfolders
// TODO: Hold name and List<FileSystemComponent> children. add(FileSystemComponent c). show(indent) prints name then each child.show(indent+1)
import java.util.ArrayList;
import java.util.List;
public class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();
    public Folder(String name) { this.name = name; }
    public String getName() { return name; }
    public void add(FileSystemComponent c) { children.add(c); }
    public void show(int indent) {
        // TODO: print indent spaces + "Folder: " + name, then for each child child.show(indent+1)
        for (int i = 0; i < indent; i++) System.out.print("  ");
        System.out.println("Folder: " + name);
        for (FileSystemComponent c : children) c.show(indent + 1);
    }
}
