package com.dsa.practice.binaryTree;

public class BalancedBinaryTree {
    /**
     * To determine if a binary tree is height-balanced, we can use a recursive approach. A binary tree is considered height-balanced if for every node in the tree,
     * the difference in heights between its left and right subtrees is at most 1.
     * We can define a helper function that computes the height of a subtree while simultaneously checking if it is balanced.
     * If we find any subtree that is not balanced, we can propagate that information up the recursion stack.
     * If we reach the root without finding any unbalanced subtrees, then the entire tree is balanced.
     * Time Complexity: O(n), where n is the number of nodes in the tree, since we visit each node once.
     * Space Complexity: O(h), where h is the height of the tree, due to
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root){
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if(node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // Creating a balanced binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        boolean result = solution.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + result); // Expected output: true

        // Creating an unbalanced binary tree
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);
        unbalancedRoot.left.left.left = new TreeNode(4);

        boolean unbalancedResult = solution.isBalanced(unbalancedRoot);
        System.out.println("Is the binary tree balanced? " + unbalancedResult); // Expected output: false
    }   
}
