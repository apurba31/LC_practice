
package com.dsa.practice.arrays;

import java.util.HashSet;

class LongestConsecutiveSequence {
    /**
     * Finds the length of the longest consecutive elements sequence in an array.
     * Efficient solution using a HashSet for O(n) complexity.
     * This method avoids sorting and uses set lookups to find sequences.
     * Example: Input: [100, 4, 200, 1, 3, 2]
     * Output: 4 (The longest consecutive sequence is [1, 2, 3, 4])
     * @param nums
     * @return
     */
    public int longestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) {
            return 0; // No elements in the array
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) { // Enhanced for loop is cleaner
            numSet.add(num); // Add all elements to the set
        }
        
        int longestSub = 1; 
        
        for (int num : nums) {
            // Only start counting from the beginning of a sequence
            if (!numSet.contains(num - 1)) { // Simplified condition
                int currentNum = num;
                int currentSub = 1;
                
                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSub++;
                }
                
                longestSub = Math.max(longestSub, currentSub); // Update longest subsequence length
            }
        }
        
        return longestSub; // Return the length of the longest consecutive sequence
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2}; // Example input
        int result = lcs.longestConsecutiveSequence(nums);
        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}