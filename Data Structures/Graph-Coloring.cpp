#include <iostream>
#include <vector>
using namespace std;

bool isSafe(int v, vector<vector<int>> &graph, vector<int> &color, int c) {
    for (int i = 0; i < graph.size(); i++) {
        if (graph[v][i] == 1 && color[i] == c)
            return false;
    }
    return true;
}
bool graphColoringUtil(vector<vector<int>> &graph, int m, vector<int> &color, int v) {
    if (v == graph.size())
        return true;
    for (int c = 1; c <= m; c++) {
        if (isSafe(v, graph, color, c)) {
            color[v] = c;

            if (graphColoringUtil(graph, m, color, v + 1))
                return true;
            color[v] = 0;
        }
    }
    return false;
}
bool graphColoring(vector<vector<int>> &graph, int m) {
    int V = graph.size();
    vector<int> color(V, 0);

    if (graphColoringUtil(graph, m, color, 0)) {
        cout << "Solution exists with " << m << " colors.\n";
        for (int i = 0; i < V; i++)
            cout << "Vertex " << i << " --->  Color " << color[i] << endl;
        return true;
    }

    cout << "No solution exists with " << m << " colors.\n";
    return false;
}

int main() {
    vector<vector<int>> graph = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };

    int m = 3;
    graphColoring(graph, m);

    return 0;
}
