package com.dsa.practice.stack;

import java.util.Arrays;

public class CarFleet {
/**
 * * To solve the Car Fleet problem, we can follow these steps:
 * 1. Calculate the time each car will take to reach the target using the formula:
 *   time = (target - position) / speed.
 * 2. Sort the cars based on their starting positions in descending order.
 * 3. Iterate through the sorted list of cars and use a stack to keep track of the fleets.
 *    - For each car, if its time to reach the target is greater than the time
 *     of the car in front of it (top of the stack), it forms a new fleet, so we push its time onto the stack.
 *   - If its time is less than or equal to the time of the car in front, it joins that fleet, and we do not push a new time onto the stack.
 * 4. The size of the stack at the end will give us the number of car fleets that will arrive at the target.
 * 5. Return the size of the stack as the result.
 * 6. This approach ensures that we efficiently group cars into fleets based on their arrival times at the target.
 * 7. The time complexity of this approach is O(n log n) due to the sorting step, and the space complexity is O(n) for the stack.
 * 8. Space complexity is O(1) if we ignore the input storage. 
 */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;

        for (int i = 0; i < n; i++) {
            if (cars[i][1] > lastTime) {
                fleets++;
                lastTime = cars[i][1];
            }
        }

        return fleets;
    }
    public static void main(String[] args) {
        CarFleet solution = new CarFleet();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int result = solution.carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result); // Expected output: 3
    }
}
