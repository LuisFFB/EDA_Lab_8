package Lab_8_2;

public class GraphAlgorithmsTest {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Agregar aristas al grafo
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 5);

        // Prueba BFS
        graph.bfs(0);

        // Prueba DFS
        graph.dfs(0);

        // Prueba Dijkstra
        graph.dijkstra(0);
    }
}
