package com.dsa.practice.binaryTree;

class MaxDepthBinaryTree{
    /**
     * To find the maximum depth of a binary tree, we can use a recursive approach.
     * The maximum depth is defined as the number of nodes along the longest path from the root
     * to the farthest leaf node. We can achieve this by recursively calculating the depth of the left
     * and right subtrees for each node and returning the maximum of the two depths plus one
     * (for the current node).
     * Time Complexity: O(n) where n is the number of nodes in the tree,
     * as we visit each node once.
     * Space Complexity: O(h) where h is the height of the tree,
     * due to the recursion stack.
     * 
     */

        static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}