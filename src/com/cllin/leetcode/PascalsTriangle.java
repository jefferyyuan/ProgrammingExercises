package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 *     [
 *          [1],
 *         [1,1],
 *        [1,2,1],
 *       [1,3,3,1],
 *      [1,4,6,4,1]
 *     ]
 * 
 * Source: http://oj.leetcode.com/problems/pascals-triangle/
 */

public class PascalsTriangle extends LeetCodeExercise {
    private final int SIZE = 5;
    
    private ArrayList<ArrayList<Integer>> result;

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        result = generate(SIZE);
        
        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }
    
    private ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) array.add(1);
                else array.add(output.get(i - 1).get(j - 1) + output.get(i - 1).get(j));
            }
            
            output.add(array);
        }
        
        return output;
    }

    @Override
    public boolean test() {
        int size = result.size();
        for (int i = 0; i < size; i++) {
            int count = 0;
            
            for (int n : result.get(i)) {
                count += n;
            }
            
            if (count != 1 << i) return false;
        }
        
        return true;
    }
}
