package com.dsa.practice.dynamicProgramming;

public class HouseRobber {
    /**
     * Brute Force Approach:
     * The brute force approach involves exploring all possible combinations of houses to rob while ensuring that no
     * two adjacent houses are robbed. This can be done using recursion.
     * The time complexity of this approach is O(2^n), where n is the number of houses, as each house has two choices: to rob or not to rob.
     * The space complexity is O(n) due to the recursion stack.
     * To solve this problem, we can use dynamic programming. The idea is to maintain an array `dp` where `dp[i]` represents the maximum amount of money that can be robbed from the first `i` houses.
     * The recurrence relation can be defined as:
     * dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])
     * Here, `dp[i-1]` represents the case where we do not rob the current house, and `dp[i-2] + nums[i-1]` represents the case where we rob the current house and add its value to the maximum amount robbed from the houses before the previous one.
     * The base cases are:
     * dp[0] = 0 (no houses to rob)
     * dp[1] = nums[0] (only one house to rob)
     * The final answer will be stored in `dp[n]`, where `n` is the number of houses.
     */

    public int rob(int[] nums){
        int rob1 = 0; // Max money that can be robbed up to the previous house
        int rob2 = 0; // Max money that can be robbed up to the house
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {2,7,9,3,1};
        System.out.println("Maximum amount that can be robbed: " + houseRobber.rob(nums)); // Output: 12
    }

}
