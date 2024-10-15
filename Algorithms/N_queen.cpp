#include <iostream>
#include <vector>

using namespace std;


bool isSafe(vector<vector<int>>& board, int row, int col, int N) {
    
    for (int i = 0; i < col; i++)
        if (board[row][i])
            return false;

   
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j])
            return false;

    
    for (int i = row, j = col; j >= 0 && i < N; i++, j--)
        if (board[i][j])
            return false;

    return true;
}


bool solveNQueen(vector<vector<int>>& board, int col, int N) {
  
    if (col >= N)
        return true;


    for (int i = 0; i < N; i++) {
        if (isSafe(board, i, col, N)) {
           
            board[i][col] = 1;

            
            if (solveNQueen(board, col + 1, N))
                return true;

            // If placing queen doesn't lead to a solution, backtrack
            board[i][col] = 0; 
        }
    }

   
    return false;
}


void printSolution(vector<vector<int>>& board, int N) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            cout << (board[i][j] ? "Q " : ". ");
        cout << endl;
    }
}


void solveNQueen(int N) {
    vector<vector<int>> board(N, vector<int>(N, 0));

    if (!solveNQueen(board, 0, N)) {
        cout << "Solution does not exist." << endl;
        return;
    }

    printSolution(board, N);
}

int main() {
    int N;
    cout << "Enter the value of N: ";
    cin >> N;
    solveNQueen(N);
    return 0;
}
