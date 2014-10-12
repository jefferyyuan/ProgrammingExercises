package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given the array of digits (0 is also allowed), 
 * what is the minimal sum of two integers that are made of the digits contained in the array?
 * 
 * For example, array: 1 2 7 8 9. The minimum sum (179 + 28) should be 207.
 * 
 * Source: http://www.careercup.com/question?id=5678435150069760
 */

public class BuildMinimumSum extends Exercise {

    private int LENGTH;
    private int sum;
    private int[] array;
    
    @Override
    public void run() {
        for (LENGTH = 2; LENGTH <= 10; LENGTH++) {
            initialize();
            sum = getMinimumSum(array);
            test();
        }
    }
    
    private int getMinimumSum(int[] array) {
        Arrays.sort(array);
        
        int a = 0;
        int b = 0;
        int index = 0;
        while (index + 1 < array.length) {
            a = a * 10 + array[index];
            b = b * 10 + array[index + 1];
            index += 2;
        }
        
        if (index < array.length) a = a * 10 + array[index];
        
        return a + b;
    }
    
    protected void test() {
        System.out.print("A = { ");
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}%n");
        
        System.out.printf("Minimum Sum = %d%n", sum);
        System.out.println("------------------------------");
    }

    protected void initialize() {
        array = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            array[i] = (int) (Math.random() * 10);
        }
    }
}
