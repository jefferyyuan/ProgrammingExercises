package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Given an array of integer. Find the index i such that sum of 0 to i equals to i + 1 to the end of the array.
 * 
 * Source: http://www.careercup.com/question?id=5449136090382336
 */

public class BreakingPoint extends Exercise {

    private final int[][] testSuite = new int[][]{
            new int[]{1, 2, 3, 4, 5, 2, 5, 4, 4},
            new int[]{1, 0, -1, -1, 1}
    };
    
    private int index;
    private int breakingPoint;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            breakingPoint = getBreakingPoint(testSuite[index]);
            test();
        }
    }
    
    private int getBreakingPoint(int[] array) {
        int sumOfFirstHalf = 0;
        int sumOfSecondHalf = 0;
        
        for (int i = 0; i < array.length; i++) {
            sumOfSecondHalf += array[i];
        }
        
        for (int i = 0; i < array.length; i++) {
            sumOfFirstHalf += array[i];
            sumOfSecondHalf -= array[i];
            
            if (sumOfFirstHalf == sumOfSecondHalf) {
                return i;
            }
        }
        
        return -1;
    }

    protected void test() {
        System.out.print("A = { ");
        for (int n : testSuite[index]) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}, Breaking point is %d%n", breakingPoint);
    }
}
