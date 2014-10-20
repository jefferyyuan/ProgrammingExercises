package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Source: http://oj.leetcode.com/problems/integer-to-roman/
 */

public class IntegerToRoman extends Exercise {
    private final int SIZE = 100;
    private final int MAXIMUM = 3998;

    private int[] numbers;
    
    @Override
    public void initialize() {
        numbers = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int)(Math.random() * MAXIMUM) + 1;
        }

    }

    @Override
    protected void runExercise() {
        initialize();
        
        for (int n : numbers) {
            System.out.printf("In Roman, %d is %s%n", n, intToRoman(n));
        }
    }
    
    private String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();

        int[] digits = new int[4];
        
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num -= num % 10;
            num /= 10;
        }
        
        for (int i = 0; i < digits[3]; i++) {
            buffer.append("M");
        }
        
        buffer.append(getRoman(2, digits[2]));
        buffer.append(getRoman(1, digits[1]));
        buffer.append(getRoman(0, digits[0]));
        
        return buffer.toString();
    }
    
    private String getRoman(int power, int digit) {
        StringBuffer buffer = new StringBuffer();
        
        String one = new String();
        String four = new String();
        String five = new String();
        String nine = new String();
        
        if (power == 0) {
            one = "I";
            four = "IV";
            five = "V";
            nine = "IX";
        } else if (power == 1) {
            one = "X";
            four = "XL";
            five = "L";
            nine = "XC";
        } else if (power == 2) {
            one = "C";
            four = "CD";
            five = "D";
            nine = "CM";            
        }
        
        if (digit == 9) {
            buffer.append(nine);
        } else if (digit == 4) {
            buffer.append(four);
        } else {
            if (digit >= 5) {
                buffer.append(five);
                digit -= 5;
            }
            
            for (int i = 0; i < digit; i++) {
                buffer.append(one);
            }
        }
        
        return buffer.toString();
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
