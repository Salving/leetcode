import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private final float loadFactor;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        initTable(capacity);
    }

    private void initTable(int capacity) {
        this.table = new LinkedList[capacity];
        for (int i = 0; i < this.table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        capacity = capacity * 2;
        initTable(capacity);
        size = 0;
        for (LinkedList<Entry<K, V>> row : oldTable) {
            for (Entry<K, V> entry : row) {
                put(entry.key, entry.value);
            }
        }
    }

    public void put(K key, V value) {
        int index = hash(key);

        LinkedList<Entry<K, V>> row = table[index];
        for (Entry<K, V> entry : row) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        Entry<K, V> entry = new Entry<>(key, value);
        row.add(entry);
        size++;

        if (size > capacity * loadFactor) {
            resize();
        }

    }

    public V get(K key) {
        int index = hash(key);

        LinkedList<Entry<K, V>> row = table[index];
        for (Entry<K, V> entry : row) {
            if (entry.key == key) return entry.value;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean remove(K key) {
        int index = hash(key);

        LinkedList<Entry<K, V>> row = table[index];
        for (Entry<K, V> entry : row) {
            if (entry.key == key) {
                row.remove(entry);
                size--;
                return true;
            }
        }

        return false;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();

        map.put("apples", "green");
        map.put("oranges", "orange");
        map.put("oranges", "blue");
        map.put("1", "blue");
        map.put("2", "blue");
        map.put("3", "blue");
        map.put("4", "blue");
        map.put("5", "blue");

        System.out.println(map.size());
        System.out.println(map.capacity);
    }
}
