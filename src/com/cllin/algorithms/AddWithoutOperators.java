package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Write a function that adds two numbers. You should not use + or any arithmetic operators.
 */

public class AddWithoutOperators extends Exercise {

    private static final int MAXIMUM = 1000000; 
    
    private static int add(int a, int b) {
        if (b == 0)
            return a;

        int withoutCarry = a ^ b;
        int carry = (a & b) << 1;

        return add(withoutCarry, carry);
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * MAXIMUM);
            int b = (int) (Math.random() * MAXIMUM);
            
            int c = add(a, b);
            if (c != a + b) {
                System.out.println("Failed");
                return;
            }
        }
        
        System.out.println("Success!");
    }

    @Override
    protected void test() {
        return;
    }
}
