package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * Source: http://oj.leetcode.com/problems/sqrtx/
 */

public class SqrtX extends Exercise {

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void runExercise() {
        for (int i = 1; i <= 2147483647 && i > 0; i *= 2) {
            int squareRoot = sqrt(i);
            System.out.printf("The square root of %d is %d%n", i, squareRoot);
        }
    }
    
//    Classic binary search
    private int sqrt(int x) {
        if (x <= 0) return 0;
        else if (x == 1) return 1;
        
        long root;
        long start = 1;
        long end = x;
        
        while (start < end) {
            root = (start + end) / 2;
            
//            Using root <= x / root instead of root * root <= x to avoid overflowing
            if (root <= x / root && (x / (root + 1)) < (root + 1)) {
                return (int) root;
            } else if (root < (x / root)) {
                start = root;
            } else {
                end = root;
            }
        }
        
        return -1;
    }

    @Override
    public boolean test() {
        return false;
    }

}
