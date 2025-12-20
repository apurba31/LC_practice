package com.dsa.practice.binaryTree;

public class CountGoodNodes {
    /**
     * To count the number of "good" nodes in a binary tree, we can perform a depth-first traversal (DFS) of the tree while keeping track of the maximum value encountered along the path from the root to the current node. A node is considered "good" if its value is greater than or equal to this maximum value. We start at the root with its value as the initial maximum and recursively check each node's children, updating the maximum value as needed. Each time we encounter a "good" node, we increment our count.
     * The time complexity of this approach is O(n), where n is the number of nodes
     * in the tree, as we visit each node exactly once. The space complexity is O(h), where h is the height of the tree, due to the recursion stack.
     * 
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countGoodNodes(TreeNode root){
        return countGoodNodesHelper(root, Integer.MIN_VALUE);
    }

    private int countGoodNodesHelper(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int count = 0;
        //Check if the current node is a good node
        if(node.val >= maxSoFar){
            count = 1;
            maxSoFar = node.val; //Update maxSoFar
        }

        //Count good nodes in left and right subtrees
        count += countGoodNodesHelper(node.left, maxSoFar);
        count += countGoodNodesHelper(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        CountGoodNodes solution = new CountGoodNodes();
        // Creating a sample binary tree:
        //         3
        //        / \
        //       1   4
        //      /     \
        //     3       5
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);

        int result = solution.countGoodNodes(root);
        System.out.println("Number of good nodes: " + result); // Expected output: 4
    }
}
