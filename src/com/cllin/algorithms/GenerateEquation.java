package com.cllin.algorithms;

import java.util.PriorityQueue;

import com.cllin.main.Exercise;

/*
 * Given an equation in the form 2^i * 3^j * 5^k * 7^l where i,j,k,l >=0 are integers. 
 * Write a program to generate numbers from that equation in sorted order efficiently. 
 * 
 * Return the n-th element of the sequence.
 * 
 * Source: http://www.careercup.com/question?id=23823662
 */

public class GenerateEquation extends Exercise {

    private int generateEquation(int n) {
        int value = 1;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        int count = 1;
        heap.add(value);
        while (count <= n) {
            value = heap.poll();
            
            if (count == n) break;
            
            heap.add(value * 2);
            heap.add(value * 3);
            heap.add(value * 5);
            heap.add(value * 7);
            
            count++;
        }
        
        return value;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int n = 1; n < 15; n++) {
            System.out.printf("The %dth element of the sequence is %d%n", n, generateEquation(n));
        }
    }

    @Override
    protected void test() {
        return;
    }
}
