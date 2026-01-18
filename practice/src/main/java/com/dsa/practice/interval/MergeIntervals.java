package com.dsa.practice.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
/**
 * Brute Force Approach
 * For each interval, check if it overlaps with the next interval.
 * If it does, merge them by updating the end of the current interval.
 * If it doesn't, add the current interval to the result list.
 * Finally, add the last interval to the result list and return it.
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(N)
 * Optimized Approach
 * To optimally solve this problem we can first sort the intervals based on their start times.
 * Then we use a linked list to store the merged intervals.
 * We iterate through the sorted intervals and compare each interval with the last interval in the merged list
 * . If they overlap, we merge them by updating the end of the last interval in the merged list.
 * If they don't overlap, we add the current interval to the merged list.
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(N)
 */
public int[][] merge(int[][] intervals){
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> ans = new LinkedList<>();

    for(int[] interval : intervals){
        if(ans.isEmpty() || ans.getLast()[1] < interval[0]){
            ans.add(interval);
        } else {
            ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);

        }        
    }
    return ans.toArray(new int[ans.size()][]);
}
public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    int[][] mergedIntervals = mergeIntervals.merge(intervals);
    for(int[] interval : mergedIntervals){
        System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }
}
}