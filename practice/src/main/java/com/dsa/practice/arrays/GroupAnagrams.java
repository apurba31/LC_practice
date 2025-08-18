package com.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * When solving anagram related problems,
         * a common approach is to use a hash map to group words
         * that are anagrams of each other. For better performance,
         * we can use a character count as a key.
         * Also, we can use an array of size 26 to count occurrences of each character
         * in the string, because English alphabet has 26 letters.\
         *  Array is initialized to 0 for each character. When calculating
         * 'c' - 'a', it gives the index of the character in the array.
         * For example, 'a' - 'a' = 0, 'b' - 'a' = 1, 'c' - 'a' = 2, and so on.
         * This way, we can create a unique key for each anagram group.
         */
        if(strs.length == 0) {
            return new ArrayList(); // Return an empty list if input is empty
        }
        
        Map<String, List<String>> anagramMap = new HashMap<>();
        int[] count = new int[26]; // Array to count character occurrences

        for(String str : strs) {
            // Reset count for each string
           Arrays.fill(count, 0); 
           for( char c : str.toCharArray()) {
                count[c - 'a']++; // Increment count for each character
            }

            // Create a key from the count array
            StringBuilder keyBuilder = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                keyBuilder.append('#'); // Use '#' as a separator
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();

            // Add the string to the corresponding list in the map
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
           }

        return new ArrayList(anagramMap.values()); // Placeholder return
    }


    public static void main(String[] args) {
        // Example usage
        GroupAnagrams ga = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(input);
        System.out.println("Group Anagrams Example");
        int diff = 'c' - 'a'; // Example of character difference
        System.out.println("Character difference: " + diff); // Output: 2
        System.out.println("Group Anagrams:" + result);
    }

    // Add your methods here
}