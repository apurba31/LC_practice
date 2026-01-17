package com.dsa.practice.greedy;

public class ValidParenthesisString {
    /**
     * Brute Force Approach:
     * 1. Generate all possible strings by replacing '*' with '(', ')' or ''.
     * 2. Check each generated string to see if it is a valid parenthesis string.
     * 3. If any valid string is found, return true; otherwise, return false
     * Optimized Approach (Greedy Algorithm):
     * 1. Use two counters to track the minimum and maximum possible open
     *   parentheses at each position in the string.
     * 2. Iterate through the string character by character.
     *   - If the character is '(', increment both counters.
     *  - If the character is ')', decrement both counters.
     *  - If the character is '*', increment the maximum counter and
     *   decrement the minimum counter.
     * 3. Ensure that the minimum counter does not go below zero.
     * 4. If the maximum counter goes below zero at any point, return false.
     * 5. After processing all characters, if the minimum counter is zero,
     *  return true; otherwise, return false. 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean checkValidString(String s){
        int minOpen =0, maxOpen =0;

        for(char c : s.toCharArray()){
            if(c == '('){
                // Treat as open parenthesis
                minOpen++;
                maxOpen++;
            } else if(c == ')'){
                // Treat as closed parenthesis
                minOpen--;
                maxOpen--;
            } else {
                // Treat as either open, closed or empty
                minOpen--;
                maxOpen++;
            }

            //If at any point, maxOpen is negative, return false
            if(maxOpen < 0){
                return false;
            }
            //minOpen should not be negative
            minOpen = Math.max(minOpen, 0);

        }
        // If minOpen is zero, we have a valid string
        return minOpen == 0;
    }
    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        String s = "(*))";
        System.out.println("Is the string valid? " + vps.checkValidString(s));
    }
}
