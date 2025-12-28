package com.dsa.practice.dynamicProgramming;

class PalindromicSubstrings {
    /**
     * Efficient approach to count palindromic substrings in a given string using dynamic programming.
     * The function calculates the number of palindromic substrings by expanding around potential centers.
     * @param s The input string.
     * @return The count of palindromic substrings in the input string.
     * This implementation has a time complexity of O(n^2) and a space complexity of O(n^2).
     * @param s The input string.
     * @return The count of palindromic substrings in the input string.
     */
    public int countSubstrings(String s) {
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            ans += checkPalindrome(s, i, i); //odd length palindrome
            ans += checkPalindrome(s, i, i + 1); //even length palindrome

        }
        return ans;
    }

    public int checkPalindrome(String s, int left, int right) {
        int count = 0;
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        PalindromicSubstrings solver = new PalindromicSubstrings();
        String input = "aaa";
        System.out.println("Count of palindromic substrings: " + solver.countSubstrings(input)); // Output: 6
    }
}