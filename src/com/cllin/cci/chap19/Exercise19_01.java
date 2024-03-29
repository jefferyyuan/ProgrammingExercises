package com.cllin.cci.chap19;

import com.cllin.main.Exercise;

/*
 * Write a function to swap a number in place without temporary variables.
 */

public class Exercise19_01 extends Exercise {
    private static final int MAXIMUM = 100;
    
    private class Pair {
        public int a = 0;
        public int b = 0;
        public Pair() {
            a = (int) (Math.random() * MAXIMUM);
            b = (int) (Math.random() * MAXIMUM);
        }
        
        public void swap() {
            a = b - a;
            b = b - a;
            a = a + b;
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < 10; i++) {
            Pair pair = new Pair();
            int a_buf = pair.a;
            int b_buf = pair.b;

            pair.swap();

            if (a_buf != pair.b || b_buf != pair.a) {
                System.out.println("Failed");
                return;
            }
        }
        System.out.println("Success!");
    }

    @Override
    protected boolean test() {
        return true;
    }
}
