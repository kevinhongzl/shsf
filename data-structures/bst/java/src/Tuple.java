public class Tuple<K extends Comparable<K>, V> implements Comparable<Tuple<K, V>>{
    public K key;
    public V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Tuple<K, V> another) {
        return this.key.compareTo(another.key);
    }
}

