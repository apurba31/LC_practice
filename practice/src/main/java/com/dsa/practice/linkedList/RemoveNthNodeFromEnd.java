package com.dsa.practice.linkedList;

class RemoveNthNodeFromEnd {
    /**
     * To remove the N-th node from the end of a linked list,
     * we can use a two-pointer technique. We will maintain two pointers,
     * where the first pointer is advanced by N nodes ahead of the second pointer.
     * When the first pointer reaches the end of the list, the second pointer
     * will be at the node just before the N-th node from the end. We can then
     * adjust the next pointer of the second pointer to skip the N-th node. The formula
     * followed here is R = L - N + 1, where R is the position from the start,
     * L is the total length of the linked list, and N is the position from the
     * Time Complexity: O(L) where L is the length of the linked list.
     * Space Complexity: O(1) since we are only using a few pointers.
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for ( int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while ( first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the N-th node from the end
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Example: Remove the 2nd node from the end

        // Removing the N-th node from the end
        ListNode modifiedHead = solution.removeNthFromEnd(head, n);

        // Printing the modified linked list
        ListNode current = modifiedHead;
        while ( current != null) {
            System.out.print(current.val
    + " ");
            current = current.next;
        }
    }
    
}