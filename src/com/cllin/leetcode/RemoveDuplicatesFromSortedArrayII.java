package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * Source: http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class RemoveDuplicatesFromSortedArrayII extends Exercise {
    private final int MAXIMUM = 100;
    private final int SIZE = 100;
    
    private int[] array;
    private int result;
    
    @Override
    public void initialize() {
        array = new int[SIZE];
        result = SIZE;
        
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random() * MAXIMUM);
        }
        
        Arrays.sort(array);
    }

    @Override
    protected void runExercise() {
        initialize();
        
        result = removeDuplicates(array);
        if (test()) System.out.println("Success");
        else System.out.println("Failed");        
    }
    
    private int removeDuplicates(int[] array) {
        int length = array.length;
        if (length <= 2) return length;
        
        int i = 1;
        int j = 2;
        
        while (j < length) {
            if (array[j] == array[i] && array[j] == array[i - 1]) {
                j++;
            } else {
                array[++i] = array[j];
                j++;
            }
        }
        
        return i + 1;
    }

    @Override
    public boolean test() {
        int i = 0;
        
        while (i < result) {
            if (array[i + 1] != array[i]) i++;
            else {
                if (array[i + 2] != array[i]) i += 2;
                else return false;
            }
        }
        
        return true;
    }

}
