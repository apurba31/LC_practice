package com.dsa.practice.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
/**
 * Brute Force Approach: O(N log N) for each addition
 * 1. Maintain a list of all elements added so far.
 * 2. Each time a new element is added, insert it into the list.
 * 3. Sort the list in descending order.
 * 4. Return the k-th largest element from the sorted list.
 * Optimized Approach using Min-Heap: O(log k) for each addition
 * 1. Use a min-heap (priority queue) to keep track of the k largest elements.
 * 2. When a new element is added, compare it with the smallest element in the
 * heap (the root of the min-heap).
 * 3. If the new element is larger than the smallest element, remove the smallest
 * element and add the new element to the heap.
 * 4. If the heap size exceeds k, remove the smallest element to maintain the size
 * of k.
 * 5. The root of the min-heap will always be the k-th largest element
 * in the stream.
 * Time Complexity: O(log k) for each addition due to heap operations.
 * Space Complexity: O(k) for storing the k largest elements in the heap.
 */
 private PriorityQueue<Integer> minHeap;
 private int k;

public KthLargestElementInAStream(int k, int[] nums){
    this.k = k;
    this.minHeap = new PriorityQueue<>(k); // Min-heap to store the k largest elements

    // Add initial elements to the heap
    for(int num : nums){
        add(num);
    }
}
public int add(int val){
    if(minHeap.size() < k){
        minHeap.offer(val); // Add new element if heap size is less than k
    } else if(val > minHeap.peek()){
        minHeap.poll(); // Remove the smallest element
        minHeap.offer(val); // Add the new element
    }
    return minHeap.peek(); // The k-th largest element
}

public static void main(String[] args) {
    KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
    System.out.println(kthLargest.add(3));  // returns 4
    System.out.println(kthLargest.add(5));  // returns 5
    System.out.println(kthLargest.add(10)); // returns 5
    System.out.println(kthLargest.add(9));  // returns 8
    System.out.println(kthLargest.add(4));  // returns 8
}
}
