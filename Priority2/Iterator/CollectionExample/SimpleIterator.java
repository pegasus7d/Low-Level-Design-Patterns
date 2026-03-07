package Priority2.Iterator.CollectionExample;

// Iterator - traverses SimpleCollection
// TODO: Hold SimpleCollection and index. hasNext() -> index < collection.size(). next() -> collection.getAt(index++)
public class SimpleIterator {
    private final SimpleCollection collection;
    private int index = 0;
    public SimpleIterator(SimpleCollection collection) { this.collection = collection; }
    public boolean hasNext() { return index < collection.size(); }
    public String next() { return collection.getAt(index++); }
}
