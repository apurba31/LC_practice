package com.dsa.practice.dynamicProgramming;

public class ClimbingStairs {
    /**
     * Efficient Approach: Dynamic Programming
     * The problem can be solved using dynamic programming. 
     * Let dp[i] represent the number of ways to reach the i-th step.
     * We can reach the i-th step either from (i-1)th step by taking 1 step or from (i-2)th step by taking 2 steps.
     * So, dp[i] = dp[i-1] + dp[i-2].
     * Base cases: dp[0] = 1 (one way to stay at ground), dp[1] = 1 (one way to reach first step).
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs(int n){
        if(n == 1) return 1;

        int one = 1;
        int two = 2;

        for(int i = 3; i <= n; i++){
            int steps = one + two;
            one = two;
            two = steps;
        }
        return two;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n = 5; // Example input
        int ways = cs.climbStairs(n);
        System.out.println("Number of ways to climb " + n + " stairs: " + ways);
    }
}
