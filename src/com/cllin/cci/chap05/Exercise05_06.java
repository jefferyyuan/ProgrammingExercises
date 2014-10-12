package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

/*
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
 */

public class Exercise05_06 extends Exercise {
    private final int[] testSuite = {1, 4, 6, 10, 42, 183, 5566};
    
    private int swapEvenAndOddBits(int input) {
        int copyOddToEven = (input & 0XAAAAAAAA) >> 1;
        int copyEvenToOdd = (input & 0X55555555) << 1;
        int output = copyEvenToOdd | copyOddToEven;
        
        return output;
    }

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (int n : testSuite) {
            int output = swapEvenAndOddBits(n);
            
            System.out.printf("%s -> %s%n",
                    Integer.toBinaryString(n), 
                    Integer.toBinaryString(output));
        }    
    }

    @Override
    protected void test() {
    return;
    }

}
