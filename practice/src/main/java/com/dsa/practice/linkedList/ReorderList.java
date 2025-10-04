package com.dsa.practice.linkedList;

class ReorderList {
    /**
     * The goal of this problem is to reorder a given singly
     * linked list in a specific pattern. The pattern involves
     * rearranging the nodes such that the first node is followed
     * To solve this problem, we can do this: find the middle of the 
     * linkedlist, reverse the second half of the list, and then merge
     * the two halves together. by the last node, then the second node followed by the second
     * last node, and so on. For example, given the linked list 1 ->
     * Time Complexity: O(n) and Space Complexity: O(n)
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if ( head == null){
            return;
        }
        
        ListNode slow = head, fast = head;
        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, temp;
        while ( curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;
        while( second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
        
        
    }

    public static void main(String[] args) {
        // Example usage:
        ReorderList solution = new ReorderList();
        
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reordering the linked list
        solution.reorderList(head);

        // Printing the reordered linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}