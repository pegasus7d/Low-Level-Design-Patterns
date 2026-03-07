package Priority3.ChainOfResponsibility.LoggerExample;

public class InfoHandler extends LogHandler {
    public void log(String level, String message) {
        if ("INFO".equals(level)) System.out.println("INFO: " + message);
        else if (next != null) next.log(level, message);
    }
}
