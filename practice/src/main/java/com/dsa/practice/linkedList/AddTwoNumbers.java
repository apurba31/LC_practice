package com.dsa.practice.linkedList;

class AddTwoNumbers {

    /**
     * To add two numbers represented by linked lists, we can iterate through both lists simultaneously,
     * adding corresponding digits along with any carry from the previous addition. We create a new linked list 
     * to store the result. If one list is shorter, we treat missing digits as 0. We continue this process until 
     * we have processed all digits from both lists and any remaining carry.
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        AddTwoNumbers solution = new AddTwoNumbers();

        // Creating first linked list: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Creating second linked list: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Adding the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Printing the result linked list
        System.out.print("Resultant Linked List: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}