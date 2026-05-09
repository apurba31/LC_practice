package com.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponentsInUndirectedGraph {
    /**
     * Brute Force Approach:
     * The brute force approach to find connected components in an undirected graph is to use Depth First Search (DFS) or Breadth First Search (BFS) to traverse the graph. We can start from an unvisited node and mark all the nodes that are reachable from it as visited. This will give us one connected component. We can repeat this process until we have visited all the nodes in the graph.
     * undirected graph involves traversing the graph and marking the visited nodes. We can use a visited array to keep track of the nodes that have been visited. We can use a count variable to keep track of the number of connected components in the graph. We can iterate through all the nodes in the graph and for each unvisited node we can perform a DFS or BFS to mark all the reachable nodes as visited and increment the count variable.
     * Time Complexity: O(V + E), where V is the number of vertices and E
     * Optimal Approach:
     * We can use Disjoint Set Union (DSU) to find the number of connected
     * components in an undirected graph. We can use a parent array to keep track of the parent of each node. We can use a rank array to keep track of the rank of each node. We can iterate through the edges and for each edge we can union the two nodes. Finally we can iterate through the parent array and count the number of unique parents which will give us the number of connected components in the graph.
     * Time Complexity: O(E * α(N)), where E is the number of edges and
     * α(N) is the inverse Ackermann function.
     * Space Complexity: O(N), where N is the number of nodes in the graph.
     * 
     */
    public int countComponents(int n, int[][] edges){
        int count = 0;
        int[] visited = new int[n];

        List<Integer>[] adjacencyList = new ArrayList[n];
        Deque<Integer>[] stackAr = new ArrayDeque[n];
        Queue<Integer>[] queueAr = new ArrayDeque[n];
        HashMap<Integer, Integer>[] hashMapAr = new HashMap[n];

        for(int i = 0; i < n; i++){
            stackAr[i] = new ArrayDeque<>();
            queueAr[i] = new ArrayDeque<>();
            hashMapAr[i] = new HashMap<>();
        }
        

        for(int i = 0; i < n; i++){
            adjacencyList[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges.length; i++){
            adjacencyList[edges[i][0]].add(edges[i][1]);
            adjacencyList[edges[i][1]].add(edges[i][0]);
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                count++;
                dfs(adjacencyList,visited, i);
            }
        }
        return count;
    }

    public void dfs(List<Integer>[] adjList, int[] visited, int node){
        visited[node] = 1;
        for(int neighbor : adjList[node]){
            if(visited[neighbor] == 0){
                dfs(adjList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph obj = new NumberOfConnectedComponentsInUndirectedGraph();
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(obj.countComponents(n, edges));
    }
}