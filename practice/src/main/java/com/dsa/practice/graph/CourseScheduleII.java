package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public int[] findOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for( int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
         // 3. Add all nodes with 0 indegree
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];

        int count = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            order[count++] = curr;
            for(int next : graph.get(curr)){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
            return count == numCourses ? order : new int[0];
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
