package com.dsa.practice.dynamicProgramming;

public class LongestPalindromicSubstring {
    /**
     * The Longest Palindromic Substring problem is a classic dynamic programming problem that involves finding the longest substring within a given string that reads the same forwards and backwards (i.e., is a palindrome).
     *
     */
    public String longestPalindrome(String s){
        if(s == null || s.length() < 1) return "";

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i); //Odd length
            int len2 = expandAroundCenter(s, i, i+1); //Even length
            int len = Math.max(len1, len2);
            if(len > right - left){
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
           int L = left, R = right;
        
        while(L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            
            L--;
            R++;
            
            
        }
        
        return R-L-1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String input = "babad";
        String result = lps.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring of '" + input + "' is: " + result);
    }

}
