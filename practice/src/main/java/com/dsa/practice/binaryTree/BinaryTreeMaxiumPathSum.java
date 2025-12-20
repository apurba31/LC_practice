package com.dsa.practice.binaryTree;

public class BinaryTreeMaxiumPathSum {
/**
 * To find the maximum path sum in a binary tree, we can use a recursive approach. 
 * The idea is to traverse the tree and at each node, calculate the maximum path sum that can be obtained by including that node. 
 * We need to consider both the left and right subtrees of the node.
 * For each node, we calculate the maximum path sum that can be obtained by including the node and either its left or right subtree (or neither if they contribute negatively). 
 * We also keep track of the maximum path sum found so far, which may include paths that pass through the current node and both its left and right children.
 * The time complexity of this approach is O(n), where n is the number of nodes in the tree, as we need to visit each node exactly once. 
 * The space complexity is O(h), where h is the height of the tree, due to the recursion stack.
 */
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    int maxSum = Integer.MIN_VALUE;
    
    public int maxGain(TreeNode node){
        if(node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int currentMaxPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentMaxPath);

        return node.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    public static void main(String[] args) {
        BinaryTreeMaxiumPathSum solution = new BinaryTreeMaxiumPathSum();
        // Creating a sample binary tree:
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = solution.maxPathSum(root);
        System.out.println("The maximum path sum in the binary tree is: " + result); // Expected output: 42
    }
}
