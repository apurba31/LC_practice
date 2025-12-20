package com.dsa.practice.binaryTree;

public class ValidateBST {
/**
 * To validate if a binary tree is a binary search tree (BST), we can use a recursive approach.
 * The idea is to traverse the tree while keeping track of the valid range for each node's value.
 * For each node, we check if its value lies within the allowed range (min,
 * max). Initially, the range is set to negative infinity and positive infinity.
 * As we traverse the tree, we update the range for the left and right subtrees.
 * For the left child, the maximum value is updated to the current node's value,
 * and for the right child, the minimum value is updated to the current node's value.
 * If we find any node that violates the BST property, we return false.
 * The time complexity of this approach is O(n), where n is the number of nodes
 * in the tree, as we may need to visit every node. The space complexity is O(h),
 * where h is the height of the tree, due to the recursion stack.
 * 
 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public Integer prev;

    public boolean isValidBST(TreeNode root){
        prev = null;
        return validate(root);
    }

    private boolean validate(TreeNode root){
        if(root == null) return true;

        if(!validate(root.left)) return false;

        if(prev != null && root.val <= prev) return false;
        prev = root.val;
        return validate(root.right);
    }

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();
        // Creating a sample binary tree:
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean result = solution.isValidBST(root);
        System.out.println("Is the binary tree a valid BST? " + result); // Expected output: true
    }
}
