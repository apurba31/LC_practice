package com.dsa.practice.heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
/**
 * Brute Force Approach: O(N log N) for each addition
 * 1. Maintain a list of all elements added so far.
 * 2. Each time a new element is added, insert it into the list.
 * 3. Sort the list.
 * 4. Calculate the median from the sorted list.
 * Optimized Approach using Two Heaps: O(log N) for each addition
 * 1. Use two heaps: a max-heap to store the lower half of the
 * numbers and a min-heap to store the upper half.
 * 2. When a new number is added, decide which heap to add it to
 *   based on its value.
 * 3. Balance the heaps to ensure that the size difference is at most 1.
 * 4. Calculate the median based on the sizes of the heaps:
 *   - If both heaps are of equal size, the median is the average of
 *     the roots of both heaps.
 *  - If one heap has more elements, the median is the root of that heap.
 * Time Complexity: O(log N) for each addition due to heap operations.
 * Space Complexity: O(N) for storing all elements in the heaps.
 */
private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap for the lower half
private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap for the upper half

// Adds a number into the data structure.
public void addNum (int num) {
    maxHeap.offer(num); // Add to max-heap

    // Ensure every number in max-heap is <= every number in min-heap
    minHeap.offer(maxHeap.poll());

    // Maintain size property
    if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
    }
}

// Returns the median of current data stream
public double findMedian() {
    return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
}

public static void main(String[] args) {
    FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    System.out.println(medianFinder.findMedian()); // returns 1.5
    medianFinder.addNum(3);
    System.out.println(medianFinder.findMedian()); // returns 2.0
}
}
