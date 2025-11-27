package com.dsa.practice.binaryTree;

class DiameterOfBinaryTree {
    /**
     * To find the diameter of a binary tree, we can use a depth-first search (DFS) approach.
     * The diameter is defined as the length of the longest path between any two nodes in the tree.
     * This path may or may not pass through the root. We can calculate the depth of each subtree recursively,
     * and at each node, we update the diameter by considering the sum of the depths of the left and right subtrees.
     * Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
     * Space Complexity: O(h) where h is the height of the tree, due to the recursion stack.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    } 
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
        // Example usage:
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Creating a sample binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculating the diameter of the binary tree
        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result); // Expected output: 4
    }
}