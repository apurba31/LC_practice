package com.dsa.practice.heap;

import java.util.PriorityQueue;

class KthLargestElementInAnArray{
    /**
     * Brute Force Approach: O(N log N)
     * 1. Sort the array in descending order.
     * 2. Return the element at index k-1.
     * Optimized Approach using Min-Heap: O(N log k)
     * 1. Use a min-heap (priority queue) to keep track of the k largest elements.
     * 2. For each element in the array, add it to the heap.
     * 3. If the heap size exceeds k, remove the smallest element.
     * 4. After processing all elements, the root of the heap will be the kth largest element.
     * Time Complexity: O(N log k) due to heap operations.
     * Space Complexity: O(k) for storing the k largest elements in the heap.
     */
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll(); //Remove the smallest element
            }
        }
        return minHeap.peek(); //The root of the heap is the kth largest element
    }
    public static void main(String[] args) {
        KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int kthLargest = solver.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest); // Output: 5
    }
}