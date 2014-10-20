package com.cllin.algorithms;

import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given an array of dominoes, find if there exists a 6-6 pair.
 * On a domino, there are two random numbers ranged from 0 to 6 (inclusive).
 * 
 * Definition of 6-6 Pair: A pair of dominoes whose sum of each pair of numbers is 6
 * 
 * For example, 
 *         1) A domino of (2, 4) is a 6-6 pair with (4, 2) - 2 and 4, 4 and 2
 *         2) A domino of (5, 3) is a 6-6 pair with (1, 3) - 5 and 1, 3 and 3
 * 
 * Note that the left side and the right side of the domino is reversible.
 * For example, a domino of (2, 4) can also be viewed as (4, 2)
 */

public class SixSixPair extends Exercise {

    private final int SIZE = 100;
    private Domino[] dominoes;
    
    private HashSet<Domino> hasSixSixPair(Domino[] array) {
        HashMap<Integer, Domino> dominoes = new HashMap<Integer, Domino>();
        HashSet<Domino> pair = new HashSet<Domino>();
        
        for (Domino domino : array) {
            int left = domino.left;
            int right = domino.right;
            
            if (dominoes.containsKey((6 - left) * 10 + (6 - right))) {
                pair.add(domino);
                pair.add(dominoes.get((6 - left) * 10 + (6 - right)));
                return pair;
            }
            
            if (dominoes.containsKey((6 - right) * 10 + (6 - left))) {
                pair.add(domino);
                pair.add(dominoes.get((6 - right) * 10 + (6 - left)));
                return pair;
            }
            
            dominoes.put(left * 10 + right, domino);
        }
        
        return pair;
    }
    
    private class Domino {
        int left;
        int right;

        Domino(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    @Override
    protected void initialize() {
        dominoes = new Domino[SIZE];
        for (int i = 0; i < SIZE; i++) {
            int left = (int) (Math.random() * 7);
            int right = (int) (Math.random() * 7);
            
            dominoes[i] = new Domino(left, right);
        }
    }

    @Override
    protected void runExercise() {
        HashSet<Domino> pair = hasSixSixPair(dominoes);
        if (pair.isEmpty()) {
            System.out.println("The array does not have any 6-6 pairs");
        } else {
            System.out.println("The array has at least one 6-6 pair:");

            for (Domino domino : pair) {
                System.out.printf("(%d, %d)%n", domino.left, domino.right);
            }
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
