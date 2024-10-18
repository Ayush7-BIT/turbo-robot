import java.util.*;

public class Dijkstra {
    static class Conn {
        int dest, weight;
        Conn(int d, int w) { dest = d; weight = w; }
    }

    static class Graph {
        List<List<Conn>> adjList;
        Graph(int v) {
            adjList = new ArrayList<>(v);
            for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        }

        void addConn(int src, int dest, int weight) {
            adjList.get(src).add(new Conn(dest, weight));
        }

        int[] shortestPaths(int start) {
            int v = adjList.size();
            int[] dist = new int[v];
            boolean[] visited = new boolean[v];
            PriorityQueue<Conn> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.weight));
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            pq.add(new Conn(start, 0));

            while (!pq.isEmpty()) {
                Conn current = pq.poll();
                int u = current.dest;
                if (visited[u]) continue;
                visited[u] = true;

                for (Conn conn : adjList.get(u)) {
                    int newDist = dist[u] + conn.weight;
                    if (newDist < dist[conn.dest]) {
                        dist[conn.dest] = newDist;
                        pq.add(new Conn(conn.dest, newDist));
                    }
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addConn(0, 1, 10);
        g.addConn(0, 2, 3);
        g.addConn(1, 2, 1);
        g.addConn(1, 3, 2);
        g.addConn(2, 1, 4);
        g.addConn(2, 3, 8);
        g.addConn(2, 4, 2);
        g.addConn(3, 4, 7);
        g.addConn(4, 3, 9);

        int[] paths = g.shortestPaths(0);
        for (int i = 0; i < paths.length; i++) {
            System.out.println("To vertex " + i + " : " + paths[i]);
        }
    }
}
