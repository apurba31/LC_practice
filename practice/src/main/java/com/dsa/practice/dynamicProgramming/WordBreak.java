package com.dsa.practice.dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
/**
 * Brute Force Approach:
 * The brute force approach to the Word Break problem involves recursively checking all possible ways to segment the
 * input string using the provided dictionary. This method can be highly inefficient, especially for longer strings or larger dictionaries, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the length of the string.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Word Break problem is to use Dynamic Programming. This method
 * involves building a boolean array where each entry at index i indicates whether the substring up to index i can be segmented into valid dictionary words. The algorithm iteratively fills this array by checking all possible substrings and updating the entries based on previously computed values.
 * Time Complexity: O(n^2), where n is the length of the string.
 * Space Complexity: O(n) for the DP array.
 * 
 */

 public boolean wordBreak(String s, List<String> wordDict){
    boolean dp[] = new boolean[s.length() + 1];
    dp[0] = true;
    Set<String> wordSet = new HashSet<>(wordDict);

    for(int i = 1; i <= s.length(); i++){
        for ( int j = i - 1 ; j >= 0; j--){
            if(dp[j] && wordSet.contains(s.substring(j, i))){
                dp[i] = true;
                break;
            }
        } 
    }
    return dp[s.length()];
 }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = wb.wordBreak(s, wordDict);
        System.out.println("Can the word be segmented? " + result);
    }
}
