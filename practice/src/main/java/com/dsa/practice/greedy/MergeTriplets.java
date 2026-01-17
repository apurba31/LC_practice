package com.dsa.practice.greedy;

public class MergeTriplets {
/**
 * Brute Force Approach:
 * 1. Iterate through all possible pairs of triplets.
 * 2. For each pair, check if they can be merged to form a triplet
 *    that is less than or equal to the target triplet in all dimensions.
 * 3. Keep track of the maximum values in each dimension from the merged triplets.
 * 4. After checking all pairs, verify if the maximum values match the target triplet
 *   in all dimensions.
 * Optimized Approach (Greedy Algorithm):
 * 1. Initialize three boolean flags to track if we can achieve the target
 *    values in each dimension.
 * 2. Iterate through each triplet in the list.
 * 3. For each triplet, check if it can contribute to reaching the target
 *  values without exceeding them.
 * 4. Update the flags accordingly.
 * 5. After processing all triplets, check if all flags are true,
 *  indicating that we can form the target triplet.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public boolean mergeTriplets(int[][] triplets, int[] target){
    // Initialize maximum values for each dimension
    int[] maxValues = new int[3];
    
    // Iterate through each triplet
    for(int[] triplet : triplets){
        //Check if the triplet can contribute to the target
        if( triplet[0] <= target[0] 
            && triplet[1] <= target[1]
            && triplet[2] <= target[2]){
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
    }
    // Check if the maximum values match the target triplet
    return maxValues[0] == target[0]
        && maxValues[1] == target[1]
        && maxValues[2] == target[2];
}
public static void main(String[] args) {
    MergeTriplets mergeTriplets = new MergeTriplets();
    int[][] triplets = {{2,5,3}, {1,8,4}, {1,7,5}};
    int[] target = {2,7,5};
    System.out.println("Can merge triplets to form target: " + mergeTriplets.mergeTriplets(triplets, target));
}
}
