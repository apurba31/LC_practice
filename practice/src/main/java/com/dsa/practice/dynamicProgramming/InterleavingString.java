package com.dsa.practice.dynamicProgramming;

public class InterleavingString {
/**
 * Brute Force Approach:
 * The brute force approach to the Interleaving String problem involves recursively checking all possible ways to
 * interleave the two input strings to see if they can form the target string. This method can be highly inefficient,
 * especially for longer strings, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^(m+n)), where m and n are the lengths of the two input strings.
 * Space Complexity: O(m+n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Interleaving String problem is to use Dynamic Programming.
 * This method involves building a 2D table where each entry at index (i, j) indicates whether the first i characters
 * of the first string and the first j characters of the second string can form the first (
 * i+j) characters of the target string. The algorithm iteratively fills this table by considering each character
 * from both input strings and updating the entries based on previously computed values.
 * Time Complexity: O(m*n), where m and n are the lengths of the two input strings.
 * Space Complexity: O(m*n) for the DP table.
 */
public boolean isInterleave(String s1, String s2, String s3){
    int m = s1.length();
    int n = s2.length();
    int l = s3.length();
    
    // If lengths don't add up, return false
    if (m + n != l){
        return false;
    }

    // DP table to store results of subproblems
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true; // Empty strings can form an empty string

    // Fill the first row
    for(int i = 1; i <= n; i++){
        dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
    }

    // Fill the rest of the DP table
    for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

    return dp[m][n];
}


public static void main(String[] args) {
    InterleavingString interleavingString = new InterleavingString();
    String s1 = "aab";
    String s2 = "axy";
    String s3 = "aaxaby";
    boolean result = interleavingString.isInterleave(s1, s2, s3);
    System.out.println("Is interleaving: " + result); // Output: Is interleaving: true
}
} 
