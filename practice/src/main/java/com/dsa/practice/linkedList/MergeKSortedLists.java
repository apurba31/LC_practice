package com.dsa.practice.linkedList;

import java.util.PriorityQueue;

class MergeKSortedLists {
    /**
     * To merge k sorted linked lists, we can use a divide-and-conquer approach.
     * We repeatedly merge pairs of lists until only one list remains. This can be done
     * using the mergeTwoLists method defined in the MergeTwoSortedList class.
     * Time Complexity: O(N log k) where N is the total number of nodes across all lists and k is the number of lists.
     * Space Complexity: O(1) for the merging process itself, but O(log k) for the recursion stack.
     * Better Approach: We can also use a min-heap (priority queue) to keep track of the smallest current node
     * among the k lists, which can improve efficiency in some cases.
     * Time Complexity with Min-Heap: O(N log k)
     * Space Complexity with Min-Heap: O(k)
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for( ListNode list : lists ) {
            while ( list != null ) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        
        while(!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.poll());
            merge = merge.next;
        }   
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        MergeKSortedLists solution = new MergeKSortedLists();

        // Creating example sorted linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        // Merging the k sorted linked lists
        ListNode mergedHead = solution.mergeKLists(lists);
        // Printing the merged linked list
        ListNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}