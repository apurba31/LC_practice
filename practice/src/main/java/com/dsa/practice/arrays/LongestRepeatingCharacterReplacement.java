package com.dsa.practice.arrays;

class LongestRepeatingCharacterReplacement {
    /**
     * The sliding window technique is used to solve the longest repeating character replacement problem efficiently.
     * A window is defined by two pointers, left and right, which represent the current substring being evaluated.
     * As the right pointer expands the window by moving to the right, we keep track of the frequency of characters
     * within the window using a frequency array. The key insight is to determine the number of characters that need
     * to be replaced to make all characters in the window the same. This is calculated as the size of the window
     * minus the count of the most frequent character in that window. If this number exceeds k (the maximum allowed
     * replacements), we shrink the window from the left by moving the left pointer to the right. Throughout this
     * process, we maintain and update the maximum length of valid windows found. This approach ensures that we
     * only traverse the array once, resulting in an O(n) time complexity.
     * The formula used to check if the current window is valid is: 
     * length - max <= k
     */

   public int characterReplacement(String s, int k) {
        int[] occurrence = new int[26]; 
        int left = 0;
        int ans = 0;
        int maxOccurrence = 0; 
        
        for (int right = 0; right < s.length(); right++) {
            // Update frequency of current character
            occurrence[s.charAt(right) - 'A']++;
            
            // Update max frequency seen so far
            maxOccurrence = Math.max(maxOccurrence, occurrence[s.charAt(right) - 'A']);
            
            // If window is invalid (need more than k replacements), shrink it
            if (right - left + 1 - maxOccurrence > k) {
                occurrence[s.charAt(left) - 'A']--; // Decrease frequency of left character
                left++; // Move left pointer
            }
            
            // Update answer with current window size
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA"; // Example input
        int k = 1; // Example input
        int result = solver.characterReplacement(s, k);
        System.out.println("Longest Repeating Character Replacement Example: " + result); // Expected output:

    }
}