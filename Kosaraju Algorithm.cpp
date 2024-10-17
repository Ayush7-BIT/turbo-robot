#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Graph {
public:
    int V; // Number of vertices
    vector<vector<int>> adj; // Adjacency list for the original graph
    vector<vector<int>> transposedAdj; // Adjacency list for the transposed graph

    Graph(int v) : V(v) {
        adj.resize(V);
        transposedAdj.resize(V);
    }

    void addEdge(int src, int dest) {
        adj[src].push_back(dest); // Add edge to the original graph
    }

    void dfs(int v, vector<bool>& visited, stack<int>& Stack) {
        visited[v] = true;

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, Stack);
            }
        }

        Stack.push(v); // Push vertex to stack after visiting all neighbors
    }

    void transpose() {
        for (int v = 0; v < V; v++) {
            for (int neighbor : adj[v]) {
                transposedAdj[neighbor].push_back(v); // Reverse the direction of edges
            }
        }
    }

    void dfsTransposed(int v, vector<bool>& visited) {
        visited[v] = true;
        cout << v << " ";

        for (int neighbor : transposedAdj[v]) {
            if (!visited[neighbor]) {
                dfsTransposed(neighbor, visited);
            }
        }
    }

    void kosaraju() {
        stack<int> Stack;
        vector<bool> visited(V, false);

        // Step 1: Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, Stack);
            }
        }

        // Step 2: Create transposed graph
        transpose();

        // Step 3: Perform DFS on the transposed graph
        fill(visited.begin(), visited.end(), false);
        cout << "Strongly Connected Components:\n";
        while (!Stack.empty()) {
            int v = Stack.top();
            Stack.pop();

            if (!visited[v]) {
                dfsTransposed(v, visited);
                cout << endl; // Print each SCC in a new line
            }
        }
    }
};

int main() {
    Graph g(5); // Create a graph with 5 vertices

    // Add edges to the graph
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(1, 3);
    g.addEdge(3, 4);

    g.kosaraju(); // Find and print strongly connected components

    return 0;
}
