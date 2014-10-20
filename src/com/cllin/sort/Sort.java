package com.cllin.sort;

import java.util.Arrays;

import com.cllin.main.Exercise;

public class Sort extends Exercise {
    private final int MAXIMUM = 10;
    protected final int SIZE = 10;
    protected int[] numbers = new int[SIZE];
    private int[] reference = new int[SIZE];
    
    protected void printArray() {
        System.out.println("The array is:");
        System.out.print("\t");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", numbers[i]);
        }
        System.out.println();
    }

    protected void sort() {
        // will be overriden
    }

    @Override
    protected void initialize() {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int n = (int) (Math.random() * MAXIMUM);
            numbers[i] = n;
            reference[i] = n;
        }
        
        Arrays.sort(reference);    
    }

    @Override
    protected void runExercise() {
        long start = System.nanoTime();
        sort();
        long end = System.nanoTime();
        
        test();
        
        System.out.printf("It took %f ms to sort %d integers%n", (float) ((end - start) / 1E6), SIZE);    
    }

    @Override
    protected boolean test() {
        for (int i = 0; i < SIZE; i++) {
            if (numbers[i] != reference[i]) {
                System.out.println("Failed");

                return false;
            }
        }

        System.out.println("The sequence is sorted");
        return true;
    }
}
