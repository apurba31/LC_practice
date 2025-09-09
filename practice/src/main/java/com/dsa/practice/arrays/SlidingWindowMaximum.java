package com.dsa.practice.arrays;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
    /**
     * The brute-force method is inefficient because it re-scans the entire window to find the maximum, even though the new window only differs from the previous one by a single element entering and a single element leaving. We can optimize this using a deque (double-ended queue) to maintain a list of potentially maximum elements within the current window. The key idea is to store indices in the deque, not values, and keep the deque sorted in decreasing order based on the values at those indices.
        Here's a step-by-step breakdown:
        Initialize a deque and an empty result array.
        Iterate through the input array with an index i from 0 to n-1.
        Maintain the deque: Before adding the current element's index i, we need to remove indices of elements from the back of the deque that are smaller than the current element nums[i]. This is because if nums[i] is larger, the previous smaller elements are no longer potential maximums for any future window.
        Add to deque: After the clean-up, add the current index i to the back of the deque. The deque now contains indices of elements in the current window in decreasing order of their values.
        Remove out-of-bounds elements: The element at the front of the deque is always the maximum for the current window. However, we must first check if its index is still within the current window. If the index at the front of the deque is i - k, it means this element is no longer in the window, so we remove its index from the front.
        Store the maximum: Once the window is fully formed (i.e., i >= k - 1), the element at the front of the deque is the maximum of the current window. Add nums[deque[0]] to our result array.
        Repeat until the end of the array.
        Adding an additional data structure allows us to efficiently
        keep track and compare values in the current window, leading to an overall time complexity of O(n), where n is the number of elements in the input array. Each element is added and removed from the deque at most once.
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for( int i = 0; i < n; i++) {
            //Remove the indices that are out of the current window
            while( deque.size() > 0 && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            // Remove the indices whose corresponding values are less than nums[i]
            while( deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            //Add the current index to the deque
            deque.offerLast(i);

            // Add the maximum element of current window to the result
            if( i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]; 
        }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximum: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}