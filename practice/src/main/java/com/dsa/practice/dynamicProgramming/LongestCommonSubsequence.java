package com.dsa.practice.dynamicProgramming;

public class LongestCommonSubsequence {
/**
 * Brute Force Approach:
 * The brute force approach to the Longest Common Subsequence (LCS) problem involves recursively
 * checking all possible subsequences of the two input strings to find the longest common one. This method can be highly inefficient,
 * especially for longer strings, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^(m+n)), where m and n are the lengths of the two strings.
 * Space Complexity: O(m+n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the LCS problem is to use Dynamic Programming. This method
 * involves building a 2D table where each entry at index (i, j) represents the length of the LCS of the substrings
 * up to index i of the first string and index j of the second string. The algorithm iteratively fills this table
 * by comparing characters from both strings and updating the entries based on previously computed values.
 * Time Complexity: O(m*n), where m and n are the lengths of the two strings
 * Space Complexity: O(m*n) for the DP table.
 */
public int longestCommonSubsequence(String text1, String text2){
    int m = text1.length();
    int n = text2.length();
    int dp[][] = new int[m + 1][n + 1];

    // Build the DP table
    for(int i = 1; i <= m; i++){
        for(int j = 1; j <=n; j++){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
            }
        }
    return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
