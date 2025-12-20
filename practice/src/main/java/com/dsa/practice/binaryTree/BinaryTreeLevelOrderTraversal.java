package com.dsa.practice.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  /**
   * To perform a level order traversal of a binary tree, we can use a queue data structure to keep track of the nodes at each level. We start by adding the root node to the queue. Then, we repeatedly dequeue a node, process it (e.g., print its value), and enqueue its left and right children (if they exist). This process continues until the queue is empty, indicating that we have processed all levels of the tree.
   * The time complexity of this approach is O(n), where n is the number of nodes
   * in the tree, as we visit each node exactly once. The space complexity is O(m), where m is the maximum number of nodes at any level in the tree (the width of the tree), which is the maximum size of the queue at any point in time.
   * 
   */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<List<Integer>> ans = new ArrayList<>();

    public void order(TreeNode root, int level){
        if(ans.size() == level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if(root.left != null) order(root.left, level + 1);
        if(root.right != null) order(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return ans;
        order(root, 0);
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }   
    
}
