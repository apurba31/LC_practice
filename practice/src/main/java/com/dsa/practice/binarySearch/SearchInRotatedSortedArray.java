package com.dsa.practice.binarySearch;

class SearchInRotatedSortedArray {
    /**
     * Brief Explanation:
     * The problem is to search for a target value in a rotated sorted array.
     * Brute Force Approach:
     * 1. Perform a linear search through the array to find the target.
     *  2. Return the index if found; otherwise, return -1.
     * Optimized Approach (Modified Binary Search):
     * 1. Initialize two pointers, left and right, to the start and end of
     *   the array.
     * 2. While left is less than or equal to right, calculate the mid index.
     * 3. If the middle element is the target, return its index.
     * 4. Determine which side (left or right) of the array is properly sorted.
     * 5. If the left side is sorted, check if the target lies within this range.
     *    If it does, adjust the right pointer; otherwise, adjust the left pointer.
     * 6. If the right side is sorted, perform a similar check and adjust pointers accordingly.
     * 7. Repeat until the target is found or the pointers cross.
     * @param nums
     * @param target
     * @return
     */

    public int search(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       
       while ( left <= right ) {
          int mid = (left + right) / 2;
          if ( nums[mid] == target ) {
            return mid;
          }
          if ( nums[left] <= nums[mid] ) {
            if( target < nums[left] || target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
          } else { 
            if ( target > nums[right] || target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
          }
       }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solver = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2}; // Example input
        int target = 0;
        int result = solver.search(nums, target);
        System.out.println("Search in Rotated Sorted Array Example: " + result); // Expected output: 4
    }
}