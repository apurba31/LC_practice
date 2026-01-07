package com.dsa.practice.greedy;

public class JumpGame {
/**
 * Brief Explanation:
 * The problem is to determine if you can reach the last index of an array,
 * given that each element in the array represents your maximum jump length
 * at that position.
 * Brute Force Approach:
 * 1. Start from the first index and explore all possible jumps recursively.
 * 2. If you reach the last index, return true; if you exhaust all options
 * without reaching the last index, return false.
 * Optimized Approach (Greedy Algorithm):
 * 1. Initialize a variable to keep track of the farthest reachable index.
 * 2. Iterate through the array, and for each index, update the farthest
 * reachable index based on the current index and its jump length.
 * 3. If at any point the current index exceeds the farthest reachable index,
 *   return false.
 * 4. If you can reach or exceed the last index, return true.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * * Basically we check from the end if we can reach the start
 */
public boolean canJump(int[] nums){
    int finall = 0;

    for(int i = nums.length - 2; i >= 0; i--){
        if( i + nums[i] >= finall){
            finall = i;
        }
    }
    if (finall == 0) {
        return true;
    }

    return false;
}
}
