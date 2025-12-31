package com.dsa.practice.dynamicProgramming;

public class CoinChangeII {
/**
 * Brute Force Approach:
 * The brute force approach to the Coin Change II problem involves recursively checking all possible combinations
 * of coins to make up the target amount. This method can be highly inefficient,
 * especially for larger amounts, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the amount.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Coin Change II problem is to use Dynamic Programming.
 * This method involves building a 1D array where each entry at index j indicates the number
 * of ways to make up the amount j using the given coins. The algorithm iteratively fills this array
 * by considering each coin and updating the entries based on previously computed values.
 * Time Complexity: O(n*m), where n is the amount and m is the number of coins.
 * Space Complexity: O(n) for the DP array.
 */
public int change(int amount, int[] coins){
    // DP array to store the number of ways to make up each amount
    int[] dp = new int[amount + 1];
    dp[0] = 1; // There is one way to make the amount 0 (using no coins)

    // Process each coin
    for( int coin : coins){
        for( int j = coin; j <= amount; j++){
            dp[j] += dp[j - coin];
        }
    }
    return dp[amount];
}
public static void main(String[] args) {
    CoinChangeII coinChangeII = new CoinChangeII();
    int amount = 5;
    int[] coins = {1, 2, 5};
    int ways = coinChangeII.change(amount, coins);
    System.out.println("Number of ways to make amount " + amount + ": " + ways); // Output: Number of ways to make amount 5: 4
}
}
