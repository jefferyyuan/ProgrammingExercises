package com.cllin.leetcode;

import java.util.Stack;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * Source: http://oj.leetcode.com/problems/maximal-rectangle/
 */

public class MaximalRectangle extends LeetCodeExercise {

    private char[][][] testSuite = {
            {{'1'}},
            {{'1', '0'}},
            {{'0', '1'}},
            {{'1', '1'}},
            {{'1', '1'}, {'1', '1'}},
            {{'1', '1'}, {'1', '0'}},
            {{'0', '1', '1', '0', '1'}, {'1', '1', '0', '1', '0'}, 
                {'0', '1', '1' ,'1', '0'}, {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}},
            {{'0', '0', '0', '0', '1', '1', '1', '0', '1'},
                    {'0', '0', '1', '1', '1', '1', '1', '0', '1'},
                    {'0', '0', '0', '1', '1', '1', '1', '1', '0'}}
    };
    
    private int index;
    private int maximum;    
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            maximum = maximalRectangle(testSuite[index]);
            test();
        }
    }
    
    private int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int maximum = 0;
        int[] histogram = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
//            Build histogram
            for (int j = 0; j < matrix[0].length; j++) {
                histogram[j] = (matrix[i][j] == '1')? histogram[j] + 1 : 0;
            }
            
//            Applied the same thing in "Largest Rectangle In Histogram"
            maximum = Math.max(maximum, getMaximum(histogram));
        }

        return maximum;
    }
    
    private int getMaximum(int[] histogram) {
        int maximum = 0;
        Stack<Integer> maximals = new Stack<Integer>();
        
        int p = 0;
        while (p < histogram.length) {
            if (maximals.isEmpty() || histogram[p] >= histogram[maximals.peek()]) {
                maximals.push(p++);
            } else {
                if (maximals.isEmpty()) continue;
                
                int lastMaximal = maximals.pop();
                
                int height = histogram[lastMaximal];
                int width = (maximals.isEmpty())? p : (p - maximals.peek() - 1);
                
                maximum = Math.max(maximum, height * width);
            }
        }
        
        while (!maximals.isEmpty()) {
            int lastMaximal = maximals.pop();
            
            int height = histogram[lastMaximal];
            int width = (maximals.isEmpty())? p : (p - maximals.peek() - 1);
            maximum = Math.max(maximum, height * width);
        }
        
        return maximum;
    }

    @Override
    public boolean test() {
        System.out.printf("The area of the maximum rectangle of the below grid is %d%n", maximum);
        
        for (int i = 0; i < testSuite[index].length; i++) {
            for (int j = 0; j < testSuite[index][0].length; j++) {
                System.out.printf("%c ", testSuite[index][i][j]);
            }
            System.out.println();
        }
        
        System.out.println("------------------");
        
        return true;
    }

}
