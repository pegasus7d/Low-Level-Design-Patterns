package Priority3.ChainOfResponsibility.LoggerExample;

// Handler - process request or pass to next
public abstract class LogHandler {
    protected LogHandler next;
    public void setNext(LogHandler next) { this.next = next; }
    public abstract void log(String level, String message);
}
