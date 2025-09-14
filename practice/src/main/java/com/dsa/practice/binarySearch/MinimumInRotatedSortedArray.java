package com.dsa.practice.binarySearch;

class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
       int left = 0;
       int right = nums.length - 1;
       int ans = nums[0];

       if( nums.length == 1) {
        return nums[0]; // If array has only one element, return that element
       }

       while( left <= right ) {
        if( nums[left] < nums[right]) {
            ans = Math.min(ans, nums[left]);
        }
        int mid = (left + right) / 2;

        ans = Math.min(ans, nums[mid]);
        if(nums[left] <= nums[mid]) {
            left = mid + 1;
        }
        else { 
            right = mid - 1;
        }
       }
         return ans;
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray solver = new MinimumInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2}; // Example input
        int result = solver.findMin(nums);
        System.out.println("Minimum in Rotated Sorted Array Example: " + result); // Expected output: 0
    }
}