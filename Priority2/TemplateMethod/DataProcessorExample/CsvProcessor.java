package Priority2.TemplateMethod.DataProcessorExample;

// Concrete processor - CSV steps
// TODO: extend DataProcessor, implement readData/processData/saveData (e.g. print "Read CSV", "Process CSV", "Save CSV")
public class CsvProcessor extends DataProcessor {
    protected void readData() { System.out.println("Read CSV"); }
    protected void processData() { System.out.println("Process CSV"); }
    protected void saveData() { System.out.println("Save CSV"); }
}
