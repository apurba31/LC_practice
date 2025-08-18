package com.dsa.practice.arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // If lengths differ, cannot be anagrams
        }
        
        int[] count = new int[26]; // Assuming only lowercase letters a-z
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment count for character in s
            count[t.charAt(i) - 'a']--; // Decrement count for character in t
        }
        
        for (int c : count) {
            if (c != 0) {
                return false; // If any count is not zero, not an anagram
            }
        }
        
        return true; // All counts are zero, so they are anagrams
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = va.isAnagram(s, t);
        System.out.println("Is Anagram: " + result);
    }
}