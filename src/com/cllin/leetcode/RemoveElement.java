package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Source: http://oj.leetcode.com/problems/remove-element/
 */

public class RemoveElement implements LeetCodeExercise {
    private final int MAXIMUM = 1000;
    private final int SIZE = 1000;
    
    private int[] array;
    private int newLength;
    private int value;
    
    @Override
    public void initialize() {
        array = new int[SIZE];
        newLength = 0;
        value = (int)(Math.random() * MAXIMUM);

        for (int i = 0; i < SIZE; i++) {
            int value = (int)(Math.random() * MAXIMUM);
            array[i] = value;
        }
    }

    @Override
    public void run() {
        initialize();
        
        newLength = removeElement(array, value);
        if (test()) System.out.println("Success");
        else System.out.println("Failed");
    }
    
    private int removeElement(int[] A, int elem) {
        int lastValidIndex = A.length - 1;
        
        for (int i = 0; i <= lastValidIndex; i++) {
            if (A[i] == elem) {
//                Swap with the last valid element
                while (lastValidIndex >= 0 && A[lastValidIndex] == elem) {
                    lastValidIndex--;
                }
                
                if (i < lastValidIndex) A[i] = A[lastValidIndex--]; 
            }
        }
        
        return lastValidIndex + 1;
    }
    

    @Override
    public boolean test() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (array[i] == -2147483648) break;
            if (array[i] == value) return false;
            
            count++;
        }
        
        return (count == newLength)? true : false;
    }

}
