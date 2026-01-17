package com.dsa.practice.greedy;


public class JumpGameII {
/**
 * Brief Explanation:
 * The problem is to find the minimum number of jumps required to reach
 * the last index of an array, where each element in the array represents
 * your maximum jump length at that position.
 * Brute Force Approach:
 * 1. Start from the first index and explore all possible jumps recursively.
 * 2. For each jump, recursively calculate the minimum jumps needed to reach
 * the last index.
 * 3. Return the minimum jumps found from all possible paths.
 * Optimized Approach (Greedy Algorithm):
 * 1. Initialize variables to keep track of the current end of the jump,
 *  the farthest reachable index, and the number of jumps made.
 * 2. Iterate through the array, and for each index, update the farthest
 * reachable index based on the current index and its jump length.
 * 3. When you reach the end of the current jump, increment the jump count
 * and update the current end to the farthest reachable index.
 * 4. Continue this process until you reach the last index.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public int jump(int[] nums){
    int jump = 0, currMax = 0, currEnd = 0;

    for( int i = 0; i < nums.length - 1; i++){
        currMax = Math.max(currMax, i + nums[i]);
        if(i == currEnd){
            jump++;
            currEnd = currMax;
        }
    }
    return jump;
}
public static void main(String[] args) {
    JumpGameII jumpGameII = new JumpGameII();
    int[] nums = {2,3,1,1,4};
    System.out.println("Minimum jumps to reach the last index: " + jumpGameII.jump(nums));
}
}
