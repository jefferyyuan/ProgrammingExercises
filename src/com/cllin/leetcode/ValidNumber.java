package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Validate if a given string is numeric.
 * 
 * Some examples:
 *         "0" => true
 *         " 0.1 " => true
 *         "abc" => false
 *         "1 a" => false
 *         "2e10" => true
 * 
 * Source: http://oj.leetcode.com/problems/valid-number/
 */

public class ValidNumber extends LeetCodeExercise {

    private final String[] testSuite = {
            "0",
            "   0.1  ",
            "abc",
            "1a",
            "2E10",
            "."
    };
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (String input : testSuite) {
            boolean isNumber = isNumber(input);
            System.out.printf("%s %s a valid number%n", input, (isNumber)? "is" : "is not");
        }
    }

    private boolean isNumber(String string) {
        if (string == null || string.length() == 0) return false;
        
        int transitionTable[][] = {
                {-1,  0,  3,  1,  2, -1},
                {-1,  8, -1,  1,  4,  5},
                {-1, -1, -1,  4, -1, -1},
                {-1, -1, -1,  1,  2, -1},
                {-1,  8, -1,  4, -1,  5},
                {-1, -1,  6,  7, -1, -1},
                {-1, -1, -1,  7, -1, -1},
                {-1,  8, -1,  7, -1, -1},
                {-1,  8, -1, -1, -1, -1}
        };
        
        int index = 0;
        int currentState = 0;
        while (index < string.length()) {
            int currentInput = 0;
            char c = string.charAt(index);
            
            if (c == ' ') {
                currentInput = 1;
            } else if (c == '+' || c == '-') {
                currentInput = 2;
            } else if (48 <= (int) c && (int) c <= 57) {
                currentInput = 3;
            } else if (c == '.') {
                currentInput = 4;
            } else if (c == 'E' || c == 'e') {
                currentInput = 5;
            } else {
                return false;
            }
            
            currentState = transitionTable[currentState][currentInput];
            if (currentState == -1) return false;
            
            index++;
        }
        
        return currentState == 1 || currentState == 4 || currentState == 7 || currentState == 8;
    }

    @Override
    public boolean test() {
        return true;
    }
}
