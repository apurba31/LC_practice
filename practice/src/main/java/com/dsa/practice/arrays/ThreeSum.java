package com.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    /**
     * For this problem if we use a hashmap and check each value the 
     * time complexity will be O(n^2) which is not optimal.
     * The optimal solution is to sort the array first and 
     * then use a two-pointer technique to find the triplets.
     * This will give us a time complexity of O(n^2) as well, but
     * with better constant factors due to the sorted nature of the array.
     * We also need to ensure that we skip duplicates to avoid repeating triplets in the result.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) or O(k) where k is the number of triplets in the result.
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if ( i == 0 || nums[i] != nums[i - 1]) {
                twoSum2(nums, i, result);
            }
        }
        return result;
    }

    void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;

        while( left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if ( sum < 0){
                left++;
            } else if ( sum > 0){
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right]));
                while ( left < right && nums[left] == nums[left - 1]) {
                    left++; // Skip duplicates
                }
            }
            }
        }
        

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ts.threeSum(nums);
        System.out.println("Three Sum Result: " + result);
    }
}
