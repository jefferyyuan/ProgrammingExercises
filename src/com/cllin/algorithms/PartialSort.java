package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given an array which has n integers, it has both positive and negative integers.
 * Sort this array in such a way that the negative integers should be in the front, and the positive integers should at the back.
 * The relative position should not be changed.
 * 
 * For example,
 * Input = {-1, 1, 3, -2, 2}
 * Output = {-1, -2, 1, 3, 2}
 * 
 * Required running time complexity is O(N) and the space complexity is O(1)
 * 
 * Source: http://www.geeksforgeeks.org/forums/topic/sort-the-array-in-a-special-way/
 */

public class PartialSort extends Exercise {

    private final int[][] testSuite = {
            {-1, 1, 3, -2, 2}
    };
    
    private int index;
    private int[] output;
    
    private int[] partialSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= 0) continue; 
            
            int position = i - 1;
            while (position >= 0 && array[position] >= 0) {
                position--;
            }
            
            int temp = array[i];
            for (int j = i - 1; j > position; j--) {
                array[j + 1] = array[j];
            }
            array[position + 1] = temp;
            
        }
        
        return array;
    }
    
    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected void test() {
        for (index = 0; index < testSuite.length; index++) {
            output = partialSort(Arrays.copyOf(testSuite[index], testSuite[index].length));

            System.out.print("Input = { ");
            for (int n : testSuite[index]) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");

            System.out.print("Output = { ");
            for (int n : output) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");
        }
    }
}
