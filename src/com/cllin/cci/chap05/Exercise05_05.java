package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

/*
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * 
 * For example,
 *         Input: 31, 14
 *         Output: 2
 */

public class Exercise05_05 extends Exercise {

    private final TestCase[] testSuite = new TestCase[]{
            new TestCase(31, 14),
            new TestCase(56, 17),
            new TestCase(132, 63)
    }; 
    
    private int getBitsToConvert(int x, int y) {
        int count = 0;
        
        while (x != 0 || y != 0) {
            if ((x % 2 ^ y % 2) == 1) count++;
            
            x >>= 1;
            y >>= 1;
        }
        
        if (x == 0 && y == 0) return count;
        
        int remain = (x == 0)? y : x;
        while (remain != 0) {
            count++;
            remain >>= 1;
        }
        
        return count;
    }
    
    private class TestCase {
        int a;
        int b;
        
        TestCase(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (TestCase test : testSuite) {
            int a = test.a;
            int b = test.b;
            
            System.out.printf("It takes %d bits to convert %s to %s%n", getBitsToConvert(a, b), 
                    Integer.toBinaryString(a), Integer.toBinaryString(b));
        }    
    }

    @Override
    protected boolean test() {
        return true;
    }

}
