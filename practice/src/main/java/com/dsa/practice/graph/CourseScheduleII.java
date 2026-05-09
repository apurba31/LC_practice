package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
    /**
     * Brute Force Approach:
     * The brute force approach is to try to take each course one by one and check if
     * we can complete all courses.
     * We can use a recursive function to check if we can complete a course.
     * We can use a visited array to keep track of the courses we have visited.
     * We can use a recursion stack to keep track of the courses we are currently taking.
     * We can use a memoization array to keep track of the courses we have already checked.
     * We can use a graph to represent the courses and the prerequisites.
     * We can use a topological sort to check if the courses are acyclic.
     * Optimal Approach:
     * The optimal approach is to use a topological sort to check if the courses are acyclic.
     * We can use a graph to represent the courses and the prerequisites.
     * We can use a topological sort to check if the courses are acyclic.
     * We can use a cycle detection algorithm to check if the courses are acyclic.
     * Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites.
     * Space Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites.
     */
      static int WHITE = 1;
      static int GRAY = 2;
      static int BLACK = 3;

      boolean isPossible;
      Map<Integer, Integer> color;
      Map<Integer, List<Integer>> adjList;
      List<Integer> topologicalOrder;

      private void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // By default all vertices are WHITE
        for(int i = 0; i < numCourses; i++){
            this.color.put(i, WHITE);
        }
      }

      private void dfs(int node){
        // Don't recurse further if we find a cycle
        if(!this.isPossible){
            return;
        }

        // Start the recursion
        this.color.put(node, GRAY);

        //Traverse on neighboring vertices
        for(int neighbor : this.adjList.getOrDefault(node, new ArrayList<>())){
            if ( this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if ( this.color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
        }
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
      }

    public int[] findOrder(int numCourses, int[][] prerequisites){
        this.init(numCourses);

        // Create the adjacency list representation of the graph
        for( int i = 0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = this.adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it
        for(int i = 0; i < numCourses; i++){
            if(this.color.get(i) == WHITE){
                this.dfs(i);
            }
        }
        
        int[] order;
        if (this.isPossible) {
        order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = this.topologicalOrder.get(numCourses - i - 1);
        }
        } else {
        order = new int[0];
        }

        return order;
  }
    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = cs.findOrder(numCourses, prerequisites);
        if(order.length == 0){
            System.out.println("No valid order exists.");
        } else {
            System.out.print("Course order: ");
            for(int course : order){
                System.out.print(course + " ");
            }
        }
    }
}
