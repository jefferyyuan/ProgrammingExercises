package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Write a program to determine whether n/2 distinctive pairs can be formed from given n integers. 
 * n is even and each pair's sum is divisible by given k.
 * 
 * Numbers cannot be repeated in the pairs, so you can form total n/2 pairs.
 * 
 * Source: http://www.careercup.com/question?id=14820665
 */

public class SumOfPairs extends Exercise {

    private final int SIZE = 10;
    private final int MAXIMUM = 10;
    
    private int[] array;
    private int k;
    private boolean hasPairs;
    
    private boolean getNumberOfPairs(int[] array, int k) {
        int[] counts = new int[k];
        for (int i = 0; i < array.length; i++) {
            counts[array[i] % k]++;
        }
        
        int count = counts[0] / 2;
        for (int i = 1; i < k / 2; i++) {
            count += Math.min(counts[i], counts[k - i]);
        }
        
        if (k % 2 == 0) count += counts[k / 2] / 2;
        
        return (count == array.length / 2);
    }
    
    @Override
    protected void initialize() {
        array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) (Math.random() * MAXIMUM) + 1;
        }

        k = (int) (Math.random() * MAXIMUM) + 1;
    }

    @Override
    protected void runExercise() {
        hasPairs = getNumberOfPairs(array, k);
    }

    @Override
    protected boolean test() {
        System.out.print("A = { ");
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}, T = %d, A %s form %d pairs whose sum is %d%n", k, (hasPairs)? "can" : "cannot", array.length / 2, k);

        return true;
    }
}
