package com.dsa.practice.graph;

import java.util.Queue;

public class WallsAndGates {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Traverse each cell in the grid.
 * 2. When a gate (0) is found, initiate a Depth-First Search (DFS)
 *  to update the distances to all reachable empty rooms (INF).
 * 3. Update the distance of each empty room if the new distance is smaller.
 * Optimized Approach using Multi-Source BFS: O(M * N) time and O(M * N) space
 * 1. Use a queue to perform a breadth-first search (BFS) starting from
 * all gates (0s) simultaneously.
 * 2. Enqueue all gates initially and mark their distance as 0.
 * 3. For each cell dequeued, explore its neighbors (up, down, left
 * , right). If a neighbor is an empty room (INF), update its distance
 * to the current distance + 1 and enqueue it.
 * Time Complexity: O(M * N) where M is the number of rows and N is the number of columns in the grid.
 * Space Complexity: O(M * N) for the queue in the worst case.
 * 
 */
private static final int INF = 2147483647; // Representation of infinity
private static final int[][] DIRS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

public void wallsAndGates(int[][] rooms) {
    if(rooms == null || rooms.length == 0) {
        return;
    }

    int m = rooms.length , n = rooms[0].length;

    Queue<int[]> queue = new java.util.LinkedList<>();

    //Add gates to the queue
    for ( int i = 0; i < m; i++) {
        for ( int j = 0; j < n; j++) {
            if( rooms[i][j] == 0) {
                queue.offer(new int[]{i, j});
            }
        }
    }

    //BFS from all gates
    while(!queue.isEmpty()) {
        int[] point = queue.poll();
        int row = point[0];
        int col = point[1];

        for ( int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            //Check boundaries and if the room is an empty room
            if ( newRow >= 0 && newCol >= 0 
                && newRow < m && newCol < n
                && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; //Update distance
                    queue.offer(new int[]{newRow, newCol}); //Enqueue the updated room
                }
        }
    }
}
public static void main(String[] args) {
    WallsAndGates solution = new WallsAndGates();

    int[][] rooms = {
        {INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}
    };

    solution.wallsAndGates(rooms);

    // Print the updated rooms grid
    for (int i = 0; i < rooms.length; i++) {
        for (int j = 0; j < rooms[0].length; j++) {
            System.out.print(rooms[i][j] + "\t");
        }
        System.out.println();
    }
}
}
