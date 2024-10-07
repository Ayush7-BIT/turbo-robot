#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// Function to perform BFS on the graph
void BFS(int start, const vector<vector<int>>& adjList) {
    vector<bool> visited(adjList.size(), false);
    queue<int> q;

    visited[start] = true;
    q.push(start);

    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " ";

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }
}

int main() {
    int V = 5; // Number of vertices
    vector<vector<int>> adjList(V);

    // Example graph
    adjList[0] = {1, 2};
    adjList[1] = {0, 3, 4};
    adjList[2] = {0, 4};
    adjList[3] = {1};
    adjList[4] = {1, 2};

    cout << "BFS starting from node 0: ";
    BFS(0, adjList);
    cout << endl;

    return 0;
}
