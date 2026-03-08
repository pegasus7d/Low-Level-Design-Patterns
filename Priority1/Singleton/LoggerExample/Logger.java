package Priority1.Singleton.LoggerExample;

// Singleton: only one instance of Logger exists in the app
// TODO: Implement the singleton pattern

public class Logger {

    private Logger(){}
    private static class LoggerHolder{
        static final Logger INSTANCE=new Logger();
    }
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    // Example instance method (for testing)
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
