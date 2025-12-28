package com.dsa.practice.dynamicProgramming;

class DecodeWays{
    /**
     * * Efficient approach to count the number of ways to decode a given string using dynamic programming.
     * The function calculates the number of ways to decode the string by considering one-digit and two-digit mappings.
     * @param s The input string consisting of digits.
     * @return The number of ways to decode the input string.
     * This implementation has a time complexity of O(n) and a space complexity of O(n).
     * @param s The input string consisting of digits.
     * @return The number of ways to decode the input string.
     */

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0; // No valid decoding if string starts with '0'

        int one = 1; // Ways to decode up to the previous character
        int two = 1; // Ways to decode up to the character before the previous one

        for(int i = 1; i < s.length(); i++) { // Start from the second character because first character is already checked
            int current = 0;
            if(s.charAt(i) != '0') {
                current += one; // Single digit decode is valid
            }
            int value = Integer.parseInt(s.substring(i - 1, i + 1)); // Two digit number
            if ( value >= 10 && value <= 26){
                current += two; // Two digit decode is valid
            }
            two = one;
            one = current;
        }
        return one;
    }

    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();
        String input = "226";
        System.out.println("Number of ways to decode: " + solver.numDecodings(input)); // Output: 3
    }
}