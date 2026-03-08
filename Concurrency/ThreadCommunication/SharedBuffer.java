package Concurrency.ThreadCommunication;

/**
 * Concurrency topic 5: Thread Communication — wait/notify.
 * TODO: One thread sets a message; another waits until message is set, then reads it.
 * Implement: setMessage(String msg) — set field and notifyAll(); getMessage() — wait until message non-null, then return it.
 */
public class SharedBuffer {
    private String message = null;

    // TODO: add synchronized to method; set message and call notifyAll()
    public void setMessage(String msg) {
        this.message = msg;
        notifyAll();
    }

    // TODO: add synchronized to method; while (message == null) wait(); then return message
    public String getMessage() throws InterruptedException {
        while (message == null) {
            wait();
        }
        return message;
    }
}
