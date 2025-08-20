package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){
        //Create a hashset to store elements from array
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through each element in the array
        for(int num : nums) {
            // Check if the number is already in the set
            if(seenNumbers.contains(num)) {
                return true; // Duplicate found
            }
            seenNumbers.add(num);

        }
        return false; // No duplicates found
    }

    static void frequencyCount(int[] nums){
        // This method counts the frequency of each
        // element in the array and prints the count
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for ( int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

          for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Number: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Your code here
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 1}; // Example input
        boolean result = cd.containsDuplicate(nums);
        System.out.println("Contains Duplicate Example : " + result);
        frequencyCount(nums);
      
    }
}