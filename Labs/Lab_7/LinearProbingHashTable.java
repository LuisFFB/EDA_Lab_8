package Lab_7;

public class LinearProbingHashTable<K, V> implements HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;

    public LinearProbingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % keys.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value; // Actualizar valor si la clave ya existe
                return;
            }
            index = (index + 1) % keys.length; // Sondeo lineal
        }
        keys[index] = key;
        values[index] = value;
    }

    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return (V) values[index];
            }
            index = (index + 1) % keys.length;
        }
        return null; // Key no encontrada
    }

    public void remove(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                keys[index] = null;
                values[index] = null;
                rehash(); // Reorganizar la tabla después de eliminar un elemento
                return;
            }
            index = (index + 1) % keys.length;
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return true;
            }
            index = (index + 1) % keys.length;
        }
        return false;
    }

    private void rehash() {
        int newCapacity = keys.length * 2;
        Object[] newKeys = new Object[newCapacity];
        Object[] newValues = new Object[newCapacity];

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                int newIndex = Math.abs(keys[i].hashCode() % newCapacity);
                while (newKeys[newIndex] != null) {
                    newIndex = (newIndex + 1) % newCapacity;
                }
                newKeys[newIndex] = keys[i];
                newValues[newIndex] = values[i];
            }
        }

        keys = newKeys;
        values = newValues;
    }
}
