package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

/*
 * Write a method to generate the nth Fibonacci number.
 */

public class Exercise08_01 extends Exercise {

    private static int getFibonacciNumber(int n){
        if (n == 1 || n == 2) return 1;
        
        int last = 1;
        int lastTwo = 1;
        int number = last + lastTwo; 
        int count = 3;
        while (count < n) {
            lastTwo = last;
            last = number;
            number = last + lastTwo;
            count++;
        }
        
        return number;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int n = 1; n <= 45; n++) {
//          Limited by the size of an integer, can be extended by using a long instead
            int fibonacci = getFibonacciNumber(n);
            System.out.println("The " + n + "th Fibonacci number is " + fibonacci);
        }        
    }

    @Override
    protected boolean test() {
        return true;
    }

}
