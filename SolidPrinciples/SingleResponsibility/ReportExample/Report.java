package SolidPrinciples.SingleResponsibility.ReportExample;

/**
 * Simple data class holding report title and content.
 * SRP: This class has one reason to change (report data structure).
 */
public class Report {
    private final String title;
    private final String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
