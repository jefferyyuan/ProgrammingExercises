package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Implement atoi to convert a string to an integer.
 * 
 * Source: http://oj.leetcode.com/problems/string-to-integer-atoi/
 */

public class StringToInteger extends Exercise {

    private String[] testSuite = {
            "+-+2",
            "1",
            "     +004500",
            "+1",
            "    010",
            "2147483648",
            "-2147483648",
            "-2147483649",
            "31474836491",
            "      -11919730356x"
    };
    private int output;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void runExercise() {
        for (String input : testSuite) {
            output = atoi(input);
            System.out.printf("%s = %d%n", input, output);test();
        }
    }
    
    private int atoi(String string) {
        if (string == null || string.length() == 0) return 0;

        char[] charArray = string.toCharArray();
        int index = 0;
        int output = 0;
        
        while (index < string.length() && (charArray[index] == ' ' || charArray[index] == '0')) {
            index++;
        }
        
        boolean isNegative = charArray[index] == '-';
        index = (charArray[index] == '-' || charArray[index] == '+')? index + 1 : index;
        
        int validLength = 0;
        while (index < string.length() && validLength <= 10) {
            int value = (int) charArray[index] - (int) '0';
            if (value < 0 || value > 9) {
                break;
            }

            if (validLength == 9) {
                if (isNegative) {
                    if (output > 214748364 || (output == 214748364 && value > 8)) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (output >= 147483648 || output == 214748364 && value > 7) {
                        return Integer.MAX_VALUE;
                    }                    
                }
            }
            
            if (validLength > 9) {
                return (isNegative)? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            output *= 10;
            output += value;
            
            index++;
            validLength++;
        }
        
        return (isNegative)? -output : output;
    }

    @Override
    public boolean test() {
        return true;
    }

}
