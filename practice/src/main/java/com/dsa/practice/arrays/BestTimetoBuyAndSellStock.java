package com.dsa.practice.arrays;

class BestTimetoBuyAndSellStock {
    /**
     * The algorithm iterates through the array of stock prices, keeping track of the minimum price encountered so far.
     * For each price, it calculates the potential profit by subtracting the minimum price from the current price.
     * If this potential profit is greater than the maximum profit recorded so far, it updates the maximum profit.
     * This approach ensures that we only traverse the array once, resulting in an O(n) time complexity.
     */

    public int maxProfit(int[] prices){
        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            if( prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimetoBuyAndSellStock solver = new BestTimetoBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        int result = solver.maxProfit(prices);
        System.out.println("Best Time to Buy and Sell Stock Example: " + result); // Expected output: 5
    }
}