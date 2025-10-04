package com.dsa.practice.linkedList;

class MergeTwoSortedList {
    /**
     * To merge two sorted linked lists, we can use a two-pointer technique.
     * We will create a dummy node to serve as the starting point of the merged list.
     * We will then iterate through both lists, comparing the current nodes of each list,
     * and appending the smaller node to the merged list. Once we reach the end of one of the lists,
     * we will append the remaining nodes of the other list to the merged list.
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists.
     * Space Complexity: O(1) since we are only using a few pointers and not
     */
    
    static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while (list1 != null && list2 != null) {
            if ( list1.val <= list2.val ) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }
        // if ( merge.next == list1 && list1 == null) {
        //     merge.next = list2;
        // } else {
        //     merge.next = list1;
        // }
        merge.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        MergeTwoSortedList solution = new MergeTwoSortedList();
        
        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Merging the two sorted linked lists
        ListNode mergedHead = solution.mergeTwoLists(list1, list2);

        // Printing the merged linked list
        ListNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}