package com.dsa.practice.linkedList;

class LinkedListCycle {
    /**
     * To detect a cycle in a linked list, we can use Floyd's Tortoise and Hare algorithm.
     * We will use two pointers, one moving slowly (one step at a time) and the other moving quickly (two steps at a time).
     * If there is a cycle, the two pointers will eventually meet. If there is no cycle, the fast pointer will reach the end of the list.
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are only using two pointers.
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while ( slow!= null || fast != null ){
            if( fast == null || fast.next == null ){
                return false;
            }
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Example usage:
        LinkedListCycle solution = new LinkedListCycle();

        // Creating a linked list with a cycle for testing
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle here

        boolean hasCycle = solution.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle); // Output: true
    }
}