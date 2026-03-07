package Priority3.ObjectPool.ConnectionPoolExample;

// Object Pool - reuses PooledConnection instead of creating new each time
// TODO: acquire() returns unused from pool or new if under maxSize; release(conn) sets inUse false
import java.util.ArrayList;
import java.util.List;
public class ConnectionPool {
    private final int maxSize;
    private final List<PooledConnection> pool = new ArrayList<>();
    public ConnectionPool(int maxSize) { this.maxSize = maxSize; }
    public PooledConnection acquire() {
        for (PooledConnection c : pool) {
            if (!c.isInUse()) { c.setInUse(true); return c; }
        }
        if (pool.size() < maxSize) {
            PooledConnection c = new PooledConnection();
            c.setInUse(true);
            pool.add(c);
            return c;
        }
        return null;
    }
    public void release(PooledConnection conn) {
        if (conn != null) conn.setInUse(false);
    }
}
