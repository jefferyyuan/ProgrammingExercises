package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2, 3, 1, 1, 4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Source: http://oj.leetcode.com/problems/jump-game-ii/
 */

public class JumpGameII implements LeetCodeExercise {

    private final int[][] testSuite = {
            {2, 3, 1, 1, 4}, 
            {0}, 
            {1},
            {2, 1},
            {1, 2, 0, 1},
            {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1}
    };
    
    private int index;
    private int numMinimumJumps;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            numMinimumJumps = jump(testSuite[index]);
            test();
        }
    }
    
    /*
     * S(i) = Minimum steps to get to i
     * For p = 1 to A[i], S(i + p) = Min(S(i + p), S(i) + 1)
     */
    private int jump(int[] array) {
        if (array == null || array.length <= 1) return 0;
        if (array[0] == 0) return -1;
        
        int steps = 0;
        int last = 0;
        int reachable = 0;
        int length = array.length;
        
        for (int i = 0; i < length; i++) {
            if (i > last) {
                if (reachable == last && last < length - 1) return -1;
                
                last = reachable;
                steps++;
            }
            
            reachable = Math.max(reachable, i + array[i]);
        }
        
        return steps;
    }

    @Override
    public boolean test() {
        System.out.print("For the array { ");
        for (int num : testSuite[index]) System.out.printf("%d ", num);
        
        System.out.printf("}, it takes at least %d jumps to finish%n", numMinimumJumps);
        return true;
    }

}
