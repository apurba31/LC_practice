package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

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
