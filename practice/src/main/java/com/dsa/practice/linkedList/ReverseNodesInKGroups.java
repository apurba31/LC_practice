package com.dsa.practice.linkedList;

class ReverseNodesInKGroups {
    /**
     * To reverse nodes in k-groups in a linked list, we can iterate through the list and reverse every k nodes.
     * If the number of nodes remaining is less than k, we leave them as is. We maintain pointers to connect
     * the reversed groups properly. The process involves reversing the nodes in place and updating the next pointers.
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are reversing the nodes in place.
     */

  static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode newHead = null;

        while( ptr != null ) {
            int count = 0;
            ptr = head;
            while( count < k && ptr != null ) {
                ptr = ptr.next;
                count++;
            }
            if( count == k ){
                ListNode revHead = reverseLinkedList(head, k);
                if( newHead == null ) {
                    newHead = revHead;
                }
                if(ktail != null ) {
                    ktail.next = revHead;
                }
                ktail = head;
                head = ptr;
            }
        }
        if( ktail != null ) {
            ktail.next = head;
        }
        return newHead == null ? head : newHead;
    }
    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;
        while( k > 0 ) {
            ListNode nextNode  = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }
        return newHead;
    }

    public static void main(String[] args) {
        // Example usage:
        ReverseNodesInKGroups solution = new ReverseNodesInKGroups();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Group size for reversal
        ListNode result = solution.reverseKGroup(head, k);

        // Printing the result linked list
        System.out.print("Reversed Linked List in K-Groups: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

}       