package com.dsa.practice.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
/**
 * Brute Force Approach:
 * The brute force approach to the Longest Increasing Subsequence (LIS) problem involves recursively
 * checking all possible subsequences of the input array to find the longest increasing one. This method can be highly inefficient,
 * especially for longer arrays, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the length of the array.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the LIS problem is to use Dynamic Programming. This method
 * involves building a 1D array where each entry at index i represents the length of the
 * longest increasing subsequence that ends with the element at index i. The algorithm iteratively fills this array
 * by comparing each element with all previous elements and updating the entries based on previously computed values.
 * Time Complexity: O(n^2), where n is the length of the array.
 * Space Complexity: O(n) for the DP array.
 */
public int lengthOfLIS(int[] nums){
    int[] lis = new int[nums.length];
    Arrays.fill(lis, 1);
    int max = 1;
    for(int i = 1; i < nums.length; i++){
        for(int j = 0; j < i; j++){
            if(nums[i] > nums[j]){
                lis[i] = Math.max(max, lis[j] + 1);
                max = Math.max(max, lis[i]);
            }
        }
    }
    return max;
}
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = lis.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}
