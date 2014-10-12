package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Source: http://oj.leetcode.com/problems/generate-parentheses/ 
 */

public class GenerateParentheses implements LeetCodeExercise {
    
    private int n;
    private ArrayList<String> result;
    
    @Override
    public void initialize() {
    }

    @Override
    public void run() {
        for (n = 1; n <= 5; n++) {
            result = generateParenthesis(n);
            test();
        }
    }
    
    private ArrayList<String> generateParenthesis(int n) {
        return printParenthese(new ArrayList<String>(), n, n, new String());
    }
    
    private ArrayList<String> printParenthese(ArrayList<String> result, int left, int right, String string){
        if (left < 0) return result;
        
        if (left == 0 && right == 0) {
//            A new string should be created so the result won't be over-written by future results 
            result.add(new String(string));
            return result;
        }
        
        if (left > 0) printParenthese(result, left - 1, right, string + '(');
        if (right > left) printParenthese(result, left, right - 1, string + ')');
        
        return result;
    }

    @Override
    public boolean test() {
        System.out.printf("n = %d%n", n);
        for (String string : result) {
            System.out.printf("%s ", string);
        }
        System.out.println("\n------------");
        
        return false;
    }

}
