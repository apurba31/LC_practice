package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement

            // Check if the complament exists in the map
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i}; // Return the indices of the two numbers
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        return new int[] {};

    }

    public static void main(String[] args){
        System.out.println("Two Sum Example");
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15}; // Example input
        int target = 9; // Example target
        int[] result = twoSum.twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two numbers add up to " + target);
        }
    }
}