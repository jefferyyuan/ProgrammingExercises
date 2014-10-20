package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a collection of numbers, return all possible permutations.
 * For example,
 *         [1,2,3] have the following permutations:
 *         [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Source: http://oj.leetcode.com/problems/permutations/
 */

public class Permutations extends Exercise {
    private final int SIZE = 5;
    private final int MAXIMUM = 5;

    private int[] numbers;
    private ArrayList<ArrayList<Integer>> permutations;
    
    @Override
    public void initialize() {
        numbers = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int)(Math.random() * MAXIMUM);
        }
    }

    @Override
    protected void runExercise() {
        initialize();

        permutations = permute(numbers);
        
        test();
    }
    
    private ArrayList<ArrayList<Integer>> permute(int[] num) {
        int length = num.length;
        
        if (length == 0) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(num);
        return getPermutations(num, 1);
    }
    
    private ArrayList<ArrayList<Integer>> getPermutations(int[] num, int level) {
        int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (level == num.length) {
            for (int i = 0; i < length; i++) {
                if (num[i] == Integer.MIN_VALUE) continue;
                
                ArrayList<Integer> r = new ArrayList<Integer>();
                r.add(num[i]);
                result.add(r);
                return result;
            }
        }
        
        for (int i = 0; i < length; i++) {
            if (num[i] == Integer.MIN_VALUE) continue;
            
            int temp = num[i];
            ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();

            num[i] = Integer.MIN_VALUE;
            
            r = getPermutations(num, level + 1);
            for (ArrayList<Integer> l : r) l.add(temp); 
            
            result.addAll(r);
            num[i] = temp;
        }
        
        return result;
    }

    @Override
    public boolean test() {
        System.out.printf("There are %d permutation for:%n", permutations.size());
        
        for (int n : numbers) System.out.printf("%d ", n);
        System.out.println();
        
        return false;
    }

}
