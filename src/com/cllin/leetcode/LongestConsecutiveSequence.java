package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Source: http://oj.leetcode.com/problems/longest-consecutive-sequence/
 */

public class LongestConsecutiveSequence extends LeetCodeExercise {
    
    private final int[][] testSuite = {
            new int[]{0},
            new int[]{100, 4, 200, 1, 3, 2},
            new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645},
            new int[]{-3, -9, -3, 4, -3, -9, -3, -6, 8, -3, 0, 1, 5, -1, -4, 0, -7, 1, 5}
    };
    private int index;
    private int result;

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            result = longestConsecutive(testSuite[index]);
            test();
        }

    }
    
    private static int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        
        int maximum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
            
            set.add(num[i]);
            keys.add(num[i]);
        }
        
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            int left = key;
            int right = key;
            
            while (set.contains(--left)) {
                set.remove(left);
                keys.remove(keys.indexOf(left));
            }
            
            while (set.contains(++right)) {
                set.remove(right);
                keys.remove(keys.indexOf(right));
            }
            
            maximum = Math.max(maximum, right - left - 1);
        }
        
        return maximum;
    }
    
    @Override
    public boolean test() {
        System.out.print("A = { ");
        for (int n : testSuite[index]) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}%n");
        
        System.out.printf("The length of the longest consecutive sequence is %d%n", result);
        return false;
    }

}
