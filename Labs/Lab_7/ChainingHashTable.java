package Lab_7;

public class ChainingHashTable<K, V> implements HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedListNode<K, V>[] table;

    public ChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public ChainingHashTable(int capacity) {
        this.table = new LinkedListNode[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedListNode<>(key, value);
        } else {
            // Manejar colisión por encadenamiento
            LinkedListNode<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new LinkedListNode<>(key, value);
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedListNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key no encontrada
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedListNode<K, V> current = table[index];
        LinkedListNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next; // Primer nodo de la lista
                } else {
                    prev.next = current.next; // Nodo intermedio o final de la lista
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedListNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
