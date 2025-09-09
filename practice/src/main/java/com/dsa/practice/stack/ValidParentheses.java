package com.dsa.practice.stack;

import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {
    // 
    public boolean isValid(String s) {
        // Create mapping: closing bracket → opening bracket
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{'); 
        mappedBrackets.put(']', '[');
        
        //  Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!mappedBrackets.containsKey(ch)) {
                //  Opening bracket - push onto stack
                stack.push(ch);
            } else {
                //  Closing bracket - check for match
                if (stack.isEmpty()) {
                    return false; // No opening bracket to match
                }
                
                char topElement = stack.pop();
                if (topElement != mappedBrackets.get(ch)) {
                    return false; // Wrong opening bracket
                }
            }
        }
        
        
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "{[]}";
        String k = "()[]{}";
        boolean result = vp.isValid(k);
        System.out.println("Is the parentheses valid? " + result);
        
    }
}