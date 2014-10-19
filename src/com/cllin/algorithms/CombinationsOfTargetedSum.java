package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists.
 * Exclude the N + 0 = N 
 * 
 * For example, N = 4,
 * return {{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}}
 * 
 * Source: http://www.careercup.com/question?id=5678435150069760
 */

public class CombinationsOfTargetedSum extends Exercise {

    private int N;
    private ArrayList<ArrayList<Integer>> combinations;
    
    private ArrayList<ArrayList<Integer>> getCombinations(int n) {
        if (n < 2) return new ArrayList<ArrayList<Integer>>();
        
        HashSet<ArrayList<Integer>> queue = new HashSet<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> next = new HashSet<ArrayList<Integer>>();
        
        ArrayList<Integer> initialState = new ArrayList<Integer>();
        initialState.add(1);
        initialState.add(1);
        queue.add(initialState);
        
        for (int i = 2; i < n; i++) {
            for (ArrayList<Integer> combination : queue) {
                ArrayList<Integer> naiveCombination = new ArrayList<Integer>(combination);
                naiveCombination.add(0, 1);
                next.add(naiveCombination);
                
                for (Integer integer : combination) {
                    ArrayList<Integer> extendedCombination = new ArrayList<Integer>(combination);
                    extendedCombination.remove(integer);
                    extendedCombination.add(integer + 1);
                    next.add(extendedCombination);
                }
            }
            
            queue = next;
            next = new HashSet<ArrayList<Integer>>();
            
        }
        
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> combination : queue) {
            Collections.sort(combination);
            combinations.add(combination);
        }
        
        return combinations;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (N = 2; N <= 10; N++) {
            combinations = getCombinations(N);

            System.out.printf("N = %d%n", N);
            for (ArrayList<Integer> combination : combinations) {
                System.out.print("{ ");
                for (Integer n : combination) {
                    System.out.printf("%d ", n);
                }
                System.out.printf("}%n");
            }

            System.out.println("------------------------------");
        }
    }

    @Override
    protected void test() {
        return;
    }

}
