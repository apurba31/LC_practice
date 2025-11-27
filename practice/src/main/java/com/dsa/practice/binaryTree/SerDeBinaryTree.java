package com.dsa.practice.binaryTree;

import java.util.List;

class SerDeBinaryTree {
    /**
     * To serialize and deserialize a binary tree, we can use a pre-order traversal approach.
     * During serialization, we convert the tree into a string representation by traversing the tree
     * and appending node values to a string, using a special marker (e.g., "#") for null nodes.
     * During deserialization, we reconstruct the tree from the string by reading the values in order
     * and creating nodes accordingly.
     * Time Complexity: O(n) for both serialization and deserialization, where n is the
     * number of nodes in the tree.
     * Space Complexity: O(n) for storing the serialized string and the recursion stack.
     * 
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    // Reserialize 
    public String recserialize(TreeNode root, String str) {
        if (root == null) {
            return "null";
        }
        else {
            str += str.valueOf(root.val) + ",";
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }
        return str;
    }

    // Serialize
    public String serialize(TreeNode root) {
        String str = "";
        return recserialize(root, "");
    }

    public TreeNode recdeserialize(List<String> strs){
        if(strs.get(0).equals("null")){
            strs.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs.get(0)));
        strs.remove(0);
        root.left = recdeserialize(strs);
        root.right = recdeserialize(strs);
        return root;
    }

    // Deserialize
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> strList = new java.util.LinkedList<String>(java.util.Arrays.asList(strArray));
        return recdeserialize(strList);
    }

    // Main method for testing
    public static void main(String[] args)  {
        SerDeBinaryTree serDe = new SerDeBinaryTree();

        // Creating a sample binary tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serializing the binary tree
        String serializedData = serDe.serialize(root);
        System.out.println("Serialized Binary Tree: " + serializedData);

        // Deserializing the binary tree
        TreeNode deserializedRoot = serDe.deserialize(serializedData);
        String reSerializedData = serDe.serialize(deserializedRoot);
        System.out.println("Re-Serialized Binary Tree after Deserialization: " + reSerializedData);
    }

}