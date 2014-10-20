package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a non-negative integer T and an array of integer A containing random integers.
 * Find all pairs from A whose difference is T.
 * 
 * For example:
 * T = 4
 * A = {1, 1, 5, 6, 9, 16, 27}
 * 
 * S = {{1, 5}, {1, 5}, {5, 9}}
 */

public class DifferenceOfPairs extends Exercise {

    private final int SIZE = 10;
    private final int MAXIMUM = 10;
    
    private int target;
    private int[] array;
    private ArrayList<ArrayList<Integer>> pairs;
    
    private ArrayList<ArrayList<Integer>> getPairs(int[] array, int target) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
        if (array == null || array.length <= 1) return pairs;
        
        Arrays.sort(array);
        
        HashMap<Integer, LinkedList<Integer>> indices = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            
            if (indices.containsKey(n - target)) {
                for (int index : indices.get(n - target)) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(index);
                    pair.add(i);
                    pairs.add(pair);
                }
            } 
            
            if (indices.containsKey(n + target)) {
                for (int index : indices.get(n + target)) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(index);
                    pair.add(i);
                    pairs.add(pair);
                }
            }
            
            LinkedList<Integer> index = (indices.containsKey(n))? indices.get(n) : new LinkedList<Integer>();
            index.add(i);
            indices.put(n, index);
        }
        
        return pairs;
    }
    
    @Override
    protected void initialize() {
        array = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * MAXIMUM);
        }

        target = (int) (Math.random() * MAXIMUM);
    }

    @Override
    protected void runExercise() {
        pairs = getPairs(array, target);
    }

    @Override
    protected boolean test() {
        System.out.print("A = { ");
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}, T = %d%n", target);
        
        System.out.print("Pairs = { ");
        for (ArrayList<Integer> pair : pairs) {
            System.out.print("{ ");
            
            for (int index : pair) {
                System.out.printf("%d ", array[index]);
            }
            
            System.out.print("} ");
        }
        System.out.print("}\n");
        System.out.println("------------------------------");
        return true;
    }
}
