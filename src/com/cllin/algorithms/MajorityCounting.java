package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times 
 * (and hence there is at most one such element).
 * 
 * Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:
 *         I/P : 3 3 4 2 4 4 2 4 4
 *         O/P : 4
 *         
 *         I/P : 3 3 4 2 4 4 2 4
 *         O/P : NONE
 * 
 * Source: http://www.geeksforgeeks.org/majority-element/
 */

public class MajorityCounting extends Exercise {

    private final int[][] testSuite = {
            {3, 3, 4, 2, 4, 4, 2, 4, 4},
            {3, 3, 4, 2, 4, 4, 2, 4},
            {2, 1, 2, 3, 4, 5, 6}
    };
    
    private int index;
    private int majority;
    
    private int majorityCount(int[] array) {
        int count = 1;
        int majorityIndex = 0;
        
        for (int i = 1; i < array.length; i++) {
            count = (array[i] == array[majorityIndex])? count + 1 : count - 1;
            
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[majorityIndex]) {
                count++;
            }
        }
        
        return (count > array.length / 2)? array[majorityIndex] : -1;
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
            majority = majorityCount(testSuite[index]);
            
            System.out.print("A = { ");
            for (int n : testSuite[index]) {
                System.out.printf("%d ", n);
            }

            System.out.printf("}, Majority = %s%n",
                    (majority == -1) ? "None" : Integer.toString(majority));
        }  
    }
}
