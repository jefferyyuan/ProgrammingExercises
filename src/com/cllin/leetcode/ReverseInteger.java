package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Reverse digits of an integer.
 * 
 * Example 1: x = 123, return 321
 * Example 2: x = -123, return -321
 * 
 * Source: http://oj.leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger implements LeetCodeExercise {
    private final int MAXIMUM = (1 << 30) - 1 + (1 << 30);
    private final int SIZE = 5;
    
    private int[] integers;
    private int[] results;

    @Override
    public void initialize() {
        integers = new int[SIZE];
        results = new int[SIZE];
        
        Arrays.fill(results, 0);
        
        for(int i = 0; i < SIZE; i++){
            int value = (int)(Math.random() * MAXIMUM) + 1;
            if (Math.random() > 0.5) value *= -1;
            
            integers[i] = value;
        }
    }

    @Override
    public void run() {
        initialize();
        
        for(int i = 0; i < SIZE; i++){
            results[i] = reverse(integers[i]);
            System.out.printf("The reverse of %d is %d%n", integers[i], results[i]);
        } 
        
    }
    
    private int reverse(int x){
        if (x == 0) return 0;
        
        int result = 0;
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        
        while (x > 0) {
            result *= 10;
            result += (x % 10);
            
            x /= 10;
        }
        
        return (isNegative)? -result : result;
    }

    @Override
    public boolean test() {
        return true;
    }

}
