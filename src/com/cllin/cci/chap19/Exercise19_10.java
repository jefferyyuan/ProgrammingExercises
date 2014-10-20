package com.cllin.cci.chap19;

import com.cllin.main.Exercise;

/*
 * Write a method to generate a random number between 1 and 7, 
 * given a method that generates a random number between 1 and 5 (i.e., implement rand7() using rand5()).
 */

public class Exercise19_10 extends Exercise {

    private static int rand7() {
        int c = Integer.MAX_VALUE;
        
        while (c >= 21) {
            int a = rand5() - 1;
            int b = rand5() - 1;
            c = 5 * a + b;
        }
        
        return c % 7 + 1;
    }
    
    private static int rand5() {
        return (int) (Math.random() * 5) + 1;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        final int size = 10000;
        int[] counts = new int[7];

        for (int i = 0; i < size; i++) {
            counts[rand7() - 1]++;
        }

        for (int i = 0; i < 7; i++) {
            System.out.printf("P(%d) = %f%n", i + 1, (double) counts[i]
                    / (double) size);
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
