package com.dsa.practice.graph;

public class NumberOfIslands {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Traverse each cell in the grid.
 *  2. When a '1' (land) is found, initiate a Depth-First Search (DFS)
 *     to mark all connected '1's as visited (change them to '0's).
 * 3. Increment the island count for each DFS initiation.
 * Optimized Approach using Union-Find: O(M * N * α(N)) time and O(M * N) space
 * 1. Initialize a Union-Find data structure to manage connected components.
 * 2. Traverse each cell in the grid.
 *  3. For each '1' found, union it with its adjacent '1's (right and down).
 * 4. Count the number of unique roots in the Union-Find structure to determine the number of islands.
 * Time Complexity: O(M * N) for both approaches, where M is the number of rows and N is the number of columns in the grid.
 * Space Complexity: O(M * N) for both approaches due to the storage of visited cells0 or Union-Find structure.
 */
public int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int island = 0;

    for ( int i = 0; i < row; i++) {
        for ( int j = 0; j < col; j++) {
            if ( grid[i][j] == '1') {
                island++;
                dfs(i, j, grid);
            }
        }
    }

    return island;
}
private void dfs( int row, int col, char[][] grid) {
    int newRow = grid.length;
    int newCol = grid[0].length;

    int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };

    if ( row < 0 || col < 0 || row >= newRow 
        || col >= newCol || grid[row][col] == '0') {
            return;
}

grid[row][col] = '0';

for ( int[] dir : directions) {
    dfs(row + dir[0], col + dir[1], grid);
}
}
public static void main(String[] args) {
    NumberOfIslands solution = new NumberOfIslands();

    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    int result = solution.numIslands(grid);
    System.out.println("Number of Islands: " + result); // Output: 3
}
}
