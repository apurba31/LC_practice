package com.dsa.practice.arrays;

class CotainerWithMostWater {
    /**
     * When calculating container with most water, the two pointer technique
     * provides an efficient O(n) solution. Here the two pointers are put at the 
     * opposite ends of the array and move towards each other. We take minimum of
     * two heights pointed by the array because the water level is limited by the
     * shorter height.
     */

    public int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width; // Min is used here to find the limiting height. The water level is determined by the shorter line.
            max = Math.max(max, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            }
            return max;
        }
    
    public static void main(String[] args) {
        CotainerWithMostWater solver = new CotainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7}; // Example input
        int result = solver.maxArea(height);
        System.out.println("Container With Most Water Example: " + result); // Expected output: 49
    }
}