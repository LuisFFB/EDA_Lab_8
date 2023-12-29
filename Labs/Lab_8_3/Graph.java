package Lab_8_3;

import java.util.*;

class Graph {
    private final int V; // Número de vértices
    private final List<List<Integer>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public boolean isGraphIncluded(Graph otherGraph) {
        if (this.V != otherGraph.V) {
            return false; // Los grafos tienen diferentes números de vértices
        }

        // Verificar si todos los vértices del primer grafo están presentes en el segundo grafo
        for (int i = 0; i < this.V; i++) {
            if (!otherGraph.adjacencyList.get(i).containsAll(this.adjacencyList.get(i))) {
                return false;
            }
        }

        return true;
    }
}
