import java.util.*;

class GfG {
  
    // BFS from given source s
    static void bfs(List<List<Integer>> adj, int s) {
      
        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Initially mark all the vertices as not visited
        // When we push a vertex into the q, we mark it as 
        // visited
        boolean[] visited = new boolean[adj.size()];
        
        // Mark the source node as visited and enqueue it
        visited[s] = true;
        q.add(s);
        
        // Iterate over the queue
        while (!q.isEmpty()) {
          
            // Dequeue a vertex and print it
            int curr = q.poll();
            System.out.print(curr + " ");
            
            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent has not been visited, mark it 
            // visited and enqueue it
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    // Function to add an edge to the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    public static void main(String[] args) {
      
        // Number of vertices in the graph
        int V = 5;
        
        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);
        
        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0:");
        bfs(adj, 0);
    }
}
