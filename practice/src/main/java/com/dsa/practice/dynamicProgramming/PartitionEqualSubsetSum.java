package com.dsa.practice.dynamicProgramming;

public class PartitionEqualSubsetSum {
/**
 * Brute Force Approach:
 * The brute force approach to the Partition Equal Subset Sum problem involves recursively checking all possible
 * subsets of the input array to find a subset that sums up to half of the total sum. This method can be highly inefficient,
 * especially for larger arrays, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the number of elements in the array.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Partition Equal Subset Sum problem is to use Dynamic Programming
 * . This method involves building a 2D table where each entry at index (i, j) indicates whether a subset
 * with sum j can be formed using the first i elements of the array. The algorithm iter
 * atively fills this table by considering each element and updating the entries based on previously computed values.
 * Time Complexity: O(n*sum), where n is the number of elements in the array
 * and sum is the total sum of the elements.
 * Space Complexity: O(n*sum) for the DP table.
 */
public boolean canPartition(int[] nums){
    int totalSum = 0;
    for(int num : nums){
        totalSum += num;
    }
    // If total sum is odd, we cannot partition it into two equal subsets
    if(totalSum % 2 != 0){
        return false;
    }   

    int target = totalSum / 2;
    int n = nums.length;
    boolean[] dp = new boolean[target + 1];
     dp[0] = true; // A sum of 0 can always be formed with an empty subset

    // Process each number in the array
    for( int num : nums){
        for ( int j = target; j >= num; j--){
            if(dp[j - num]){
                dp[j] = true;
        }
    }
}
    return dp[target];
}
public static void main(String[] args) {
    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
    int[] nums = {2, 4, 3, 3};
    boolean result = partitionEqualSubsetSum.canPartition(nums);
    System.out.println("Can partition: " + result); // Output: Can partition: true
}
}

