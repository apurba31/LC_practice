package com.dsa.practice.binaryTree;

public class SameTree {
    /**
     * To determine if two binary trees are the same, we can use a recursive approach. We start at the root nodes of both trees and compare their values.
     * If the values are different, we return false. If they are the same, we recursively check the left and right subtrees of both nodes.
     * If we reach the end of both trees (i.e., both nodes are null), we return true. If one node is null and the other is not, we return false.
     * This process continues until we have compared all corresponding nodes in both trees.
     * The time complexity of this approach is O(n), where n is the number of nodes in the trees, as we may need to visit every node in both trees.
     * The space complexity is O(h), where h is the height of the trees, due to the recursion stack.
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q== null) return false;
        if( p.val != q.val ) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);    
    }
    public static void main(String[] args) {
        SameTree solution = new SameTree(); 
        // Creating first tree:
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        // Creating second tree:
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        boolean result = solution.isSameTree(p, q);
        System.out.println("Are the two trees the same? " + result); // Expected output
    }       
}
