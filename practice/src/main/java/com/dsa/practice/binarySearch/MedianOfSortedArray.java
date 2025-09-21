package com.dsa.practice.binarySearch;

class MedianOfSortedArray {

    public double solution(int[] nums1, int[] nums2){
        if( nums1.length > nums2.length) {
            return solution(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int start = 0;
        int end = x;

        while ( start <= end) {
            int partX = (start + end) / 2;
            int partY = (x + y + 1) / 2 - partX;
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if ( xLeft <= yRight && yLeft <= xRight) {
                if( (x + y) % 2 == 0) {
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                }
                else {
                    return Math.max(xLeft, yLeft);
                }
            } else if ( xLeft > yRight) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }  
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianOfSortedArray medianFinder = new MedianOfSortedArray();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = medianFinder.solution(nums1, nums2);
        System.out.println("Median of the two sorted arrays is: " + median);
        // Additional test case
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4}; 
        double median2 = medianFinder.solution(nums3, nums4);
        System.out.println("Median of the two sorted arrays is: " + median2); 
    }
}  