package com.dsa.practice.stack;

import java.util.Stack;

class ReversePolishNotation {
    /** 
     * The algorithm uses a stack to evaluate the expression:
     * - Push numbers onto the stack.
     * - When an operator is encountered, pop the required number of operands from the stack,
     *   apply the operator, and push the result back onto the stack.
     * - At the end, the stack will contain one element, which is the result of the expression.
     * This approach is efficient and works in O(n) time complexity,
     * where n is the number of tokens in the expression.
     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Integer division
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = rpn.evalRPN(tokens);
        System.out.println("Result: " + result); // Expected output: 9
    }
}