package SolidPrinciples.SingleResponsibility.ReportExample;

/**
 * SRP: Single Responsibility — this class only GENERATES report content.
 * It does NOT save to file or send emails; that would be another class's job.
 *
 * TODO: Implement generateReport(String title, String[] sections)
 * Return a new Report(title, content) where content is sections joined by newline.
 */
public class ReportGenerator {

    // TODO: Generate a Report with given title and content from sections (one line per section)
    public Report generateReport(String title, String[] sections) {
        // TODO: Join sections with "\n" to form content, then return new Report(title, content)
        return null;
    }
}
