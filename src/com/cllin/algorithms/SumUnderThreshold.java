package com.cllin.algorithms;

import java.util.Arrays;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given an array of integers with size n, and a threshold that is an integer.
 * Return the number of distinct pairs whose sum is smaller or equal than the threshold.
 * 
 * Source: http://www.careercup.com/question?id=5858156613730304
 */

public class SumUnderThreshold extends Exercise {

    private final int SIZE = 10;
    private final int MAXIMUM = 20;
    
    private int[] array;
    private int threshold;
    private int nPairs;
    
    /*
     * Solution 1: With sorting
     * Complexity = O(n * long(n)), can be improved to O(n) with counting sort
     */
    private int getNumPairs(int[] array, int threshold) {
        Arrays.sort(array);
        
        int i = 0;
        int j = array.length - 1;
        int count = 0;
        while (i < j) {
            if (array[i] + array[j] <= threshold) {
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
    
    /*
     * Solution 2: Without Sorting
     * Average Complexity = O(n ^ 2)
     * Best Case = O(n)
    private int getNumPairs(int[] array, int threshold) {
        if (array == null || array.length < 2) return 0;
        
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        if (array[maxIndex] * 2 < threshold) return 0;
        
        int count = 0;
        int newPivot = partitionThreshold(array, 0, array.length - 1, threshold);
        while (newPivot >= 1) {
            count += newPivot;
            newPivot = partitionThreshold(array, 0, newPivot - 1, threshold);
        }
        
        return count;
    }
    
    private int partitionThreshold(int[] array, int start, int end, int threshold) {
        if (start == end) return 0;
        
        int index = start;
        int minIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        int minimum = array[minIndex];
        swap(array, minIndex, end);
        
        for (int i = start; i <= end; i++) {
            if (array[i] + minimum <= threshold) {
                swap(array, index++, i);
            }
        }
        
        return index - 1;
    }
    
    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    */
    
    @Override
    protected void initialize() {
        array = new int[SIZE];
        
        HashSet<Integer> set = new HashSet<Integer>();
        while (set.size() < 10) {
            set.add((int) (Math.random() * MAXIMUM));
        }
        
        int index = 0;
        for (int n : set) {
            array[index++] = n;
        }
        
        threshold = (int) (Math.random() * MAXIMUM);;
    }

    @Override
    protected void runExercise() {
        nPairs = getNumPairs(array, threshold);        
    }
    
    @Override
    protected boolean test() {
        System.out.print("A = { ");
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.printf("},%nTHRESHOLD = %d.%nThere are %d pairs whose sum is smaller than THRESHOLD%n", threshold, nPairs);

        return true;
    }
}
