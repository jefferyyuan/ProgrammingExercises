package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a method that returns integer between 0 to 4 (inclusively) in uniform distribution, 
 * return integer between 0 to 6 (inclusively) in uniform distribution.
 */

public class RandomSeven extends Exercise {

    private static int random7() {
        int c = Integer.MAX_VALUE;
        while (c >= 21) {
            int a = random5();
            int b = random5();

            c = a * 5 + b;
        }

        return c % 7;
    }

    private static int random5() {
        return (int) (Math.random() * 5);
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        final int size = 100000;
        
        int[] counts = new int[7];
        Arrays.fill(counts, 0);
        
        for (int i = 0; i < size; i++) {
            int n = random7();
            
            assert(n >= 0 && n <= 6);
            
            counts[n]++;
        }
        
        for (int i = 0; i < 7; i++) {
            System.out.printf("P(%d) = %f%n", i, ((double) counts[i] / (double) size));
        }
    }

    @Override
    protected void test() {
        return;
    }
}
