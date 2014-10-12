package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * http://oj.leetcode.com/problems/pascals-triangle-ii/
 */

public class PascalsTriangleII extends LeetCodeExercise {
    private ArrayList<Integer> result;
    private int rowIndex;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (int i = 0; i <= 15; i++) {
            rowIndex = i;
            result = getRow(rowIndex);
            
            if (test()) System.out.println("Success");
            else System.out.println("Failed");    
        }
        
    }
    
//    Binomial expansion
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        long combination = 1;
        int bound = rowIndex / 2;
        for (int i = 0; i <= bound; i++) {
            result.add((int) combination);
            combination = combination * (rowIndex - i) / (i + 1);
        }

        if (rowIndex == 0) return result;
        
        if (rowIndex % 2 == 0) bound--;
        for (int i = bound; i >= 0; i--) result.add(result.get(i));
        
        return result;
    }

    @Override
    public boolean test() {
        int count = 0;
        for (Integer i : result) {
            count += i.intValue();
        }
        
        return (count == (int) Math.pow(2, rowIndex));
    }
}
