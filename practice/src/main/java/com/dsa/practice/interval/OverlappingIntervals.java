package com.dsa.practice.interval;

import java.util.Arrays;

public class OverlappingIntervals {
/**
 * Brute Force Approach
 * For each pair of intervals, check if they overlap.
 * If they do, return true.
 * If no pairs overlap, return false.
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * Optimized Approach
 * To optimally solve this problem we can first sort the intervals based on their start times.
 * Then we iterate through the sorted intervals and compare each interval with the next one.
 * If they overlap, we return true.
 * If no pairs overlap, we return false.
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(1)
 */
public int eraseOverlapIntervals(int[][] intervals){
    if(intervals.length == 0) {
        return 0;
    }
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int prev = 0;
    int count = 0;

    for(int i = 1; i < intervals.length; i++){
        if(intervals[prev][1] > intervals[i][0]){
            if(intervals[prev][1] > intervals[i][1]){
                prev = i;
            }
            count++;
        } else{
            prev = i;
        }
    }
    return count;
}
public static void main(String[] args) {
    OverlappingIntervals overlappingIntervals = new OverlappingIntervals();
    int[][] intervals = {{1,3},{2,4},{5,7},{6,8}};
    int result = overlappingIntervals.eraseOverlapIntervals(intervals);
    System.out.println("Number of intervals to remove to eliminate overlaps: " + result);  
}
}
