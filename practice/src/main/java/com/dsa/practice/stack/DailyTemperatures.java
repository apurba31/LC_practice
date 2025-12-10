package com.dsa.practice.stack;

import java.util.Stack;

class DailyTemperatures {
    /**     * 
     * We can solve this problem using a stack to keep track of the indices of the days.
     * We iterate through the list of temperatures, and for each temperature, we check
     * if it is warmer than the temperature at the index stored at the top of the stack.
     * If it is, we pop the index from the stack and calculate the difference in days.
     * We continue this process until we find a temperature that is not warmer or the stack is empty.
     * Finally, we push the current day's index onto the stack.
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.print("Days until warmer temperature: ");
        for (int days : result) {
            System.out.print(days + " ");
        }
        System.out.println();
    }
}