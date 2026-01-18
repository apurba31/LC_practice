package com.dsa.practice.interval;

import java.util.LinkedList;

public class InsertInterval {
/**
 * Brute Force Approach
 * For each interval, check if it overlaps with the new interval.
 * If it does, merge them by updating the start and end of the new interval.
 * If it doesn't, add the current interval to the result list.
 * Finally, add the new interval to the result list and return it.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Optimized Approach
 * To optimally solve this problem we can use a linked list to store the result intervals.
 * We iterate through the given intervals and compare each interval with the new interval.
 * If the current interval ends before the new interval starts, we add it to the result list.
 * If the current interval starts after the new interval ends, we add the new interval to the result list and update the new interval to be the current interval.
 * If the current interval overlaps with the new interval, we merge them by updating the start and
 * end of the new interval.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public int[][] insert(int[][] intervals, int[] newInterval){
    int newStart = newInterval[0];
    int newEnd = newInterval[1];
    int left = 0;
    int right = intervals.length - 1;
    LinkedList<int[]> output = new LinkedList<>();

    while(left < right && newStart > intervals[left][0]){
        output.add(intervals[left]);
        left++;
    }
    int[] interval = new int[2];

    if(output.isEmpty() || output.getLast()[1] < newStart){
        output.add(newInterval);
    }
    else{
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], newEnd);
        output.add(interval);
    }
    while( left <= right){
        interval = intervals[left];
        left++;
        int start = interval[0], end = interval[1];
        if(output.getLast()[1] < start){
            output.add(interval);
        }
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], end);
            output.add(interval);
        }
    }
    return output.toArray(new int[output.size()][]);
}
public static void main(String[] args) {
    InsertInterval insertInterval = new InsertInterval();
    int[][] intervals = {{1,3},{6,9}};
    int[] newInterval = {2,5};
    int[][] result = insertInterval.insert(intervals, newInterval);
    for(int[] interval : result){
        System.out.println("[" + interval[0] + "," + interval[1] + "]");
    }
}
}
