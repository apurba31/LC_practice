package com.dsa.practice.dynamicProgramming;

public class TargetSum {
/**
 * Brute Force Approach:
 * The brute force approach to the Target Sum problem involves recursively exploring all possible combinations of adding and subtracting each number in the input array to reach the target sum. This method can be highly inefficient, especially for larger arrays, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the number of elements in the
 * array.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Target Sum problem is to use Dynamic Programming. This method
 * involves transforming the problem into a subset sum problem and building a DP table to count the number of ways to achieve the desired sum. The algorithm iteratively fills this table by considering each number and updating the entries based on previously computed values.
 * Time Complexity: O(n*sum), where n is the number of elements in the array
 * and sum is the total sum of the elements.
 * Space Complexity: O(n*sum) for the DP table.
 */
public int findTargetSumWays(int[] nums, int target){
    int sum = 0;
    for(int num : nums){
        sum += num;
    }

    //Check if it is possible to partition the array
    if ((target + sum) % 2 != 0 || sum < Math.abs(target)) return 0;

    int s1 = (target + sum) / 2;

    //Early return if s1 is negative
    if ( s1 < 0 ) return 0;

    int[] dp = new int[s1 + 1];
    dp[0] = 1; // There's one way to get sum 0 -

    for(int num : nums){
        for( int j = s1 ; j >= num; j--){
            dp[j] += dp[j - num];
        }
    }
    return dp[s1];
}

public static void main(String[] args) {
    TargetSum targetSum = new TargetSum();
    int[] nums = {1, 1, 1, 1, 1};
    int target = 3;
    int result = targetSum.findTargetSumWays(nums, target);
    System.out.println("Number of ways to reach target sum: " + result); // Output: Number of ways to reach target sum: 5
}
}
