package com.dsa.practice.interval;

import java.util.Arrays;

public class MeetingRooms {
/**
 * Brute Force Approach
 * For each pair of intervals, check if they overlap.
 * If they do, return false.
 * If no pairs overlap, return true.
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * Optimized Approach
 * To optimally solve this problem we can first sort the intervals based on their start times.
 * Then we iterate through the sorted intervals and compare each interval with the next one.
 * If they overlap, we return false.
 * If no pairs overlap, we return true.
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(1)
 */
public boolean canAttendMeetings(int[][] intervals){
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    for(int i = 0; i < intervals.length - 1; i++){
        if(intervals[i][1] > intervals[i+1][0]){
            return false;
        }
    }
    return true;
}
public static void main(String[] args) {
    MeetingRooms meetingRooms = new MeetingRooms();
    int[][] intervals = {{0,30},{5,10},{15,20}};
    boolean result = meetingRooms.canAttendMeetings(intervals);
    System.out.println("Can attend all meetings: " + result);  
}
}