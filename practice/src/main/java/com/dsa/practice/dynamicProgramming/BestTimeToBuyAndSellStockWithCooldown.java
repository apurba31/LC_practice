package com.dsa.practice.dynamicProgramming;

public class BestTimeToBuyAndSellStockWithCooldown {
/**
 * Brute Force Approach:
 * The brute force approach to the Best Time to Buy and Sell Stock with Cooldown problem involves recursively checking all
 * possible buy and sell actions on each day while adhering to the cooldown constraint. This
 * method can be highly inefficient, especially for larger arrays, as it may involve a lot of redundant calculations.
 * Time Complexity: O(2^n), where n is the number of days.
 * Space Complexity: O(n) for the recursion stack.
 * Efficient Approach:
 * A more efficient approach to solving the Best Time to Buy and Sell Stock with Cooldown problem
 * is to use Dynamic Programming. This method involves maintaining two arrays to track the maximum profit
 * achievable on each day when holding a stock and when not holding a stock, while considering the
 * cooldown period. The algorithm iteratively fills these arrays by considering each day's price and
 * updating the entries based on previously computed values.
 * Time Complexity: O(n), where n is the number of days.
 * Space Complexity: O(n) for the DP arrays.
 */
public int maxProfit(int[] prices){
    if(prices == null || prices.length == 0){
        return 0;
    }

    int n = prices.length;
    int[] buy = new int[n];
    int[] sell = new int[n];
    int[] rest = new int[n];

    buy[0] = -prices[0]; // On day 0, if we buy, profit is -price[0]
    sell[0] = 0; // On day 0, we cannot sell, so profit is 0
    rest[0] = 0; // On day 0, if we rest, profit is 0

    for(int i = 1; i < n; i++){
        buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
        sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        rest[i] = Math.max(rest[i - 1], sell[i - 1]);
    }
    return Math.max(sell[n - 1], rest[n - 1]);
}
public static void main(String[] args) {
    BestTimeToBuyAndSellStockWithCooldown stockTrader = new BestTimeToBuyAndSellStockWithCooldown();
    int[] prices = {1, 2, 3, 0, 2};
    int maxProfit = stockTrader.maxProfit(prices);
    System.out.println("Max Profit: " + maxProfit); // Output: Max Profit: 3
}
}
