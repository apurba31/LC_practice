package com.dsa.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Traverse the border cells of the grid.
 * 2. When a 'O' is found on the border, initiate a Depth-First Search (DFS)
 *    to mark all connected 'O's as safe (not to be flipped).
 * 3. After marking, traverse the entire grid and flip all unmarked 'O's to 'X's.
 * Optimized Approach using BFS from Rotten Oranges: O(M * N) time and O(M * N) space
 * 1. Start BFS from all rotten oranges (value 2) and spread the rot to adjacent fresh oranges (value 1)
 *  2. Keep track of the time taken to rot all reachable fresh oranges.
 * 3. If there are still fresh oranges left after the BFS, return -1.   
 * Time Complexity: O(M * N) where M is the number of rows and N is the number of columns in the grid.
 * Space Complexity: O(M * N) for the queue in the worst case.
 * */
public int orangesRotting(int[][] grid) {
    if ( grid == null || grid.length == 0) {
        return -1;
    }

    int m = grid.length, n = grid[0].length;
    int freshCount = 0;
    Queue<int[]> rottenQueue = new LinkedList<>();

    //Count fresh oranges and add rotten oranges to the queue
    for ( int i = 0; i < m; i++) {
        for ( int j = 0; j < n; j++) {
            if ( grid[i][j] == 1 ) {
                freshCount++;
            } else if ( grid[i][j] == 2) {
                rottenQueue.offer(new int[]{i, j});
            }
            }
        }
        if ( freshCount == 0) {
            return 0; //No fresh oranges
        }

        int minutes = 0;
        int [][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        //BFS to rot adjacent fresh oranges
        while(!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            for( int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();
                for ( int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if ( x >= 0 && y >= 0 
                        && x < m && y < n
                        && grid[x][y] == 1) {
                            grid[x][y] = 2; //Rot the fresh orange
                            freshCount--;
                            rottenQueue.offer(new int[]{x, y});
                        }
                }
            }
            minutes++; //Increment minutes after each level
        }
        return freshCount == 0 ? minutes - 1 : -1; //If fresh oranges remain, return -1
    }

public static void main(String[] args) {
    RottenOranges solution = new RottenOranges();

    int[][] grid = {
        {2,1,1},
        {1,1,0},
        {0,1,1}
    };

    int result = solution.orangesRotting(grid);
    System.out.println("Minutes to rot all oranges: " + result); //Expected output: 4
}
}
