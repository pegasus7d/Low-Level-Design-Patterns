package Priority2.TemplateMethod.DataProcessorExample;

// Abstract class - template method defineAlgorithm() calls steps
// TODO: defineAlgorithm() { readData(); processData(); saveData(); } - subclasses override the steps
public abstract class DataProcessor {
    public final void defineAlgorithm() {
        readData();
        processData();
        saveData();
    }
    protected abstract void readData();
    protected abstract void processData();
    protected abstract void saveData();
}
