package com.dsa.practice.binaryTree;

class InvertTree {
    /**
     * To invert a binary tree, we can use a recursive approach where we swap the left and right children
     * of each node in the tree. We start from the root and recursively invert the left and right subtrees.
     * The base case for the recursion is when we reach a null node, at which point we simply return.
     * Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
     * Space Complexity: O(h) where h is the height of the tree, due to the recursion stack.
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        // Example usage:
        InvertTree solution = new InvertTree();

        // Creating a sample binary tree:
        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Inverting the binary tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Function to print the tree in-order (for verification)
        printInOrder(invertedRoot); // Expected output: 9 7 6 4 3 2 1

}
    private static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }   
}