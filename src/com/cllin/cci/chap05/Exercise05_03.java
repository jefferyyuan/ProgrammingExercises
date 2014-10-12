package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

/*
 * Given an integer, 
 * print the next smallest and next largest number that have the same number of 1 bits in binary representation.
 */

public class Exercise05_03 extends Exercise {
    private final int[] testSuite = {2, 6, 16, 30, 126, 254, 512};

    private int getNextSmallestNumber(int input) {
        char[] inBinary = Integer.toBinaryString(input).toCharArray();
        
        int msb = 0;
        while (msb < inBinary.length && inBinary[msb] == '0') {
            msb++;
        }
        
        if (msb == inBinary.length) return 0;
        
        int firstZero = msb + 1;
        while (firstZero < inBinary.length && inBinary[firstZero] == '1') {
            firstZero++;
        }
        
        if (firstZero == inBinary.length) return input;
        
        inBinary[firstZero] = '1';
        inBinary[firstZero - 1] = '0';
        
        return Integer.parseInt(new String(inBinary), 2);
    }
    
    private int getNextLargestNumber(int input) {
        char[] inBinary = Integer.toBinaryString(input).toCharArray();
        
        int firstZero = inBinary.length - 1;
        while (firstZero >= 0 && inBinary[firstZero] == '1') {
            firstZero--;
        }
        
        if (firstZero == -1) return input;
        if (firstZero == inBinary.length - 1) {
            input <<= 1;
            inBinary = Integer.toBinaryString(input).toCharArray();
            
            int firstOne = inBinary.length - 1;
            while (firstOne >= 0 && inBinary[firstOne] == '0') {
                firstOne--;
            }
            
            if (firstOne == 0) return input;
            
            inBinary[firstOne] = '0';
            inBinary[inBinary.length - 1] = '1';
        } else {
            
            inBinary[firstZero] = '1';
            inBinary[firstZero + 1] = '0';
        }
        
        return Integer.parseInt(new String(inBinary), 2);
    }

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (int n : testSuite) {
            int nextSmallest = getNextSmallestNumber(n);
            int nextLargest = getNextLargestNumber(n);
            
            System.out.printf("N = %s, NextSmallestNumber(N) = %s, NextLargestNumber(N) = %s%n", 
                    Integer.toBinaryString(n), 
                    Integer.toBinaryString(nextSmallest), 
                    Integer.toBinaryString(nextLargest));
        }    
    }

    @Override
    protected void test() {
    return;
    }

}
