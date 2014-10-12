package com.cllin.leetcode;

import java.util.HashMap;
import java.util.Stack;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Source: http://oj.leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses implements LeetCodeExercise {
    private final String[] testSuite = {
            "", "()[]{}", "([)]{}", "([])", "(("
            };

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        initialize();
        
        for (int i = 0; i < testSuite.length; i++) {
            boolean result = isValid(testSuite[i]);
            System.out.printf("The parentheses of %s are %s%n", testSuite[i].toString(), (result)? "valid" : "invalid");
        }
    }
    
    public boolean isValid(String string) {
        int length = string.length();
        if (length == 0) return true;
        if (length % 2 == 1) return false;
        
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    @Override
    public boolean test() {
        return true;
    }

}
