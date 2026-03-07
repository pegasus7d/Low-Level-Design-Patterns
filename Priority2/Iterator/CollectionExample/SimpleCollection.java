package Priority2.Iterator.CollectionExample;

// Concrete aggregate - holds items, provides iterator
// TODO: Hold String[] or List<String>. add(String s). getIterator() returns new SimpleIterator(this)
public class SimpleCollection {
    private String[] items = new String[10];
    private int count = 0;
    public void add(String s) { if (count < items.length) items[count++] = s; }
    public int size() { return count; }
    public String getAt(int i) { return items[i]; }
    // TODO: public SimpleIterator getIterator() { return new SimpleIterator(this); }
    public SimpleIterator getIterator() { return new SimpleIterator(this); }
}
