package Lab_8_3;

public class Main {
    public static void main(String[] args) {
        Graph graph1 = new Graph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);

        Graph graph2 = new Graph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);

        Graph graph3 = new Graph(5);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);

        // Prueba de inclusión
        System.out.println("¿Graph1 está incluido en Graph2? " + graph1.isGraphIncluded(graph2));
        System.out.println("¿Graph1 está incluido en Graph3? " + graph1.isGraphIncluded(graph3));
    }
}
