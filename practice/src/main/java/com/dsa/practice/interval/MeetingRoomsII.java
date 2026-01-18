package com.dsa.practice.interval;

import java.util.Arrays;

public class MeetingRoomsII {
/**
 * Brute Force Approach: O(N^2)
 * 1. For each meeting, check how many meetings overlap with it.
 * 2. Keep track of the maximum number of overlapping meetings.
 * 3. The maximum number of overlapping meetings at any time is the number of rooms required.
 * Optimized Approach: O(N log N)
 * 1. Separate the start and end times of all meetings into two arrays.
 * 2. Sort both arrays.
 * 3. Use two pointers to traverse the start and end arrays.
 * 4. If the start time is less than the end time, it means a new room is needed; increment the room count and move the start pointer.
 * 5. If the start time is greater than or equal to the end time, it
 * means a room is freed up; decrement the room count and move the end pointer.
 * 6. Keep track of the maximum number of rooms needed during the traversal.
 * 7. The maximum number of rooms needed at any time is the result.
 * 8. This approach efficiently counts overlapping meetings using sorting and two-pointer technique.
 * 9. It reduces the time complexity to O(N log N) due to sorting, while the space complexity remains O(N) for storing start and end times.
 * Time Complexity: O(N log N) due to sorting the start and end times.
 * Space Complexity: O(N) for storing the start and end times.
 */
public int minMeetingRooms(int[][] intervals){
    if(intervals.length == 0){ 
        return 0;
    }

    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    for(int i = 0; i < intervals.length; i++){
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);
    
    int startPointer = 0, endPointer = 0;
    int result = 0;
    
    while(startPointer < start.length){
        if(start[startPointer] >= end[endPointer]){
          result--;
          endPointer++;
        }
        result++;
        startPointer++;
    }
    return result;
}
public static void main(String[] args) {
    MeetingRoomsII obj = new MeetingRoomsII();
    int[][] intervals = {{0,30},{5,10},{15,20}};
    System.out.println("Minimum number of meeting rooms required: " + obj.minMeetingRooms(intervals));
}
}
