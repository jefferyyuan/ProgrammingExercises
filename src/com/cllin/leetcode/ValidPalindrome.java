package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Source: http://oj.leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome extends Exercise {
    
    private final TestCase[] testSuite = {
            new TestCase(new String(), true),
            new TestCase("A man, a plan, a canal: Panama", true),
            new TestCase("race a car", false),
            new TestCase("1a2", false),
            new TestCase("5566", false),
            new TestCase(" ", true)
    };
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void runExercise() {
        for (TestCase test : testSuite) {
            if (isPalindrome(test.string) == test.isPalindrome) System.out.println("Success");
            else System.out.println("Failed");
        }
    }
    
    private boolean isPalindrome(String string) {
        if (string == null || string.length() == 0) return true;
        
        string = string.toLowerCase();
        
//        Iterate the string with two pointers, pass if it is not an alphanumeric character
        int i = 0;
        int j = string.length() - 1;
        while (j > i) {
            if (!isAlphanumeric(string.charAt(i))) i++;
            else if (!isAlphanumeric(string.charAt(j))) j--;
            else {
                if (string.charAt(i) != string.charAt(j)) return false;
                i++;
                j--;
            }
            
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return ((48 <= (int) c && (int) c <= 57) || (97 <= (int) c && (int) c <= 122));
    }

    @Override
    public boolean test() {
        return false;
    }
    
    private class TestCase {
        private String string;
        private boolean isPalindrome;
        
        TestCase(String string, boolean isPalindrome) {
            this.string = string;
            this.isPalindrome = isPalindrome;
        }
    }

}
