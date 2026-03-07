package Priority3.ObjectPool.ConnectionPoolExample;

// Reusable resource - expensive to create
public class PooledConnection {
    private boolean inUse;
    public PooledConnection() { this.inUse = false; }
    public void setInUse(boolean inUse) { this.inUse = inUse; }
    public boolean isInUse() { return inUse; }
    public void connect() { System.out.println("Connected"); }
    public void disconnect() { System.out.println("Disconnected"); }
}
