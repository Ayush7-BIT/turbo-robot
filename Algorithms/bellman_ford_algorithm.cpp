#include <iostream>
#include <vector>
#include <climits>  // For representing infinity (INT_MAX)

using namespace std;

// Struct to represent an edge in the graph
struct Edge {
    int src, dest, weight;
};

class Graph {
    int V, E;  // Number of vertices and edges
    vector<Edge> edges;  // List of edges

public:
    // Constructor to initialize graph with V vertices and E edges
    Graph(int vertices, int edges) {
        V = vertices;
        E = edges;
        edges.reserve(edges);  // Pre-allocate space for edges
    }

    // Function to add an edge to the graph
    void addEdge(int u, int v, int w) {
        Edge edge = {u, v, w};  // Create an edge with source u, destination v, and weight w
        edges.push_back(edge);
    }

    // Bellman-Ford algorithm to find the shortest path from a given source vertex
    void findShortestPaths(int start) {
        // Step 1: Initialize distances from the source to all vertices
        vector<int> distances(V, INT_MAX);
        distances[start] = 0;

        // Step 2: Relax each edge V-1 times
        for (int i = 1; i < V; i++) {
            for (const Edge& edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                // Relaxation step: update distance if a shorter path is found
                if (distances[u] != INT_MAX && distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (const Edge& edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            // If we can still relax an edge, there is a negative-weight cycle
            if (distances[u] != INT_MAX && distances[u] + w < distances[v]) {
                cout << "The graph contains a negative-weight cycle!" << endl;
                return;
            }
        }

        // Output the computed shortest distances
        printDistances(distances, start);
    }

    // Function to print the shortest distances from the source vertex
    void printDistances(const vector<int>& distances, int start) const {
        cout << "Shortest distances from vertex " << start << ":\n";
        for (int i = 0; i < V; i++) {
            if (distances[i] == INT_MAX) {
                cout << "Vertex " << i << ": Infinity" << endl;
            } else {
                cout << "Vertex " << i << ": " << distances[i] << endl;
            }
        }
    }
};

int main() {
    int V = 5;  // Number of vertices
    int E = 8;  // Number of edges

    // Create a graph with 5 vertices and 8 edges
    Graph g(V, E);

    // Define the edges with their respective weights
    g.addEdge(0, 1, -1);
    g.addEdge(0, 2, 4);
    g.addEdge(1, 2, 3);
    g.addEdge(1, 3, 2);
    g.addEdge(1, 4, 2);
    g.addEdge(3, 2, 5);
    g.addEdge(3, 1, 1);
    g.addEdge(4, 3, -3);

    // Start Bellman-Ford from vertex 0
    int startVertex = 0;
    g.findShortestPaths(startVertex);

    return 0;
}
