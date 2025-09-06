
package com.dsa.practice.arrays;

import java.util.HashSet;

class LongestConsecutiveSequence {
    
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