package com.dsa.practice.dynamicProgramming;

public class HouseRobberII {
/**
 * Brute Force Approach: O(2^n) time complexity
 * This approach explores all possible combinations of houses to rob, ensuring that no two adjacent houses are robbed.
 * However, it is inefficient for large inputs due to its exponential time complexity.
 * Efficient Approach: O(n) time complexity and O(1) space complexity
 * This approach breaks the problem into two scenarios:
 * 1. Robbing houses from the first house to the second-to-last house.
 * 2. Robbing houses from the second house to the last house.
 * The maximum value from these two scenarios is returned.
 * 
 */
public int rob(int[] nums){
    int rob1 = 0; // Max money that can be robbed up to the previous house
    int rob2 = 0; // Max money that can be robbed up to the house
    int max1 = nums[0];
    int max2 = 0;

    for(int i = 0; i < nums.length - 1; i++){
        max1 = Math.max(rob1 + nums[i], rob2);
        rob1 = rob2;
        rob2 = max1;
    }

    rob1 = 0;
    rob2 = 0;
    for(int i = 1; i < nums.length; i++){
        max2 = Math.max(rob1 + nums[i], rob2);
        rob1 = rob2;
        rob2 = max2;
    }
    return Math.max(max1, max2);
}
public static void main(String[] args) {
    HouseRobberII houseRobberII = new HouseRobberII();
    int[] nums = {2,3,2};
    System.out.println("Maximum amount that can be robbed: " + houseRobberII.rob(nums)); // Output: 3
}
}
