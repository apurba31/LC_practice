package com.dsa.practice.binarySearch;

class SearchInRotatedSortedArray {

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