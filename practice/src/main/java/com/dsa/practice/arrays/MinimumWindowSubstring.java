package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * The minimum window substring problem is a common algorithmic problem that can be solved using the sliding window technique. The goal is to find the smallest substring in a given string `s` that contains all the characters of another string `t`.
     * The brute force approach involves checking all possible substrings of `s` and verifying if they contain all characters of `t`, which has a time complexity of O(n^3) in the worst case. The optimal approach uses two pointers to create a sliding window and a hash map to count the characters in `t`. The time complexity of this approach is O(n) because each character is processed at most twice (once when expanding the window and once when contracting it).
     * Optimal Approach:
     * 1. Create a hash map to count the frequency of characters in `t`.
     * 2. Use two pointers to represent the sliding window and a variable to count how many characters from `t` are currently in the window.
     * 3. Expand the right pointer to include characters until the window contains all characters of `t`.
     * 4. Once the window is valid, try to contract it from the left to find the minimum length while still containing all characters of `t`.
     * 5. Update the minimum window size and starting index whenever
     * a valid window is found.
     */

    public String minWindow(String s, String t) {
      if(s.length() == 0 || t.length() == 0) {
          return "";
      }
      Map<Character, Integer> mapT = new HashMap<>();
      for( int i = 0; i < t.length(); i++) {
          mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
      }
      int required = mapT.size();
      int l = 0, r = 0;
      int create = 0;
      int[] ans = {-1, 0, 0}; // length, left, right
      Map<Character, Integer> subStringMap = new HashMap<>();

      while( r < s.length()) {
         char c = s.charAt(r);
         int count = subStringMap.getOrDefault(c, 0);
         subStringMap.put(c, count + 1);
         if( mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
             create++;
         }
         while( l <= r && required == create) {
             c = s.charAt(l);
             if( ans[0] == -1 || r - l + 1 < ans[0]) {
                 ans[0] = r - l + 1;
                 ans[1] = l;
                 ans[2] = r;
             }
             subStringMap.put(c, subStringMap.get(c) - 1);
             if( mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
                 create--;
             }
             l++;
         }
      }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        // Your code here
        System.out.println("Minimum Window Substring Example : ");
        String s = "ADOBECODEBANC"; // Example input
        String t = "ABC"; // Example input
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        String result = solver.minWindow(s, t);
        System.out.println("Minimum Window Substring Example : " + result); // Expected output:
    }

}
