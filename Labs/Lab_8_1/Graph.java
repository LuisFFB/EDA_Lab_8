package Lab_8_1;

import java.util.*;

class Graph {
    private final int V; // Número de vértices
    private final List<List<Node>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // Método para agregar una arista al grafo
    public void addEdge(int source, int destination, int weight) {
        Node newNode = new Node(destination, weight);
        adjacencyList.get(source).add(newNode);
    }

    // Método para imprimir el grafo
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Nodo " + i + ": ");
            for (Node node : adjacencyList.get(i)) {
                System.out.print("(" + node.destination + ", " + node.weight + ") ");
            }
            System.out.println();
        }
    }
}
