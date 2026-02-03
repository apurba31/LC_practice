package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
/**
 * Brute Force Approach: O(M * N) time and O(M * N) space
 * 1. Perform two separate DFS/BFS traversals starting from the Pacific and Atlantic edges
 *   of the grid.
 * 2. Mark cells that can reach the Pacific and Atlantic oceans.
 * 3. Finally, find the intersection of cells that can reach both oceans.
 * Optimized Approach using DFS from Ocean Borders: O(M * N) time and O(M * N) space
 * 1. Start DFS from all cells adjacent to the Pacific Ocean (top and left edges
 *  of the grid) and mark reachable cells.
 * 2. Start DFS from all cells adjacent to the Atlantic Ocean (bottom and right edges
 * of the grid) and mark reachable cells.
 * 3. The result is the intersection of cells reachable from both oceans.
 * Time Complexity: O(M * N) where M is the number of rows and N is
 */
public List<List<Integer>> pacificAtlantic(int[][] heights) {
    if( heights == null || heights.length == 0) {
        return new ArrayList<>();
    }

    int row = heights.length;
    int col = heights[0].length;

    boolean[][] pacificReachable = new boolean[row][col];
    boolean[][] atlanticReachable = new boolean[row][col];

    for(int i = 0; i < row; i++) {
        dfs(i, 0, pacificReachable, heights);
        dfs(i, col - 1, atlanticReachable, heights);

    }

   for(int i = 0; i < col; i++) {
        dfs(0, i, pacificReachable, heights);
        dfs(row - 1, i, atlanticReachable, heights);
   }

   List<List<Integer>> result = new ArrayList<>();

   for(int i = 0; i < row; i++) {
    for( int j = 0; j < col; j++) {
        if( pacificReachable[i][j] && atlanticReachable[i][j]) {
            result.add( List.of(i, j));
        }
    }
   }
    return result;
}
public void dfs( int i, int j, boolean[][] reachable, int[][] heights) {
    if( i < 0 || j < 0 || i >= heights.length 
        || j >= heights[0].length || reachable[i][j]) {
            return;
        }
        reachable[i][j] = true;

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        for( int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if( newRow >= 0 && newCol >= 0 && newRow < heights.length 
                && newCol < heights[0].length 
                && heights[newRow][newCol] >= heights[i][j]) {
                    dfs(newRow, newCol, reachable, heights);
                }
        }
}
public static void main(String[] args) {
    PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();

    int[][] heights = {
        {1,2,2,3,5},
        {3,2,3,4,4},
        {2,4,5,3,1},
        {6,7,1,4,5},
        {5,1,1,2,4}
    };

    List<List<Integer>> result = solution.pacificAtlantic(heights);

    System.out.println("Cells that can flow to both Pacific and Atlantic oceans:");
    for (List<Integer> cell : result) {
        System.out.println(cell);
    }   
}
}
