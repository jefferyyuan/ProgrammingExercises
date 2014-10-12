package com.cllin.sort;

import java.util.Arrays;

/*
 * Average case performance            :O(n)
 * Worst case space complexity        :O(n)
 */

public class CountingSort extends Sort {
    protected void sort() {
        countingSort(numbers);
    }

//    The array is guaranteed to be non-negative
    private void countingSort(int[] array) {
        int max = getMaximum(array);
        int length = array.length;
        
        int[] counts = new int[max + 1];
        int[] sorted = new int[length];
        
        Arrays.fill(counts, 0);
        
        for (int i = 0; i < length; i++) {
            counts[array[i]]++;
        }
        
        for (int i = 1; i <= max; i++) {
            counts[i] += counts[i - 1];
        }
        
        for(int i = length - 1; i >= 0; i--){
            sorted[counts[array[i]] - 1] = array[i];
            counts[array[i]]--;
        }
        
        array = sorted;
    }
    
    private int getMaximum(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
