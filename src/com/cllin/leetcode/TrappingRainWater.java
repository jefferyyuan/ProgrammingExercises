package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example,
 * Given [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], return 6.
 * 
 * Source: http://oj.leetcode.com/problems/trapping-rain-water/
 */

public class TrappingRainWater extends Exercise {
    private final int[][] testSuites = 
        {{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, {5, 4, 1, 2}, {3, 1, 2}};
    
    private int result;
    
    @Override
    public void initialize() {
        result = 0;
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < testSuites.length; i++) {
            initialize();
            result = trap(testSuites[i]);
            test();
        }
        
    }
    
    private int trap(int[] array) {
        int capacity = 0;
        int length = array.length;
        
        if (length == 0) return capacity;
        
        int i = 0;
        while (i < length) {
            if (array[i] == 0) i++;
            else {
                int boundary = i + 1;
                int localMax = 0;
                int localMaxIndex = 0;
                while (boundary < length && array[boundary] < array[i]) {
                    if (boundary > i + 1 && array[boundary] > localMax) {
                        localMax = array[boundary];
                        localMaxIndex = boundary;
                    }
                    boundary++;
                }
                
                if (boundary < length) {
                    int height = Math.min(array[i], array[boundary]);
                    for (int j = i + 1; j < boundary; j++) capacity += (height - array[j]);
                    i = boundary;
                } else {
                    if (localMaxIndex == 0) i++;
                    else if (array[i + 1] >= array[localMaxIndex]) i++;
                    else {
                        int height = Math.min(array[i], array[localMaxIndex]);
                        for (int j = i + 1; j < localMaxIndex; j++) capacity += (height - array[j]);
                        i = localMaxIndex;                    
                    }
                }
                
            }
        }
        
        return capacity;
    }

    @Override
    public boolean test() {
        System.out.printf("The capacity of the terrain is %d%n", result);
        return false;
    }

}
