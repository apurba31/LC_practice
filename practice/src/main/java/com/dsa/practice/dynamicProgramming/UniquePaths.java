package com.dsa.practice.dynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
/**
 * Brute Force Approach:
 * The brute force approach to the Unique Paths problem involves recursively exploring all possible paths
 * from the top-left corner to the bottom-right corner of the grid. This method can be highly inefficient,
 * especially for larger grids, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^(m+n)), where m and n are the dimensions of the grid
 * Space Complexity: O(m+n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Unique Paths problem is to use Dynamic Programming.
 * This method involves building a 2D table where each entry at index (i, j) represents the number of unique paths
 * to reach that cell from the top-left corner. The algorithm iteratively fills this table by
 * adding the number of paths from the cell directly above and the cell directly to the left.
 * Time Complexity: O(m*n), where m and n are the dimensions of the grid.
 * Space Complexity: O(m*n) for the DP table.
 */
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,1);
        }

        for( int i = 1; i < m ; i++){
            for ( int j = 1; j < n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int m = 3;
        int n = 7;
        int result = up.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);
    }
}
