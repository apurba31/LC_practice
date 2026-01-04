package com.dsa.practice.dynamicProgramming;

public class BurstBalloons {
/**
 * Brief Explanation:
 * The problem is to find the maximum coins that can be collected by bursting
 * balloons in an optimal order. Each balloon has a number, and when a balloon is
 * burst, the coins collected are equal to the product of the numbers on the
 * burst balloon and its adjacent balloons. The goal is to determine the order of
 * bursting balloons that maximizes the total coins collected.
 * Brute Force Approach:
 * 1. Generate all possible orders of bursting the balloons.
 * 2. For each order, simulate the bursting process and calculate the total coins
 * collected.
 * 3. Return the maximum coins collected from all possible orders.
 * Optimized Approach (Using Dynamic Programming):
 * 1. Use a 2D DP array where dp[i][j] represents the
 * maximum coins that can be collected by bursting all balloons between indices i and j.
 * 2. Iterate over all possible lengths of subarrays of balloons
 * 3. For each subarray, consider each balloon as the last balloon to be burst.
 * 4. Calculate the coins collected by bursting the last balloon and add it to the
 * maximum coins collected from the left and right subarrays.
 * 5. Update the DP array with the maximum coins for each subarray. 
 */
public int macCoins(int[] nums){
    return 0;
}
}
