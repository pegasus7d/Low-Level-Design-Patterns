package Priority2.TemplateMethod.DataProcessorExample;

// Test for Template Method (Data Processor)
// TODO: Implement testCsvPipeline() - create CsvProcessor, call defineAlgorithm()

public class TemplateMethodTest {

    public static void main(String[] args) {
        System.out.println("=== Template Method (Data Processor) Tests ===\n");
        testCsvPipeline();
        testJsonPipeline();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: DataProcessor p = new CsvProcessor(); p.defineAlgorithm();
    private static void testCsvPipeline() {
        System.out.println("Test 1: CSV Pipeline");
        DataProcessor processor = null; // TODO: new CsvProcessor(), then processor.defineAlgorithm()
        assert processor != null : "Processor should not be null";
        processor.defineAlgorithm();
        System.out.println("  ✓ Passed\n");
    }

    private static void testJsonPipeline() {
        System.out.println("Test 2: JSON Pipeline");
        DataProcessor processor = new JsonProcessor();
        processor.defineAlgorithm();
        System.out.println("  ✓ Passed\n");
    }
}
