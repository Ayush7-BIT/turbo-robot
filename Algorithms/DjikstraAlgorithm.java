import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private List<List<Node>> adjList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Adds an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
        adjList.get(destination).add(new Node(source, weight)); // For undirected graph
    }

    // Dijkstra's algorithm to find the shortest path
    public void dijkstra(int startVertex) {
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.weight));
        int[] distances = new int[vertices]; // Store the shortest distances
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            for (Node neighbor : adjList.get(currentVertex)) {
                int newDist = distances[currentVertex] + neighbor.weight;

                // Only consider this new path if it's better
                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        // Print the shortest path from the startVertex to all other vertices
        printSolution(distances);
    }

    // Prints the shortest distances
    private void printSolution(int[] distances) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    // Class to represent a node in the graph
    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Main method to test the Dijkstra algorithm
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Adding edges to the graph (source, destination, weight)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);

        // Running Dijkstra's algorithm from vertex 0
        graph.dijkstra(0);
    }
}
