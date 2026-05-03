package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /**
     * Brute Force Approach:
     * The brute force approach is to try to take each course one by one and check if we can complete all courses.
     * We can use a recursive function to check if we can complete a course.
     * We can use a visited array to keep track of the courses we have visited.
     * We can use a recursion stack to keep track of the courses we are currently taking.
     * We can use a memoization array to keep track of the courses we have already checked.
     * We can use a graph to represent the courses and the prerequisites.
     * We can use a topological sort to check if the courses are acyclic.
     * We can use a cycle detection algorithm to check if the courses are acyclic.
     * Optimized Approach:
     * The optimized approach is to use a topological sort to check if the courses are acyclic.
     * We can use a graph to represent the courses and the prerequisites.
     * We can use a topological sort to check if the courses are acyclic.
     * We can use a cycle detection algorithm to check if the courses are acyclic.
     * O(V + E) time complexity, O(V + E) space complexity
     * 
     * 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites){
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){ 
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
    }

    int count = 0;

    while(!q.isEmpty()){
        int curr = q.poll();
        count++;

        for(int next : graph.get(curr)){
            indegree[next]--;

            if(indegree[next] == 0){
                q.offer(next);
            }
        }
    }

    return count == numCourses;
}

public static void main(String[] args) {
    CourseSchedule cs = new CourseSchedule();
    int numCourses = 3;
    // int[][] prerequisites = {{1, 0}};
    int[][] prerequisites = {{1, 0}, {0, 1}, {2, 1}, {2, 0}}; // This will create a cycle
    System.out.println(cs.canFinish(numCourses, prerequisites)); // Output: false
}
}   