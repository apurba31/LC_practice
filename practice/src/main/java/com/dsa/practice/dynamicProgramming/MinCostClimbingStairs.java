package com.dsa.practice.dynamicProgramming;

public class MinCostClimbingStairs {
/**
 * Efficient approach to solve the Min Cost Climbing Stairs problem using dynamic programming.
 * The function calculates the minimum cost to reach the top of the stairs given an array of costs
 * where each element represents the cost of stepping on that stair.
 * @param cost An array of integers representing the cost of each stair.
 * @return The minimum cost to reach the top of the stairs.
 * 
 */

public int MinCostClimbingStairs(int[] cost) {
    int n = cost.length;
    if (cost.length == 1) return cost[0];
    if (cost.length == 2) return Math.min(cost[0], cost[1]);

    int first = cost[0];
    int second = cost[1];
    for (int i = 2; i < n; i++) {
        int current = cost[i] + Math.min(first, second);
        first = second;
        second = current;
    }

    return Math.min(first, second);
}

public static void main(String[] args) {
    MinCostClimbingStairs solver = new MinCostClimbingStairs();
    int[] cost = {10, 15, 20};
    System.out.println("Minimum cost to climb stairs: " + solver.MinCostClimbingStairs(cost)); // Output: 15
}
}
