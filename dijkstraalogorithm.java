//Add code for Dijkstra’s Algorithm in Java
import java.util.*;

class Dijkstra {

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
       public static void dijkstra(List<List<Node>> graph, int source) {
       
        int V = graph.size();

      
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[source] = 0;  
       
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));

      
        while (!pq.isEmpty()) {
            Node current = pq.poll(); 
            int u = current.vertex;

            
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;  
                    pq.offer(new Node(v, dist[v])); 
            }
        }

       
        System.out.println("Vertex\t\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
    public static void addEdge(List<List<Node>> graph, int u, int v, int weight) {
        graph.get(u).add(new Node(v, weight));
        graph.get(v).add(new Node(u, weight));  
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices in the graph
        List<List<Node>> graph = new ArrayList<>(V);

       
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (u, v, weight)
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 4, 5);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 4, 2);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 3, 4, 7);
        addEdge(graph, 3, 2, 6);
        addEdge(graph, 4, 2, 9);

        dijkstra(graph, 0);
    }
}
