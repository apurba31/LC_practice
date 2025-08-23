package com.dsa.practice.arrays;

class TrappingRainWater {
    /**
     * The two-pointer technique is used to solve the trapping rain water problem efficiently.
     * Two pointers are initialized at the start and end of the array, representing the left and right boundaries.
     * We maintain two variables, leftMax and rightMax, to keep track of the maximum heights encountered from both ends.
     * The idea is to move the pointer with the smaller height inward, as the amount of water that can be trapped
     * at that position is determined by the shorter boundary. If the current height is less than the maximum height
     * encountered so far from that side, we can trap water; otherwise, we update the maximum height.
     * This approach ensures that we only traverse the array once, resulting in an O(n) time complexity.
     */

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];

        while( left < right) {
           if(height[left] < height[right]) {
            leftMax = Math.max(leftMax, height[left]);
            if(leftMax - height[left] > 0) {
                total = total + (leftMax - height[left]);
            }
            left++;
           }
           else {
            rightMax = Math.max(rightMax , height[right]);
            if(rightMax - height[right] > 0) {
                total = total + (rightMax - height[right]);
            }
            right--;
           }
        }
        return total;

    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // Example input
        int result = solver.trap(height);
        System.out.println("Trapping Rain Water Example: " + result); // Expected output: 6
    }
}