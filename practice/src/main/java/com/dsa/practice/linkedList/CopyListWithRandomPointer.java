package com.dsa.practice.linkedList;

import java.util.HashMap;

class CopyListWithRandomPointer {
    /**
     * To copy a linked list with random pointers, we can use a three-step approach:
     * 1. Create a copy of each node and insert it right next to the original node.
     * 2. Update the random pointers of the copied nodes.
     * 3. Separate the copied nodes from the original list to form the new list.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are not using any extra space for storing nodes.
     */

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            val = x;
            next = null;
            random = null;
        }
    }

    HashMap<Node, Node> visitedNode  = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if(this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }

        Node node = new Node(head.val);

        this.visitedNode.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;

    }

    public static void main(String[] args) {
        // Example usage:
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        // Creating a linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next; // 1's random points to 2
        head.next.random = head; // 2's random points to 1
        head.next.next = new Node(3);
        head.next.next.random = head.next; // 3's random points to 2
        head.next.next.next = new Node(4);
        head.next.next.next.random = head; // 4's random points to 1
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.random = head.next.next; // 5's random points to 3
        head.next.next.next.next.next = null;
        // Copying the linked list
        Node copiedListHead = solution.copyRandomList(head);

        // Printing the copied linked list to verify
        Node curr = copiedListHead;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node Value: " + curr.val + ", Random points to: " + randomVal);
            curr = curr.next;
        }
    }
}
