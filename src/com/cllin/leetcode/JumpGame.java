package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * Source: http://oj.leetcode.com/problems/jump-game/
 */

public class JumpGame extends LeetCodeExercise {
    private final int[][] testSuite = {
            {2, 3, 1, 1, 4},
            {3, 2, 1, 0, 4},
            {2, 0}, 
            {0}
    };
    
    private int index;
    private boolean result;

    @Override
    public void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            result = canJump(testSuite[index]);
            test();
        }
    }
    
    private boolean canJump(int[] array) {
        int length = array.length;
        if (length == 0) return false;
        
        int maximumReachable = 0;
        for (int start = 0; start < length && start <= maximumReachable; start++) {
            maximumReachable = Math.max(maximumReachable, start + array[start]);
        }
        
        return maximumReachable >= length - 1;
    }

    @Override
    public boolean test() {
        int[] array = testSuite[index];
        
        System.out.print("For this array: {");
        for (int i = 0; i < array.length; i++) System.out.printf(" %d", array[i]);
        if (result) System.out.print(" }, it is possible to finish to jump game\n");
        else System.out.print(" }, it is impossible to finish to jump game\n");
        
        return false;
    }

}
