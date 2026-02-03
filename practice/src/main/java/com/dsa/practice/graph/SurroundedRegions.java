package com.dsa.practice.graph;

public class SurroundedRegions {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Traverse the border cells of the grid.
 * 2. When a 'O' is found on the border, initiate a Depth-First Search (DFS)
 *    to mark all connected 'O's as safe (not to be flipped).
 * 3. After marking, traverse the entire grid and flip all unmarked 'O's to 'X's.
 * Optimized Approach using DFS from Borders: O(M * N) time and O(M * N) space
 * 1. Start DFS from all 'O's on the border of the grid and mark
 *  reachable 'O's as safe.
 *  2. Finally, traverse the grid to flip unmarked 'O's to 'X's and
 *   revert marked 'O's back to 'O's.
 * Time Complexity: O(M * N) where M is the number of rows and N is the number of columns in the grid.
 * Space Complexity: O(M * N) for the visited array in the worst case.
 */
public void solve(char[][] board) {
    if(board == null || board.length == 0) {
        return;
    }

    int m = board.length;
    int n = board[0].length;

    //Mark boundary connected 'O's with T
    for ( int i = 0; i < m; i++) {
        for ( int j = 0; j < n; j++) {
            if (( i == 0 || j == 0 
                || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
        }
    }

    // Capture surrounded regions and revert to 0
    for ( int i = 0; i < m; i++) {
        for ( int j = 0; j < n; j++) {
            if ( board[i][j] == 'O'){
                board[i][j] = 'X';
            } else if ( board[i][j] == 'T'){
                board[i][j] = 'O';
            }
        }
    }
}

private void dfs( char[][] board, int i, int j) {
    if( i < 0 || j < 0 || i >= board.length
        || j >= board[0].length || board[i][j] != '0') {
            return;
        }
        board[i][j] = 'T'; //Mark as visited
    dfs(board, i + 1, j);
    dfs(board, i - 1, j);
    dfs(board, i, j + 1);
    dfs(board, i, j - 1);
}
public static void main(String[] args) {
    SurroundedRegions solution = new SurroundedRegions();

    char[][] board = {
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}
    };

    solution.solve(board);

    for (char[] row : board) {
        for (char c : row) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
}
