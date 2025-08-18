package com.dsa.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k){
        /**
         * Common approach to find top k frequent or similar
         * problems is to use a HashMap and count the frequency.
         * But this gives a O(n log n) time complexity because it has 
         * elements have to be sorted first. Using a min-heap lends 
         * a better complexity of O(n log k) which is more efficient
         * for large datasets.
         */
        if(k == nums.length){
            return nums;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1); // Count frequency of each number            
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for(int n : count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll(); // Remove the least frequent element
            }
        }
        int[] topK = new int[k];
        for(int i = k - 1; i >= 0; i--){ // Fill from end to get most frequent first
            topK[i] = heap.poll();
        }
        return topK;
    }

    public static void main(String[] args) {
        TopKFrequentElements topK = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topK.topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements: ");
        System.out.println(Arrays.toString(result));
    }
}