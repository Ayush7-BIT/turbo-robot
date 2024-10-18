#include <iostream>
#include <vector>
#include <limits>
#include <queue>

using namespace std;

struct Node {
    int vertex;
    int weight;
};

struct Compare {
    bool operator()(const Node& a, const Node& b) {
        return a.weight > b.weight;
    }
};

vector<int> dijkstra(vector<vector<Node>>& graph, int start) {
    int numVertices = graph.size();
    vector<int> distances(numVertices, numeric_limits<int>::max());
    vector<bool> visited(numVertices, false);
    priority_queue<Node, vector<Node>, Compare> pq;

    distances[start] = 0;
    pq.push({start, 0});

    while (!pq.empty()) {
        int currentVertex = pq.top().vertex;
        pq.pop();

        if (visited[currentVertex]) {
            continue;
        }

        visited[currentVertex] = true;

        for (const Node& neighbor : graph[currentVertex]) {
            int newDistance = distances[currentVertex] + neighbor.weight;
            if (newDistance < distances[neighbor.vertex]) {
                distances[neighbor.vertex] = newDistance;
                pq.push({neighbor.vertex, newDistance});
            }
        }
    }

    return distances;
}

int main() {
    int numVertices = 6;
    vector<vector<Node>> graph(numVertices);

    graph[0].push_back({1, 4});
    graph[0].push_back({2, 2});
    graph[1].push_back({3, 5});
    graph[2].push_back({1, 1});
    graph[2].push_back({3, 8});
    graph[2].push_back({4, 10});
    graph[3].push_back({4, 2});
    graph[3].push_back({5, 3});
    graph[4].push_back({5, 6});

    vector<int> distances = dijkstra(graph, 0);

    cout << "Vertex\tDistance from Source" << endl;
    for (int i = 0; i < numVertices; i++) {
        cout << i << "\t" << distances[i] << endl;
    }

    return 0;
}
