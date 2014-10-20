package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * Source: http://oj.leetcode.com/problems/subsets/
 */

public class Subsets extends Exercise {
    private final int[][] testSuite = {
            {}, 
            {1}, 
            {1, 2, 3}, 
            {1, 2, 3, 4}, 
            {4, 1, 0}};
    
    private int index;
    private ArrayList<ArrayList<Integer>> result;

    @Override
    public void initialize() {
        result = new ArrayList<ArrayList<Integer>>();
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    /*
     * Classic BFS, build the next level based on the previous level.
     * Note that it is restricted that elements should be in non-descending order. 
     */
    private ArrayList<ArrayList<Integer>> subsets(int[] set) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        if (set == null || set.length == 0) return subsets;
        Arrays.sort(set);

        LinkedList<ArrayList<Integer>> thisLevel = new LinkedList<ArrayList<Integer>>();
        LinkedList<ArrayList<Integer>> nextLevel = new LinkedList<ArrayList<Integer>>();
        
        ArrayList<Integer> initial = new ArrayList<Integer>();
        thisLevel.add(initial);
        
        while (!thisLevel.isEmpty()) {
            while (!thisLevel.isEmpty()) {
                ArrayList<Integer> subset = thisLevel.poll();
                
                // Get the maximum value of the previous level
                int lastMax = Integer.MIN_VALUE;
                for (int p = 0; p < subset.size(); p++) {
                    lastMax = Math.max(lastMax, subset.get(p));
                }
                
                // Build a new subset by adding one new element.
                // New elements should be larger than the maximum of the
                // previous level
                int index = 0;
                while (index < set.length && set[index] <= lastMax) {
                    index++;
                }
                
                for (int p = index; p < set.length; p++) {
                    ArrayList<Integer> s = new ArrayList<Integer>(subset);
                    s.add(set[p]);
                    nextLevel.add(s);
                    subsets.add(s);
                }
            }
            
            thisLevel = nextLevel;
            nextLevel = new LinkedList<ArrayList<Integer>>();
        }
        
        return subsets;
    }

    @Override
    public boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            result = subsets(testSuite[index]);

            System.out.printf("For the set [ ");
            for (int n : testSuite[index])
                System.out.printf("%d ", n);
            System.out.printf("], the subsets are:%n\t");
            for (ArrayList<Integer> subset : result) {
                int size = subset.size();
                for (int i = 0; i < size; i++)
                    System.out.printf("%d ", subset.get(i));

                System.out.println();
            }
        }

        return false;
    }

}
