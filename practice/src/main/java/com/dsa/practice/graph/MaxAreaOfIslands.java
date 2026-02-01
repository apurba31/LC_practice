package com.dsa.practice.graph;

public class MaxAreaOfIslands {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Traverse each cell in the grid.
 * 2. When a '1' (land) is found, initiate a Depth-First Search (DFS)
 *    to calculate the area of the island by counting all connected '1's.
 *  3. Keep track of the maximum area encountered during the traversal.
 * Optimized Approach using DFS with Area Calculation: O(M * N) time and O(M * N) space
 * 1. Traverse each cell in the grid.
 * 2. When a '1' is found, initiate a DFS to calculate the area of the island.
 *   3. During the DFS, mark visited '1's as '0's to avoid counting them again.
 * 4. Update the maximum area if the current island's area is greater.
 * Time Complexity: O(M * N) for both approaches, where M is the number of rows and N is the number of columns in the grid.
 * Space Complexity: O(M * N) for both approaches due to the storage of visited cells
 */
public int maxAreaOfIsland(int[][] grid) {
    if( grid == null || grid.length == 0) {
        return 0;
    }

    int maxArea = 0;
    for( int i = 0; i < grid.length; i++) {
        for( int j = 0; j < grid[0].length; j++) {
            if( grid[i][j] == 1) {
                int area = dfs(i, j, grid);
                maxArea = Math.max(maxArea, area);
            }
        }
    }
    return maxArea;
}
private int dfs( int i, int j, int[][] grid) {
    if( i < 0 || j < 0 || i >= grid.length 
        || j >= grid[0].length  || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0; // Mark as visited
        int area = 1; // Current cell
        // Explore all 4 directions
        area += dfs(i + 1, j, grid);
        area += dfs(i - 1, j, grid);
        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);
        return area;
}
public static void main(String[] args) {
    MaxAreaOfIslands solution = new MaxAreaOfIslands();

    int[][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };

    int maxArea = solution.maxAreaOfIsland(grid);
    System.out.println("Maximum Area of Island: " + maxArea); // Output: 6
}
}
