package com.dsa.practice.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderTraversal {
/**
 * To construct a binary tree from its pre-order traversal, we can use a recursive approach.
 * The pre-order traversal visits the root node first, followed by the left subtree and then the right subtree.
 * We can use an index to keep track of the current position in the pre-order array.
 * At each step, we create a new tree node with the value at the current index,
 * then recursively construct the left and right subtrees by incrementing the index.
 * The time complexity of this approach is O(n), where n is the number of nodes in the tree,
 * as we need to visit each node exactly once. The space complexity is O(h), where
 * h is the height of the tree, due to the recursion stack.
 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int inorderIndex = inorderIndexMap.get(rootValue);
        root.left = buildTree(preorder, inorderStart, inorderIndex - 1);
        root.right = buildTree(preorder, inorderIndex + 1, inorderEnd);
        return root;
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreOrderTraversal solution = new ConstructBinaryTreeFromPreOrderTraversal();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7}; // Example inorder traversal (must match preorder length)
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("Preorder: " + java.util.Arrays.toString(preorder));
        System.out.println("Inorder: " + java.util.Arrays.toString(inorder));
        System.out.print("Tree In-Order Traversal: ");
        printInOrder(root);
        System.out.println();
    }
}
