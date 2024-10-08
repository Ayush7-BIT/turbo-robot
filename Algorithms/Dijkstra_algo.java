import java.util.*;

class Dijkstra_algo {

    // A class to represent a node in the graph
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        // Constructor
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // Compare nodes based on their distance
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    // Dijkstra's algorithm to find the shortest path from a source node to all other nodes
    public static void dijkstra(int[][] graph, int source) {
        int V = graph.length; // Number of vertices

        // Distance array to store the shortest distance from the source to each vertex
        int[] dist = new int[V];

        // A priority queue (min-heap) to process nodes based on the shortest distance
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Boolean array to track visited nodes
        boolean[] visited = new boolean[V];

        // Initialize all distances to infinity, except for the source node
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Add the source node to the priority queue with a distance of 0
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            // Get the node with the smallest distance from the priority queue
            Node current = pq.poll();
            int u = current.vertex;

            // Skip processing if the node has already been visited
            if (visited[u]) continue;

            // Mark the node as visited
            visited[u] = true;

            // Loop through all the neighbors of the current node
            for (int v = 0; v < V; v++) {
                // Check if there is an edge between u and v, and if v has not been visited
                if (graph[u][v] != 0 && !visited[v]) {
                    // Calculate the new distance to the neighbor
                    int newDist = dist[u] + graph[u][v];

                    // If the new distance is shorter, update the distance and add it to the queue
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, newDist));
                    }
                }
            }
        }

        // Print the shortest distances from the source to all vertices
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
                {0, 10, 0, 0, 0, 0, 0, 8},
                {10, 0, 8, 0, 0, 2, 0, 0},
                {0, 8, 0, 7, 0, 0, 4, 0},
                {0, 0, 7, 0, 9, 14, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0},
                {0, 2, 0, 14, 10, 0, 2, 0},
                {0, 0, 4, 0, 0, 2, 0, 1},
                {8, 0, 0, 0, 0, 0, 1, 0}
        };

        // Run Dijkstra's algorithm starting from vertex 0
        dijkstra(graph, 0);
    }
}
