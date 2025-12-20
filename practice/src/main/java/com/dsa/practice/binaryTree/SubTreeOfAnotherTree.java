package com.dsa.practice.binaryTree;

public class SubTreeOfAnotherTree {
    /**
     * To determine if one binary tree is a subtree of another, we can use a recursive approach.
     * We start by checking if the main tree (s) is null; if it is, then it cannot contain any subtree, so we return false.
     * If the current node of the main tree matches the root of the subtree (t),
     * we invoke a helper function to check if the two trees are identical from that point onward.
     * If they are identical, we return true. If not, we recursively check the left
     * and right subtrees of the main tree for a match.
     * The time complexity of this approach is O(m * n) in the worst case,
     * where m is the number of nodes in tree s and n is the number of nodes in tree t,
     * as we may need to compare each node of s with every node of t.
     * The space complexity is O(h) where h is the height of tree s, due to the recursion stack.
     * 
     **/

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if ( s== null || t == null) return false;
        if( s.val != t.val ) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        if(isSame(s, t)){
                return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);   
    }

    public static void main(String[] args) {
        SubTreeOfAnotherTree solution = new SubTreeOfAnotherTree(); 
        // Creating main tree:
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);
        // Creating subtree:
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        boolean result = solution.isSubtree(s, t);
        System.out.println("Is t a subtree of s? " + result); // Expected output: true
    }

}
