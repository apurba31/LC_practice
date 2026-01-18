package com.dsa.practice.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
/**
 * Brute Force Approach: Partition the string in all possible ways and check
 * each partition to see if it meets the criteria. This approach is
 * computationally expensive and inefficient.
 * Optimized Approach (Greedy Algorithm):
 * 1. Create an array to store the last occurrence index of each character in the string.
 * 2. Iterate through the string to fill this array.
 * 3. Initialize variables to track the start and end of the current partition.
 * 4. Iterate through the string again, updating the end of the current partition
 *   based on the last occurrence of each character.
 * 5. When the current index matches the end of the partition, record the size
 *  of the partition and update the start for the next partition.
 * 6. Continue until the end of the string is reached.
 * Time Complexity: O(n)
 * Space Complexity: O(1) - since the size of the last occurrence array is fixed (26 for lowercase letters).
 * 
 */
public List<Integer> partitionLabels(String s){
    int[] lastOccurrence = new int[26];
    // Fill the last occurrence array
    //Step 1 - Store the last occurrence of each character
    for(int i = 0; i < s.length(); i++){
        lastOccurrence[s.charAt(i) - 'a'] = i;
    }

    //Step 2 - Iterate through the array to create partitions
    List<Integer> partitions = new ArrayList<>();
    int partitionStart = 0, partitionEnd = 0;

    for(int i = 0; i < s.length(); i++){
        partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);

        // When we reach the end of the partition
        if(i == partitionEnd){
            partitions.add(partitionEnd - partitionStart + 1);
            partitionStart = i + 1; // Update the start for the next partition
        }
    }
    return partitions;
}
    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = pl.partitionLabels(s);
        System.out.println("Partition sizes: " + result);
    }
}