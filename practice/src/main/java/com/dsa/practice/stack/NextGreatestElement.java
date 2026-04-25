package com.dsa.practice.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatestElement{
    /**
     * Brute Force Approach:
     * The brute force approach involves using two nested loops to compare each element with every other element to find the next greatest element. The time complexity of this approach is O(n^2).
     * Optimal Approach:
     * The optimal approach uses a stack to keep track of the indices of the elements. We
     * iterate through the array from right to left, and for each element, we pop elements from the stack until we find a greater element or the stack is empty. The time complexity of this approach is O(n) because each element is pushed and popped at most once.
     * 
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>(); 
        // Process nums2 from right to left
        for(int i = nums2.length - 1; i >=0; i--){
            int num = nums2[i];

            //Pop smaller elements from the stack
            while(!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            // Top of stack is next greater (or -1 if stack empty)
            nextGreater.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreater.get(nums1[i]);
        }
        return result;
    }

    public int[] ngr(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreatestElement solution = new NextGreatestElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
        int[] arr = {4, 5, 2, 10, 8};
        int[] ngrResult = solution.ngr(arr);
        System.out.println(Arrays.toString(ngrResult)); // Output: [5, 10, 10, -1, -1]
    }
}