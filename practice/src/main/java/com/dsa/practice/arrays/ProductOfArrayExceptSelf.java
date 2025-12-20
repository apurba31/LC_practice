package com.dsa.practice.arrays;

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    /**
     * To find the product of an array except self without using division and in O(n) time complexity,
     * we can use two passes through the array. In the first pass, we calculate the
     * product of all elements to the left of each index and store it in the result array.
     * In the second pass, we calculate the product of all elements to the right of each
     * index and multiply it with the corresponding value in the result array. This way, each index in the result array will contain the product of all elements
     * except the one at that index.
     * @param nums
     * @return
     */

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        Arrays.fill(result, 1); // Initialize result array with 1s
        int pre = 1, post = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] *= pre; // Multiply with the product of all elements before i
            pre *= nums[i]; // Update pre to include current element
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * post; // Multiply with the product of all elements after i
            post *= nums[i]; // Update post to include current element
        }
        return result;
    } 

    public static void main(String[] args) {
        ProductOfArrayExceptSelf poa = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = poa.productExceptSelf(nums);
        System.out.println("Product of Array Except Self: " + java.util.Arrays.toString(result));
    }
}