package Lab_7;

public class TestHashTable {
    public static void main(String[] args) {
        // Pruebas para ChainingHashTable
        System.out.println("ChainingHashTable Test:");
        HashTable<Integer, String> chainingHashTable = new ChainingHashTable<>();
        testHashTable(chainingHashTable);

        // Pruebas para LinearProbingHashTable
        System.out.println("\nLinearProbingHashTable Test:");
        HashTable<Integer, String> linearProbingHashTable = new LinearProbingHashTable<>();
        testHashTable(linearProbingHashTable);
    }

    private static void testHashTable(HashTable<Integer, String> hashTable) {
        hashTable.put(1, "Uno");
        hashTable.put(2, "Dos");
        hashTable.put(3, "Tres");
        hashTable.put(4, "Cuatro");

        System.out.println("Get(2): " + hashTable.get(2));
        System.out.println("ContainsKey(3): " + hashTable.containsKey(3));

        hashTable.remove(1);
        System.out.println("ContainsKey(1) después de la eliminación: " + hashTable.containsKey(1));

        hashTable.put(5, "Five");

        System.out.println("Get(4) despues de rehashing: " + hashTable.get(4));
    }
}
