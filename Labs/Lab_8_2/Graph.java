package Lab_8_2;

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

    // Método para realizar Breadth-First Search (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS starting from node " + start + ":");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor.destination]) {
                    visited[neighbor.destination] = true;
                    queue.add(neighbor.destination);
                }
            }
        }
        System.out.println();
    }

    // Método para realizar Depth-First Search (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (Node neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor.destination]) {
                dfsHelper(neighbor.destination, visited);
            }
        }
    }

    // Método para realizar Dijkstra
    public void dijkstra(int start) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);

        minHeap.add(new Node(start, 0));
        distances[start] = 0;

        System.out.println("Dijkstra starting from node " + start + ":");
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();

            if (current.weight > distances[current.destination]) {
                continue; // Se ignora el nodo si se encuentra un camino más corto
            }

            System.out.print(current.destination + " ");

            for (Node neighbor : adjacencyList.get(current.destination)) {
                int newDistance = distances[current.destination] + neighbor.weight;
                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    minHeap.add(new Node(neighbor.destination, newDistance));
                }
            }
        }
        System.out.println();
    }
}
