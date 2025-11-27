package com.dsa.practice.binaryTree;

class LCAOfBinarySearchTree {
    /**
     * To find the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST),
     * we can utilize the properties of the BST. Starting from the root, we compare the values
     * of the two nodes with the current node's value. If both nodes have values less than the
     * current node, we move to the left subtree; if both are greater, we move to the right subtree.
     * When we find a node where one of the nodes is on one side and the other is on the opposite side,
     * that node is the LCA. This approach ensures an efficient search with a time complexity of O(h),
     * where h is the height of the tree.
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if( pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if ( qVal < parentVal && pVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
        return root;
        }
    }
    public static void main(String[] args) {
        // Example usage:
        LCAOfBinarySearchTree solution = new LCAOfBinarySearchTree();

        // Creating a sample BST:
        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        //     / \
        //    3   5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 4

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected output: 2
    }
}