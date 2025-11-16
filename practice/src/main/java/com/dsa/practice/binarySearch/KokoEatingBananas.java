package com.dsa.practice.binarySearch;

public class KokoEatingBananas {
    /**
     * The brute force approach would involve checking each possible eating speed from 1 to the maximum pile size
     * and calculating the total hours needed for each speed until we find the minimum speed that allows Koko to finish
     * eating all the bananas within h hours. This would be inefficient for large inputs.
     * Efficient Approach:
     * We can use binary search to efficiently find the minimum eating speed. The idea is to
     * set the search range between 1 (minimum speed) and the maximum pile size (maximum speed).
     * For each mid-point speed in this range, we calculate the total hours needed to eat
     * all the bananas at that speed. If Koko can finish within h hours, we try a slower speed (left half),
     * otherwise, we try a faster speed (right half). This continues until we find the
     * minimum speed that allows Koko to finish on time.
     */

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // replace canFinish to use integer arithmetic (avoid Math.ceil)
    private static boolean canFinish(int[] piles, int speed, int h) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            // integer ceil: (pile + speed - 1) / speed
            hoursNeeded += (pile + speed - 1) / speed;
        }
        return hoursNeeded <= h;
    }

    // enhanced main with diagnostics and optional CLI parsing
    public static void main(String[] args) {
        System.out.println("KokoEatingBananas main started");
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Expected output: 4
    }
}