package com.dsa.practice.heap;

import java.util.PriorityQueue;

class KClosestPointsToOrigin{
    /**
     * Brute Force Approach: O(N log N)
     * 1. Calculate the distance of each point from the origin.
     * 2. Sort the points based on their distances.
     * 3. Return the first k points from the sorted list.
     * Optimized Approach using Max-Heap: O(N log k)
     * 1. Use a max-heap (priority queue) to keep track of the k closest points.
     * 2. For each point, calculate its distance from the origin.
     * 3. If the heap size is less than k, add the point to the heap.
     * 4. If the heap size exceeds k, remove the point with the largest distance.
     * 5. After processing all points, the heap will contain the k closest points.
     * Time Complexity: O(N log k) due to heap operations.
     * Space Complexity: O(k) for storing the k closest points in the heap.
     */
   public int[][] kClosest(int[][] points, int k){
    //Create a max-heap to store the k closest points
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
    (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
    
    // Add points to the max-heap
    for(int[] point : points){
        maxHeap.add(point);
        if(maxHeap.size() > k){
            maxHeap.poll(); // Remove the point with the largest distance
        }
    }
    // Extract the k closest points from the max-heap
    int[][] result = new int[k][2];
    for(int i = 0; i < k; i++){
        result[i] = maxHeap.poll();
    }
    return result;
   }
    public static void main(String[] args) {
     KClosestPointsToOrigin solver = new KClosestPointsToOrigin();
     int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
     int k = 2;
     int[][] closestPoints = solver.kClosest(points, k);
     System.out.println("The " + k + " closest points to the origin are:");
     for(int[] point : closestPoints){
          System.out.println("[" + point[0] + ", " + point[1] + "]");
     }
    }
}