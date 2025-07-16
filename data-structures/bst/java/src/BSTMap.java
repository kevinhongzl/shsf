import javax.annotation.Nonnull;
import java.util.*;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BST<Tuple<K, V>> tree = new BST<>();

    /** Associates the specified value with the specified key in this map.
     *  If the map already contains the specified key, replaces the key's mapping
     *  with the value specified. */
    @Override
    public void put(K key, V value) {
        Tuple<K, V> target = new Tuple<>(key, value);
        if (tree.contains(target)) {
            tree.remove(target);
        }
        tree.put(target);
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
    @Override
    public V get(K key) {
        Tuple<K, V> result = tree.get(new Tuple<>(key, null));
        return result != null? result.value : null;
    }

    /** Returns whether this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return tree.contains(new Tuple<>(key, null));
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return tree.size();
    }

    /** Removes every mapping from this map. */
    @Override
    public void clear() {
        tree = new BST<>();
    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        Set<K> keySet = new LinkedHashSet<>();
        for (K key: this) {
            keySet.add(key);
        }
        return keySet;
    }

    /** Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        Tuple<K, V> target = new Tuple<>(key, null);
        Tuple<K, V> tupleDeleted = tree.remove(target);
        return tupleDeleted != null ? tupleDeleted.value : null;
    }

    @Override
    @Nonnull
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K> {
        private final Iterator<Tuple<K, V>> treeIterator = tree.iterator();

        @Override
        public boolean hasNext() {
            return treeIterator.hasNext();
        }

        @Override
        public K next() {
            return treeIterator.next().key;
        }
    }
}
