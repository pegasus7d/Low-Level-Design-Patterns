package Priority1.Singleton.LoggerExample;

// Singleton: only one instance of Logger exists in the app
// TODO: Implement the singleton pattern

public class Logger {

    // TODO: Add a private static field to hold the single instance (theInstance)

    // TODO: Private constructor - so no one can do new Logger() from outside

    // TODO: Public static getInstance() that:
    // - Returns the single instance
    // - Creates it only on first call (lazy initialization: if null, create new Logger(), then return it)
    public static Logger getInstance() {
        // TODO: return the single instance (create if null)
        return null;
    }

    // Example instance method (for testing)
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
