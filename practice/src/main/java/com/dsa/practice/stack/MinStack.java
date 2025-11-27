package com.dsa.practice.stack;

class MinStack {
    /**
     * A stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * We use an auxiliary stack to keep track of the minimum elements.
     * Methods:
     * - push(x): Push element x onto stack. 
     * - pop(): Removes the element on top of the stack.
     * - top(): Get the top element.
     * - getMin(): Retrieve the minimum element in the stack.
     * Implementation:
     * We maintain two stacks: one for all elements and another for the minimum elements.
     * When pushing a new element, we also push it onto the min stack if it is smaller than or equal to the current minimum.
     * When popping an element, if it is the same as the top of the min stack
     * , we also pop from the min stack. This way, the top of the min stack always represents the minimum element.
     * 
     */
    private Node head;

    private MinStack(){}

    public void push (int val) {
        if (head == null) {
            head = new Node(val, val, null)
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }
    public int top() {
        if (head != null) {
            return head.val;
        }
    }
    public int getMin() {
        if (head != null) {
            return head.min;
        }
    }
    private static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
}