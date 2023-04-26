package Winter2022.h.hashcodeCollision;

/**
 * An implementation of HashMap that uses open addressing to resolve hashcode collisions.
 * The class uses an array of Entry objects to store the key-value pairs,
 * and a linear probing technique to find an available slot in the array when a collision occurs.
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values stored in the map
 */
public class OpenAddressingHashMap<K, V> {

    /**
     * Constants for default capacity and load factor
     */
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    /**
     * The array of entries representing the hash map
     */
    private Entry<K, V>[] table;
    /**
     * The number of entries currently stored in the hash map
     */
    private int size;

    /**
     * Constructs an empty OpenAddressingHashMap with the default initial capacity.
     */
    public OpenAddressingHashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @throws IllegalStateException if the hashmap is full
     */
    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int hash = key.hashCode() % table.length;
        int i = hash;

        do {
            if (table[i] == null || table[i].key.equals(key)) {
                table[i] = new Entry<>(key, value);
                size++;
                return;
            }

            i = (i + 1) % table.length;
        } while (i != hash);

        throw new IllegalStateException("hashmap is full");
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K key) {
        int hash = key.hashCode() % table.length;
        int i = hash;

        do {
            if (table[i] != null && table[i].key.equals(key)) {
                return table[i].value;
            }

            i = (i + 1) % table.length;
        } while (i != hash);
        return null;
    }

    /**
     * Resizes the underlying array to twice its current size and rehashes all entries.
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    /**
     * An inner class representing an entry in the hash map.
     *
     * @param <K> the type of the key for the entry
     * @param <V> the type of the value for the entry
     */
    private static class Entry<K, V> {
        /**
         * The key for the entry
         */
        private K key;

        /**
         * The value for the entry
         */
        private V value;


        /**
         * Constructs an entry with the specified key-value pair.
         *
         * @param key   the key for the entry
         * @param value the value for the entry
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
