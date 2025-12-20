package com.dsa.practice.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
/**
 * * To find the largest rectangle in a histogram, we can use a stack-based approach. The idea is to maintain a stack that keeps track of the indices of the histogram bars.
 * 1. We iterate through each bar in the histogram. For each bar, we check if it is shorter than the bar at the index stored at the top of the stack.
 * 2. If it is shorter, we pop the index from the stack and calculate the
 * area of the rectangle that can be formed with the height of the popped bar. The width of this rectangle is determined by the distance between the current index and the index of the new top of the stack after popping (or the beginning of the histogram if the stack is empty).
 * 3. We continue this process until we find a bar that is not shorter than the
 * bar at the top of the stack, at which point we push the current index onto the stack.
 * 4. After processing all bars, we may still have some indices left in the stack
 * . We pop each index and calculate the area of the rectangle that can be formed with the height of the popped bar, using the same width calculation as before.
 * 5. The maximum area calculated during these steps will be the largest rectangle in the histogram
 * 6. This approach ensures that we efficiently calculate the area for each bar only once, leading to an overall time complexity of O(n), where n is the number of bars in the histogram.
 * 7. The space complexity is O(n) in the worst case, where all bars
 * are in increasing order and we push all indices onto the stack.
 * 8. Space complexity is O(1) if we ignore the input storage.
 */
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;

    for ( int i = 0; i <=n; i++) {
        int currentHeight = ( i == n) ? 0 : heights[i];
        while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);            
    }
        stack.push(i);
    }
    return maxArea;
}
public static void main(String[] args) {
    LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
    int[] heights = {2, 1, 5, 6, 2, 3};
    int result = solution.largestRectangleArea(heights);
    System.out.println("Largest Rectangle Area: " + result); // Expected output: 10
}
}
