package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1, 2, 0] return 3,
 * and [3, 4, -1, 1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * Source: http://oj.leetcode.com/problems/first-missing-positive/
 */

public class FirstMissingPositive extends LeetCodeExercise {
    
    private final int[][] testSuite = {
            {0},
            {1},
            {2},
            {1000, -1},
            {2, 2},
            {1, 2, 0},
            {3, 4, -1, 1}
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
            result = firstMissingPositive(testSuite[index]);
            test();
        }
    }
    
    private int firstMissingPositive(int[] array) {
        if (array == null || array.length == 0) return 1;
        
        int length = array.length;
        int shift = segregate(array);
        
        /*
         * Save the existence of each valid number in negative number
         * Count of 1 should be saved in array[shift]
         */
        for (int i = shift; i < length; i++) {
            int index = Math.abs(array[i]) - 1 + shift;
            if (index < length && array[index] > 0) {
                array[index] = (-1) * array[index];
            }
        }
    
//        Starting from 1, which is saved in array[shift], iterate the array until the first non-negative number 
        for (int i = shift; i < length; i++) {
            if (array[i] > 0) {
                return i - shift + 1;
            }
        }
        
        return length - shift + 1;
    }
    
//    Move all non-positive number to the left of the array
    private int segregate(int[] array) {
        int shift = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                int temp = array[i];
                array[i] = array[shift];
                array[shift] = temp;
                
                shift++;
            }
        }
        
        return shift;
    }

    @Override
    public boolean test() {
        System.out.print("The missing positive integer of the sequence { ");
        for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
        System.out.printf("} is %d%n", result);
        
        return true;
    }

}