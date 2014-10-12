package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given an array of positive and negative numbers, find if there is a subarray whose sum is k.
 * 
 * Examples:
 *         Input: {4, 2, -3, 1, 6}, k = 0
 *         Output: true
 * There is a subarray with zero sum from index 1 to 3.
 * 
 *         Input: {4, 2, 0, 1, 6}, k = 0
 *         Output: true
 * There is a subarray with zero sum from index 2 to 2.
 * 
 *         Input: {-3, 2, 3, 1, 6}, k = 0
 *         Output: false
 * There is no subarray with zero sum.
 * 
 * Source: http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 */

public class SubarraySum extends Exercise {

    private int[][] testSuite = {
            {4, 2, -3, 1, 6},
            {4, 2, -3, 1, 6},
            {-3, 2, 3, 1, 6}
    };
    
    private int index;
    private int target;
    private ArrayList<Integer> result;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            for (target = 0; target <= 5; target++) {
                result = hasSum(testSuite[index], target);
                test();
            }
        }
    }
    
    private ArrayList<Integer> hasSum(int[] array, int target) {
        int sum = 0;
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sums.containsKey(sum - target) || array[i] == target) {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                int start = (array[i] == target)? i : sums.get(sum - target) + 1;
                int end = i;
                indices.add(start);
                indices.add(end);
                return indices;
            }
            
            sums.put(sum, i);
        }
        
        return new ArrayList<Integer>();
    }
    
    protected void test() {
        System.out.print("A = { ");
        for (int n : testSuite[index]) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}%n");
        
        System.out.printf("T = %d%n", target);
        
        if (result.size() == 0) {
            System.out.println("No matching subarray");
            System.out.println("------------------------------");
            return;
        }
        
        int start = result.get(0);
        int end = result.get(1);
        System.out.print("S = { ");
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", testSuite[index][i]);
        }
        System.out.printf("}%n");
        System.out.println("------------------------------");
    }

}
