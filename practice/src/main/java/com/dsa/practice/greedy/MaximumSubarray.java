package com.dsa.practice.greedy;

public class MaximumSubarray {
/**
 * Brief Explanation:
 * The problem is to find the contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum.
 * Brute Force Approach:
 * 1. Generate all possible contiguous subarrays.
 * 2. Calculate the sum for each subarray.
 * 3. Keep track of the maximum sum encountered.
 * Optimized Approach (Using Kadane's Algorithm):
 * 1. Initialize two variables: maxSoFar to keep track of the maximum sum found
 *   so far, and maxEndingHere to keep track of the maximum sum of the subarray
 * ending at the current position.
 * 2. Iterate through the array, updating maxEndingHere by adding the current element.
 * 3. If maxEndingHere becomes negative, reset it to zero (since starting a
 * new subarray would be more beneficial).
 * 4. Update maxSoFar whenever maxEndingHere exceeds it.
 * 5. Return maxSoFar as the result.
 * Time Complexity: O(n)
 * Space Complexity: O(1) 
 */
public int maxSubarray(int[] nums){
    int currentSum = 0;
    int maxNum = Integer.MIN_VALUE;

    for(int i = 0; i < nums.length; i++){
        if(currentSum < 0){
            currentSum = 0;
        }
        currentSum += nums[i];
        maxNum = Math.max(maxNum, currentSum);
    }
    return maxNum;
}

public static void main(String[] args) {
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("Maximum Subarray Sum: " + maximumSubarray.maxSubarray(nums));
}
}
