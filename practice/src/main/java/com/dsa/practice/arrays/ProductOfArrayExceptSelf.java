package com.dsa.practice.arrays;

import java.util.Arrays;

class ProductOfArrayExceptSelf {

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