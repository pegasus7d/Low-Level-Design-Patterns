package Priority2.TemplateMethod.DataProcessorExample;

// Concrete processor - JSON steps
public class JsonProcessor extends DataProcessor {
    protected void readData() { System.out.println("Read JSON"); }
    protected void processData() { System.out.println("Process JSON"); }
    protected void saveData() { System.out.println("Save JSON"); }
}
