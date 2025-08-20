package com.dsa.practice.arrays;

class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // Is a palindrome
    }

    public boolean iSPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while ( left < right) {
            while ( left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while ( left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String testString = "abba";
        boolean result = vp.iSPalindrome(testString);   
        System.out.println("Is the string \"" + testString + "\" a palindrome? " + result);

    }
}