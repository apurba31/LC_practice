package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GraphValidTree {
    /**
     * Brute Force Approach:
     * The brute force approach is to try to take each course one by one and check if
     * we can complete all courses.
     * We can use a recursive function to check if we can complete a course.
     * We can use a visited array to keep track of the courses we have visited.
     * We can use a recursion stack to keep track of the courses we are currently taking.
     * Optimal Approach:
     * We can use DSU to check if the graph is a valid tree.
     * Here we can use a parent array to keep track of the parent of each node.
     * We can use a rank array to keep track of the rank of each node.
     * We can use a count variable to keep track of the number of edges in the graph.
     * We can iterate through the edges and for each edge we can check if the two nodes
     * are in the same set or not. If they are in the same set then we can return false.
     * If they are not in the same set then we can union the two sets and increment
     * the count variable. Finally we can check if the count variable is equal to n - 1 or not.
     * Time Complexity: O(E * α(N)), where E is the number of edges and
     * α(N) is the inverse Ackermann function.
     * Space Complexity: O(N), where N is the number of nodes in the graph.
     */
    public boolean validTree(int n, int[][] edges){
        if(edges.length != n - 1){
            return false;
        }
        List<List<Integer>> adjancencyList  = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjancencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjancencyList.get(edge[0]).add(edge[1]);
            adjancencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(int neighbor : adjancencyList.get(curr)){
                if(visited.contains(neighbor)){
                    continue;
                }
                visited.add(neighbor);
                stack.push(neighbor);
            }
        }
        if(visited.size() == n){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        GraphValidTree gvt = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(gvt.validTree(n, edges)); // Output: true
    }
}
