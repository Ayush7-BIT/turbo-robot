import java.util.*;

class Graph {
    private int V;  
    private List<List<Integer>> adj; 

  Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    Graph getTranspose() {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++) {
            for (int i : adj.get(v)) {
                g.addEdge(i, v);
            }
        }
        return g;
    }

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj.get(v)) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int n : adj.get(v)) {
            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }
        stack.push(v);
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        // Step 1
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Step 2
        Graph gr = getTranspose();

        // Step 3
        Arrays.fill(visited, false);

        // Step 4
        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                gr.DFS(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Strongly Connected Components:");
        g.printSCCs();
    }
}
