package com.dsa.practice.linkedList;

class FindTheDuplicateNumber {
    /**
     * To find the duplicate number in an array where numbers are in the range 1 to n,
     * we can use Floyd's Tortoise and Hare (Cycle Detection) algorithm. The idea is to
     * treat the array as a linked list where each index points to the value at that index.
     * Since there is a duplicate, there will be a cycle in this linked list representation.
     * We can use two pointers moving at different speeds to detect the cycle and find the duplicate.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Phase 1: Finding the intersection point in the cycle
        while ( slow != fast ) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // Phase 2: Finding the entrance to the cycle
        slow = 0;
        while ( slow != fast ) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        // Example usage:
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate); // Output: 2
    }
}