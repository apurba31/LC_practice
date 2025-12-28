package com.dsa.practice.dynamicProgramming;

public class MaximumProductSubarray {
    /**
     * Brute Force Approach:
     * The brute force approach to the Maximum Product Subarray problem involves checking all possible subarrays
     * and calculating their products to find the maximum. This method can be highly inefficient, especially for larger arrays,
     * as it involves a lot of redundant calculations.
     * Time Complexity: O(n^3), where n is the number of elements in the array.
     * Space Complexity: O(1) as no extra space is used.
     * Efficient Approach:
     * A more efficient approach to solving the Maximum Product Subarray problem is to use Dynamic Programming
     * techniques. This method involves keeping track of the maximum and minimum products up to the current position,
     * as a negative number can turn a minimum product into a maximum when multiplied. The algorithm
     * iteratively updates these values while traversing the array.
     * Time Complexity: O(n), where n is the number of elements in the array.
     * Space Complexity: O(1) as only a constant amount of extra space is used.
     */
    public int maxProduct(int[] nums){
        if(nums == null || nums.length ==0){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int result = max;

        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            int temp = Math.max(cur, Math.max(max * cur, min * cur));
            min = Math.min(cur, Math.min(min * cur, max * cur));
            max = temp;

            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = {2,3,-2,4};
        int result = mps.maxProduct(nums);
        System.out.println("Maximum product of subarray: " + result);
    }
}
