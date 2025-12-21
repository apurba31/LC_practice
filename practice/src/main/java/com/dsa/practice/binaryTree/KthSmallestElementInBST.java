package com.dsa.practice.binaryTree;

import java.util.ArrayList;

public class KthSmallestElementInBST {
    /**
     * To find the k-th smallest element in a binary search tree (BST), we can perform an in-order traversal of the tree.
     * In a BST, an in-order traversal visits the nodes in ascending order. We can
     * keep a count of the nodes visited during the traversal, and when the count reaches k, we have found the k-th smallest element.
     * We can implement this using a recursive approach. We start from the root and recursively traverse
     * the left subtree, then visit the current node, and finally traverse the right subtree.
     * We maintain a counter to track the number of nodes visited so far. When the counter
     * equals k, we store the value of the current node as the result.
     * The time complexity of this approach is O(h + k), where h is the height of the tree,
     * as we may need to traverse the height of the tree and visit k nodes. The
     * space complexity is O(h) due to the recursion stack.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return list;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

        return list;
    }

    public int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        // Creating a sample BST:
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "-th smallest element in the BST is: " + result); // Expected output: 3
    }

}
