package com.dsa.practice.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
/**
 * Brute Force Approach:
 * The brute force approach to the Coin Change problem involves recursively exploring all possible combinations of coins to make up the target amount. This method can be highly inefficient, especially for larger amounts or a larger set of coin denominations, as it may involve a lot of redundant calculations.
 * Time Complexity: O(n^m), where n is the amount and m is the number of coin denominations.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Coin Change problem is to use Dynamic Programming. This method
 * involves building a table (array) where each entry at index i represents the minimum number of coins needed to make the amount i. The algorithm iteratively fills this table by considering each coin denomination and updating the entries based on previously computed values.
 * Time Complexity: O(n*m), where n is the amount and m is the number of
 * coin denominations.
 * Space Complexity: O(n) for the DP array.
 */
public int coinChange(int[] coins, int amount) {
    int amt[] = new int[amount + 1];
    Arrays.fill(amt, amount + 1);
    amt[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (i >= coin) {
                amt[i] = Math.min(amt[i], 1 + amt[i - coin]);
            }
        }
    }
      if(amt[amount] < amount+1){
            return amt[amount];
        }
        return -1;
}

public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] coins = {1, 2, 5};
    int amount = 11;
    int result = cc.coinChange(coins, amount);
    System.out.println("Minimum coins needed: " + result);
}
}
