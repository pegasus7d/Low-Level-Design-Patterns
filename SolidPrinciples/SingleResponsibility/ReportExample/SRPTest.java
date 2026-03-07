package SolidPrinciples.SingleResponsibility.ReportExample;

/**
 * Tests for Single Responsibility Principle: generation and persistence are separate.
 * TODO: Implement testSingleResponsibility() — use ReportGenerator AND ReportRepository together.
 */
public class SRPTest {

    public static void main(String[] args) {
        System.out.println("=== Single Responsibility Principle Tests ===\n");

        testSingleResponsibility();
        testGeneratorOnly();
        testRepositoryOnly();

        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Apply SRP: generate a report using ReportGenerator, then save it using ReportRepository.
    // Verify getLastReport() returns the same report (same title and content).
    private static void testSingleResponsibility() {
        System.out.println("Test 1: SRP — Generate then save (your assignment)");

        ReportGenerator generator = new ReportGenerator();
        ReportRepository repository = new ReportRepository();

        // TODO: 1) Generate report with title "Sales Q1" and sections ["Summary", "Details", "Conclusion"]
        // TODO: 2) Save that report using repository.save(...)
        // TODO: 3) Assert repository.getLastReport() is not null and has title "Sales Q1" and content containing "Summary"
        Report report = generator.generateReport("Sales Q1", new String[]{"Summary", "Details", "Conclusion"});
        repository.save(report);

        Report saved = repository.getLastReport();
        assert saved != null : "Last report should not be null";
        assert "Sales Q1".equals(saved.getTitle()) : "Title should be Sales Q1";
        assert saved.getContent().contains("Summary") : "Content should contain Summary";

        System.out.println("  Title: " + saved.getTitle());
        System.out.println("  ✓ Passed\n");
    }

    private static void testGeneratorOnly() {
        System.out.println("Test 2: Generator only (no persistence)");
        ReportGenerator g = new ReportGenerator();
        Report r = g.generateReport("Test", new String[]{"A", "B"});
        assert "Test".equals(r.getTitle()) : "Title";
        assert r.getContent().equals("A\nB") : "Content A\\nB";
        System.out.println("  ✓ Passed\n");
    }

    private static void testRepositoryOnly() {
        System.out.println("Test 3: Repository only (save/retrieve)");
        ReportRepository repo = new ReportRepository();
        assert repo.getLastReport() == null : "Initially null";
        Report r = new Report("X", "Y");
        repo.save(r);
        assert repo.getLastReport() == r : "Same instance";
        System.out.println("  ✓ Passed\n");
    }
}
