import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> extends BST<Tuple<K, V>> implements Map61B<K, V> {
    public BSTNode<Tuple<K, V>> root;

    public BSTMap() {
        root = new BSTNode<>();
        size = 0;
    }

    /** Associates the specified value with the specified key in this map.
     *  If the map already contains the specified key, replaces the key's mapping
     *  with the value specified. */
    @Override
    public void put(K key, V value) {
        Tuple<K, V> target = new Tuple<>(key, value);
        BSTNode<Tuple<K, V>> result = root.find(target);
        if (result.item == null) {
            result.insert(target);
            size += 1;
        } else {
            result.item.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
    @Override
    public V get(K key) {
        BSTNode<Tuple<K, V>> result = root.find(new Tuple<>(key, null));
        if (result.item == null) {
            return null;
        } else {
            return result.item.value;
        }
    }

    /** Returns whether this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return root.contains(new Tuple<>(key, null));
    }

    /** Removes every mapping from this map. */
    @Override
    public void clear() {
        root = new BSTNode<>();
        size = 0;
    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        // return Set.of();
        throw new UnsupportedOperationException();
    }

    /** Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        Tuple<K, V> target = new Tuple<>(key, null);
        Tuple<K, V> tupleDeleted = root.delete(target);
        if (tupleDeleted == null) {
            return null;
        } else {
            size -= 1;
            return tupleDeleted.value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        // return null;
        throw new UnsupportedOperationException();
    }
}
