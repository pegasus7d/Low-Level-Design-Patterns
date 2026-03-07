package Priority3.ChainOfResponsibility.LoggerExample;

public class ErrorHandler extends LogHandler {
    public void log(String level, String message) {
        if ("ERROR".equals(level)) System.out.println("ERROR: " + message);
        else if (next != null) next.log(level, message);
    }
}
