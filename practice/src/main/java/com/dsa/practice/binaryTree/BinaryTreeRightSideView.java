package com.dsa.practice.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /**
     * To obtain the right side view of a binary tree, we can perform a level order traversal (BFS) of the tree while keeping track of the last node at each level. We can use a queue to facilitate the level order traversal. For each level, we iterate through all nodes, and the last node we encounter at that level is the one visible from the right side. We add this node's value to our result list. This process continues until we have traversed all levels of the tree.
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                 
                //Add the last node of each level to the result
                if( i == size - 1 ){
                    result.add(current.val);
                }

                //Add child nodes to the queue
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //        \   \
        //         5   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = solution.rightSideView(root);
        System.out.println("Right Side View of the Binary Tree: " + result); // Expected output: [1, 3, 4]
    }

}
