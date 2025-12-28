package com.dsa.practice.dynamicProgramming;

public class DistinctSubsequences {
/**
 * Brute Force Approach:
 * The brute force approach to the Distinct Subsequences problem involves recursively exploring all possible subsequences
 * of the input string and counting those that match the target string. This method can be highly inefficient,
 * especially for longer strings, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the length of the input string
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Distinct Subsequences problem is to use Dynamic Programming.
 * This method involves building a 2D table where each entry at index (i, j) represents the number of distinct subsequences
 * of the substring up to index i of the input string that match the substring up to index
 * j of the target string. The algorithm iteratively fills this table by comparing characters from both strings
 * and updating the entries based on previously computed values.
 * Time Complexity: O(m*n), where m and n are the lengths of the input string and target string respectively.
 * Space Complexity: O(m*n) for the DP table.
 */
public int minDistinct(String s, String t){
     int m = s.length();
        int n = t.length();
        
        // Create a 2D dp array
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp[i][0] = 1 for all i
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the result
        return dp[m][n];
}
public static void main(String[] args) {
    DistinctSubsequences ds = new DistinctSubsequences();
    String s = "rabbbit";
    String t = "rabbit";
    int result = ds.minDistinct(s, t);
    System.out.println("Number of distinct subsequences: " + result);
}
}
