package Lab_8_1;

public class ListaDeAdyacencia {
    public static void main(String[] args) {
        // Crear un grafo con 5 vértices
        Graph graph = new Graph(5);

        // Agregar aristas al grafo
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 9);
        graph.addEdge(3, 4, 7);

        // Imprimir el grafo
        graph.printGraph();
    }
}
