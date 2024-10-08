#include <bits/stdc++.h>
using namespace std;

// Function to implement Dijkstra's Algorithm
vector<int> dijkstra(int vertices, const vector<vector<pair<int, int>>>& graph, int source) {
    // Vector to store the shortest distance from source to each vertex
    vector<int> distance(vertices, INT_MAX);
    distance[source] = 0; // Distance to the source is 0

    // Priority queue to select the vertex with the smallest distance
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, source}); // Push the source with distance 0

    while (!pq.empty()) {
        // Get the vertex with the smallest distance
        int current_distance = pq.top().first;
        int current_vertex = pq.top().second;
        pq.pop();

        // If the distance is greater than the stored distance, skip it
        if (current_distance > distance[current_vertex]) {
            continue;
        }

        // Explore all neighbors of the current vertex
        for (const auto& neighbor : graph[current_vertex]) {
            int next_vertex = neighbor.first;
            int edge_weight = neighbor.second;

            // Calculate the distance to the neighbor
            int new_distance = current_distance + edge_weight;

            // If the calculated distance is less, update it and push to the queue
            if (new_distance < distance[next_vertex]) {
                distance[next_vertex] = new_distance;
                pq.push({new_distance, next_vertex});
            }
        }
    }

    return distance; // Return the vector of distances
}

int main() {
    int vertices = 5; // Number of vertices
    // Graph represented as an adjacency list
    vector<vector<pair<int, int>>> graph(vertices);

    // Adding edges to the graph (u, v, weight)
    graph[0].push_back({1, 10});
    graph[0].push_back({2, 3});
    graph[1].push_back({2, 1});
    graph[1].push_back({3, 2});
    graph[2].push_back({1, 4});
    graph[2].push_back({3, 8});
    graph[2].push_back({4, 2});
    graph[3].push_back({4, 7});
    graph[4].push_back({3, 9});

    int source = 0; // Starting point for Dijkstra's algorithm
    vector<int> distances = dijkstra(vertices, graph, source);

    // Output the shortest distances from the source
    cout << "Vertex Distance from Source (" << source << "):" << endl;
    for (int i = 0; i < vertices; i++) {
        cout << "Vertex " << i << ": " << distances[i] << endl;
    }

    return 0;
}
