package com.dsa.practice.dynamicProgramming;

public class LongestIncreasingPathInAMatrix {

/**
 * Brief Explanation:
 * The problem is to find the longest increasing path in a 2D matrix. An
 * increasing path is defined as a sequence of cells where each cell's value is
 * greater than the previous cell's value. The path can move in four directions:
 * up, down, left, and right.
 * Brute Force Approach:
 * 1. For each cell in the matrix, perform a Depth-First Search (
 *  DFS) to explore all possible increasing paths starting from that cell.
 * 2. Keep track of the maximum length of the increasing path found during the
 * DFS.
 * 3. Return the maximum length found after exploring all cells.
 * Optimized Approach (Using Memoization):
 * 1. Use a 2D array (memo) to store the length of
 * the longest increasing path starting from each cell.
 * 2. For each cell, if its value is already computed in the memo array, return
 * that value.
 * 3. Otherwise, perform DFS to explore all four directions (up, down,
 * left, right) and calculate the length of the increasing path.
 * 4. Store the computed length in the memo array before returning it.
 * 5. Finally, return the maximum length found after exploring all cells.
 * Time Complexity: O(m * n), where m is the number of rows and n
 * is the number of columns in the matrix. Each cell is processed once.
 * Space Complexity: O(m * n) for the memoization array and the recursion stack
 * in the worst case.
 */
private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
private int m, n;

public int longestIncreasingPath(int[][] matrix){
    if(matrix.length == 0) return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] cache = new int[m][n];
    int ans = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            ans = Math.max(ans, dfs(matrix, i, j,cache));
        }
    }
    return ans;
}
private int dfs(int[][] matrix, int i, int j, int[][] cache){
    if(cache[i][j] != 0) return cache[i][j];
    for(int[] dir : dirs){
        int x = i + dir[0];
        int y = j + dir[1];
        if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
}

public static void main(String[] args) {
    LongestIncreasingPathInAMatrix lip = new LongestIncreasingPathInAMatrix();
    int[][] matrix = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
    };
    System.out.println("Longest Increasing Path Length: " + lip.longestIncreasingPath(matrix)); // Output: 4
}
}

