package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;


/*
 * Given an array array[] of size n where every element is in range from 0 to n - 1. 
 * Rearrange the given array so that array[i] becomes array[array[i]]. This should be done with O(1) extra space.
 * 
 * Examples:
 *         Input: array[]  = {3, 2, 0, 1}
 *         Output: array[] = {1, 0, 3, 2}
 *
 *        Input: array[] = {4, 0, 2, 1, 3}
 *        Output: array[] = {3, 4, 2, 0, 1}
 *
 *        Input: array[] = {0, 1, 2, 3}
 *        Output: array[] = {0, 1, 2, 3}
 *
 * Source: http://www.geeksforgeeks.org/rearrayange-given-arrayay-place/ 
 */
public class RearrangeArray extends Exercise {

    private final int[][] testSuite = {
            {3, 2, 0, 1},
            {4, 0, 2, 1, 3},
            {0, 1, 2, 3}
    };
    
    private int[] rearrangeArray(int[] array) {
        int length = array.length;
        int[] result = Arrays.copyOf(array, length);
        
        for (int i = 0; i < length; i++) {
            result[i] += result[result[i]] % length * length;
        }
        
        for (int i = 0; i < length; i++) {
            result[i] /= length;
        }
        
        return result;
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
    protected boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            int[] result = rearrangeArray(testSuite[index]);

            System.out.print("I = { ");
            for (int n : testSuite[index]) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");

            System.out.print("O = { ");
            for (int n : result) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");
            System.out.println("------------------------------");
        }

        return true;
    }
}
