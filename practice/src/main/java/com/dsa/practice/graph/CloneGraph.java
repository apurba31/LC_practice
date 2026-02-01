package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

/**
 * Brute Force Approach: O(N + E) time and space
 * 1. Use Depth-First Search (DFS) or Breadth-First Search (BFS) to traverse the graph.
 * 2. Maintain a mapping from original nodes to their clones.
 * 3. For each node, create a clone and recursively clone its neighbors.
 * Optimized Approach using HashMap: O(N + E) time and space
 * 1. Use a HashMap to store the mapping from original nodes to their clones.
 * 2. Traverse the graph using DFS or BFS.
 * 3. For each node, if it hasn't been cloned yet, create a clone and add it to the map.
 * 4. Recursively clone all neighbors and add them to the cloned node's neighbor list.
 * Time Complexity: O(N + E), where N is the number of nodes and E is the number of edges in the graph.
 * Space Complexity: O(N) for storing the cloned nodes in the HashMap.
 */

static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

HashMap<Node, Node> visited = new HashMap<>();
public Node cloneGraph(Node node) {
    if (node == null) {
        return null;
    }

    if ( visited.containsKey(node)) {
        return visited.get(node);
    }

    Node clonedNode = new Node(node.val);
    visited.put(node, clonedNode);

    for ( Node neighbor : node.neighbors) {
        clonedNode.neighbors.add(cloneGraph(neighbor));
    }
    return clonedNode;
}

public static void main(String[] args) {
    CloneGraph solution = new CloneGraph();

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    Node clonedGraph = solution.cloneGraph(node1);

    System.out.println("Original Node: " + node1.val);
    System.out.println("Cloned Node: " + clonedGraph.val);

}}
