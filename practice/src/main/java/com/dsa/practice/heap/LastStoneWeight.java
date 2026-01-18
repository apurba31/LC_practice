package com.dsa.practice.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
/**
 * Brute Force Approach: O(N^2)
 * 1. While there is more than one stone, find the two heaviest stones.
 * 2. Smash them together and update the list of stones.
 * 3. Repeat until one or no stones are left.
 * Optimized Approach using Max-Heap: O(N log N)
 * 1. Insert all stones into a max-heap (priority queue).
 * 2. While there is more than one stone in the heap, extract the two heaviest stones.
 * 3. If they are not equal, insert the difference back into the heap.
 * 4. If one stone is left, return its weight; otherwise, return 0.
 * Time Complexity: O(N log N) due to heap operations.
 * Space Complexity: O(N) for storing the stones in the heap.
 * 
 */
public int LastStoneWeight(int[] stones){
    // Max-heap to store the stones
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    //Add all stones to the max-heap
    for(int stone : stones){
        maxHeap.offer(stone);
    }

    //Continuously smash the two heaviest stones
    while(maxHeap.size() > 1){
        int y = maxHeap.poll(); // Heaviest stone
        int x = maxHeap.poll(); // Second heaviest stone

        if( x != y){
            maxHeap.add(y - x); // Add the difference back to the heap
        }
    }
    //Return the weight of the last stone or 0 if none are left
    return maxHeap.isEmpty() ? 0 : maxHeap.poll();
}
public static void main(String[] args) {
    LastStoneWeight obj = new LastStoneWeight();
    int[] stones = {2,7,4,1,8,1};
    System.out.println("Last stone weight: " + obj.LastStoneWeight(stones));
}
}
