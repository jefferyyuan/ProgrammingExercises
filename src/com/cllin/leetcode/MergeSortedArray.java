package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * Source: http://oj.leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray extends LeetCodeExercise {
    private final int MAXIMUM = 100;
    private final int SIZE = 100;
    private final int SIZE_A = 50;
    private final int SIZE_B = 30;
    
    private int[] arrayA;
    private int[] arrayB;
    private int[] reference;
    
    @Override
    public void initialize() {
        arrayA = new int[SIZE];
        arrayB = new int[SIZE_B];
        reference = new int[SIZE_A + SIZE_B];
        
        Arrays.fill(arrayA, 2147483647);

        for (int i = 0; i < SIZE_A; i++) {
            int value = (int)(Math.random() * MAXIMUM);
            arrayA[i] = value;
            reference[i] = value;
        }
        
        for (int i = 0; i < SIZE_B; i++) {
            int value = (int)(Math.random() * MAXIMUM);
            arrayB[i] = value;
            reference[i + SIZE_A] = value;
        }
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Arrays.sort(reference);
    }

    @Override
    public void run() {
        initialize();
        
        merge(arrayA, SIZE_A, arrayB, SIZE_B);
        
        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }
    
    /*
     * Start copying the elements from the end
     * 1) If A[i] > B[j], A[position] = A[i]. Then move i and position left by 1
     * 2) If A[i] < B[j], A[position] = B[j]. Then move j and position left by 1
     * 
     * When one of i and j is smaller than 0
     * 1) i < 0, all elements from A are copied, copy the rest of B
     * 2) j < 0, all elements from B are copied, copy the rest of A, which is already there, so no need for copying
     */
    private void merge(int A[], int m, int B[], int n) {
        if (A.length == 0 || B.length == 0) return;
        
        int i = m - 1;
        int j = n - 1;
        int position = m + n - 1; 

        while (i >= 0 && j >= 0) {
            if (j < 0 || A[i] > B[j]) {
                A[position] = A[i--];
            } else {
                A[position] = B[j--];
            }
            
            position--;
        }
        
        while (j >= 0) {
            A[position--] = B[j--];
        }
    }

    @Override
    public boolean test() {
        int length = arrayA.length;
        int validLength = SIZE_A + SIZE_B;
        
        for (int i = 0; i < validLength; i++) {
            if (arrayA[i] != reference[i]) {
                return false;
            }
        }
        
        for (int i = validLength; i < length; i++) {
            if (arrayA[i] != 2147483647) {
                return false;
            }
        }
        
        
        return true;
    }

}
