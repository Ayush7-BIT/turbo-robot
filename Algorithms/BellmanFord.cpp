#include <bits/stdc++.h>

using namespace std;

// Structure to represent an edge in the graph
struct Edge {
    int source, destination, weight;
};

// Function to implement the Bellman-Ford Algorithm
vector<int> bellmanFord(int vertices, int edgesCount, const vector<Edge>& edges, int source) {
    // Vector to store the shortest distance from the source to each vertex
    vector<int> distance(vertices, INT_MAX);
    distance[source] = 0; // Distance to the source is 0

    // Relax all edges |V| - 1 times
    for (int i = 1; i <= vertices - 1; i++) {
        for (const auto& edge : edges) {
            if (distance[edge.source] != INT_MAX && 
                distance[edge.source] + edge.weight < distance[edge.destination]) {
                distance[edge.destination] = distance[edge.source] + edge.weight;
            }
        }
    }

    // Check for negative weight cycles
    for (const auto& edge : edges) {
        if (distance[edge.source] != INT_MAX && 
            distance[edge.source] + edge.weight < distance[edge.destination]) {
            cout << "Graph contains a negative weight cycle." << endl;
            return {};
        }
    }

    return distance; // Return the vector of distances
}

int main() {
    int vertices = 5; // Number of vertices
    int edgesCount = 8; // Number of edges
    vector<Edge> edges;

    // Adding edges to the graph (source, destination, weight)
    edges.push_back({0, 1, -1});
    edges.push_back({0, 2, 4});
    edges.push_back({1, 2, 3});
    edges.push_back({1, 3, 2});
    edges.push_back({1, 4, 2});
    edges.push_back({3, 2, 5});
    edges.push_back({3, 1, 1});
    edges.push_back({4, 3, -3});

    int source = 0; // Starting point for Bellman-Ford algorithm
    vector<int> distances = bellmanFord(vertices, edgesCount, edges, source);

    // Output the shortest distances from the source
    if (!distances.empty()) {
        cout << "Vertex Distance from Source (" << source << "):" << endl;
        for (int i = 0; i < vertices; i++) {
            cout << "Vertex " << i << ": " << distances[i] << endl;
        }
    }

    return 0;
}
