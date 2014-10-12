package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * Source: http://oj.leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition extends LeetCodeExercise {
    private final int MAXIMUM = 10;
    private final int SIZE = 10;
    
    private int[] integers;

    @Override
    public void initialize() {
        integers = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            integers[i] = (int)(Math.random() * MAXIMUM);
        }
        
        Arrays.sort(integers);
    }

    @Override
    public void run() {
        test();
    }
    
    public int searchInsert(int[] A, int target) {
        int position = 0;
        while (position < A.length && target > A[position]) {
            position++;
        }
        
        return position;
    }

    @Override
    public boolean test() {
        for (int i = 0; i < 10; i++) {
            initialize();
            int target = (int)(Math.random() * MAXIMUM);
            int position = searchInsert(integers, target);
            
            for (int n : integers) {
                System.out.printf("%d ", n);
            }
            System.out.println();
            
            
            if (position == integers.length)
                System.out.printf("%d should be insert after %d%n", target, integers[position - 1]);
            else if (position == 0) 
                System.out.printf("%d should be insert before %d%n", target, integers[position]);
            else 
                System.out.printf("%d should be insert after %d and before %d%n", target, integers[position - 1], integers[position]);
            
            System.out.println("------------");
        }
        
        return true;
    }

}
