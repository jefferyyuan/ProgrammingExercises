package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * Source: http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 */

public class EvaluateReversePolishNotation extends LeetCodeExercise {

    private final String[][] testSuite = {
            {"2", "1", "+", "3", "*"},
            {"4", "13", "5", "/", "+"},
            {"3", "-4", "+"}
    };
    
    private int index;
    private int result;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            result = evalRPN(Arrays.copyOf(testSuite[index], testSuite[index].length));
            test();
        }
    }
    
    private int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        String used = "used";
        
        int length = tokens.length;
        int index = 2;
        
        while (index < length) {
            if (tokens[index].length() == 1 && tokens[index] != used) {
                int valueInASCII = (int) (tokens[index].charAt(0));
                
                if (valueInASCII == 42 || valueInASCII == 43 || valueInASCII == 45 || valueInASCII == 47) {
                    updateToken(tokens, index, valueInASCII, used);
                    index = -1;
                }
            }
            index++;
        }
        
        return Integer.parseInt(tokens[length - 1]);
    }
    
    private void updateToken(String[] tokens, int index, int operator, String used) {
        int secondIntegerIndex = getIntegerIndex(tokens, index - 1);
        int firstIntegerIndex = getIntegerIndex(tokens, secondIntegerIndex - 1);
        
        int secondInteger = Integer.parseInt(tokens[secondIntegerIndex]);
        int firstInteger = Integer.parseInt(tokens[firstIntegerIndex]);
        
        switch (operator) {
        case 42:
            tokens[index] = Integer.toString(firstInteger * secondInteger);
            break;
        case 43:
            tokens[index] = Integer.toString(firstInteger + secondInteger);
            break;
        case 45:
            tokens[index] = Integer.toString(firstInteger - secondInteger);
            break;
        case 47:
            tokens[index] = Integer.toString(firstInteger / secondInteger);
            break;
        }
        
        tokens[firstIntegerIndex] = used;
        tokens[secondIntegerIndex] = used;
    }
    
    private int getIntegerIndex(String[] tokens, int startIndex) {
        for (int index = startIndex; index >= 0; index--) {
            int valueInASCII = Integer.MIN_VALUE;
            
            try {
                valueInASCII = Integer.parseInt(tokens[index], 10);
            } catch (Exception e) {
                valueInASCII = Integer.MIN_VALUE;
            }
            
            if (valueInASCII != Integer.MIN_VALUE) {
                return index;
            }
        }
        
        return -1;
    }

    @Override
    public boolean test() {
        System.out.print("The value of { ");
        for (String string : testSuite[index]) {
            System.out.printf("%s ", string);
        }
        System.out.printf("} is %d%n", result);
        System.out.println("------------------");
        
        return true;
    }
}
