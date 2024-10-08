#include <bits/stdc++.h>
using namespace std;

void primMST(vector<vector<int>> graph) {
    int v = graph.size();
    vector<int> parent(v), key(v, INT_MAX);
    vector<bool> vis(v, false);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    key[0] = 0;
    parent[0] = -1;
    pq.push({0, 0});

    while (!pq.empty()) {
        int node = pq.top().second;
        pq.pop();
        vis[node] = true;

        for (int i = 0; i < v; i++) {
            if (!vis[i] && graph[node][i] && graph[node][i] < key[i]) {
                pq.push({graph[node][i], i});
                key[i] = graph[node][i];
                parent[i] = node;
            }
        }
    }

    cout << "Edge \tWeight\n";
    for (int i = 1; i < v; i++)
        cout << parent[i] << " - " << i << " \t" << graph[i][parent[i]] << "\n";
}

int main() {
    vector<vector<int>> graph = {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};
    primMST(graph);
    return 0;
}
