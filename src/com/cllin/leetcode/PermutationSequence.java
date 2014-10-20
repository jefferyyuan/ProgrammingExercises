package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (i.e., for n = 3):
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 * 
 * Given n and k, return the k-th permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * Source: http://oj.leetcode.com/problems/permutation-sequence/
 */

public class PermutationSequence extends Exercise {

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void runExercise() {
        for (int n = 1; n <= 5; n++) {
            int factorial = getFactorial(n);
            
            for (int k = 1; k <= factorial; k++) {
                String permutation = getPermutation(n, k);
                System.out.printf("The %dth permutation of %d is %s%n", k, n, permutation);
            }
            
            System.out.println("------------------");
        }
    }
    
    private String getPermutation(int n, int k) {
        if (n < 0 || getFactorial(n) < k) return new String();
        
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) candidates.add(i);
        
        return permute(candidates, k);
    }
    
    private String permute(ArrayList<Integer> candidates, int k) {
        if (candidates == null || candidates.size() == 0) return new String();
        
        int n = candidates.size();
        int factorial = getFactorial(n - 1);
        
        int firstNumberIdx = (k - 1) / factorial;
        int firstNumber = candidates.get(firstNumberIdx);
        candidates.remove(firstNumberIdx);
        
        int order = (k % factorial == 0)? factorial : k % factorial;
        
        return firstNumber + permute(candidates, order);
    }
    
    private int getFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
