import java.util.* ;

class Graph {
    private int numVertices; 
    private LinkedList<Integer>[] adjacencyList; 

    
Graph( int vertices) {
        numVertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices ; i++) {
            adjacencyList[i] = new LinkedList<>() ;
        }
    }

  
void addEdge ( int v, int w) {
        adjacencyList[v].add(w);
    }

  
void DFSUtil(int vertex, boolean[] visited) {
       
        visited[vertex] = true;
        System.out.print(vertex + " ");

for (int adj : adjacencyList[vertex]){
  
        if (!visited[adj]) {
          DFSUtil( adj, visited );
            }
        }
  }

void DFS( int startVertex) {
  
        boolean[] visited = new boolean[numVertices];

        DFSUtil( startVertex, visited);
    }

public static void main( String[] args) {
      
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

System.out.println("Depth-First Search starting from vertex 2:");graph.DFS(2);
    }
}
