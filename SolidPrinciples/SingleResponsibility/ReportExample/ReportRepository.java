package SolidPrinciples.SingleResponsibility.ReportExample;

/**
 * SRP: Single Responsibility — this class only PERSISTS reports (save/load).
 * It does NOT generate report content; that is ReportGenerator's job.
 *
 * TODO: Implement save(Report report) to "save" by storing in memory (e.g. a list or map).
 * TODO: Implement getLastReport() to return the last saved report, or null if none.
 */
public class ReportRepository {

    // TODO: Add a field to hold the last saved report (or a list if you prefer)

    public void save(Report report) {
        // TODO: Store the report so getLastReport() can return it
    }

    public Report getLastReport() {
        // TODO: Return the last saved report, or null
        return null;
    }
}
