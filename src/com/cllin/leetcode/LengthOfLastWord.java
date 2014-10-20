package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Source: http://oj.leetcode.com/problems/length-of-last-word/
 */

public class LengthOfLastWord extends Exercise {
    private static final String[] testSuite = {"", " ", "   ","a ", " a", "  a  bc  ", "laptop", "hello world ", "how do you do?"};
    
    private int idx;
    private int result;

    @Override
    public void initialize() {
        idx = 0;
        result = 0;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private int lengthOfLastWord(String string) {
        if (string.length() == 0) return 0;

        int index = string.length() - 1;
        while (index >= 0 && string.charAt(index) == ' ') {
            index--;
        }
        
        int length = 0;
        while (index >= 0 && string.charAt(index) != ' ') {
            length++;
            index--;
        }
        
        return length;
    }

    @Override
    public boolean test() {
        for (idx = 0; idx < testSuite.length; idx++) {
            result = lengthOfLastWord(testSuite[idx]);
            System.out.printf("The length of the last word of -%s- is %d%n", testSuite[idx], result);
        }
        return true;
    }

}
