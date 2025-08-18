package com.dsa.practice.arrays;

import java.util.HashSet;


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

    public static void main(String[] args) {
        // Your code here
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 1}; // Example input
        boolean result = cd.containsDuplicate(nums);
        System.out.println("Contains Duplicate Example : " + result);
    }
}