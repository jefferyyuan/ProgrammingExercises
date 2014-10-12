package com.cllin.cci.chap09;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. 
 * Write a method to merge B into A in sorted order.
 */

public class Exercise09_01 extends Exercise {

    private final int MAXIMUM = 10000;
    protected final int SIZE_A = 10000;
    protected final int SIZE_ACTUAL_A = 3000;
    protected final int SIZE_B = 4000;
    protected int[] a = new int[SIZE_A];
    protected int[] b = new int[SIZE_B];
    
    @Override
    public void run() {
        initialize();
        a = merge(a, b, SIZE_ACTUAL_A, SIZE_B);
        check();
    }
    
    private void check() {
        int size = SIZE_ACTUAL_A + SIZE_B;
        for (int i = 1; i < size; i++) {
            if(a[i] < a[i - 1]){
                System.out.println("Failed");
                return;
            }
        }
        
        for (int i = size; i < SIZE_A; i++) {
            if (a[i] != 0) {
                System.out.println("Failed");
                return;
            }
        }
        System.out.println("Success!");
    }
    
    private int[] merge(int[] a, int[] b, int sizeA, int sizeB) {
        int i = sizeA - 1;
        int j = sizeB - 1;
        int idx = i + j + 1;
        
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[idx--] = a[i--];
            } else {
                a[idx--] = b[j--];
            }
        }
        
        while (j >= 0) {
            a[idx--] = b[j--];
            idx--;
            j--;
        }
        
        return a;
    }
    
    protected void initialize() {
        Arrays.fill(a, 0);
        
        for (int i = 0; i < SIZE_ACTUAL_A; i++) {
            a[i] = (int) (Math.random() * MAXIMUM);
        }
        
        for (int i = 0; i < SIZE_B; i++) {
            b[i] = (int) (Math.random() * MAXIMUM);
        }
        
        Arrays.sort(a, 0, SIZE_ACTUAL_A);
        Arrays.sort(b);
    }
}
