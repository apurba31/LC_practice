package com.dsa.practice.linkedList;

class ReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev;              // Reverse the link
            prev = current;                   // Move prev to current
            current = nextTemp;               // Move to next node
        }
        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        // Example usage:
        ReverseList solution = new ReverseList();
        
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reversing the linked list
        ListNode reversedHead = solution.reverseList(head);

        // Printing the reversed linked list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}