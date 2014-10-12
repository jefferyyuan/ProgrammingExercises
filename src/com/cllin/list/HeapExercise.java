package com.cllin.list;

import java.util.PriorityQueue;

import com.cllin.main.Exercise;

public class HeapExercise extends Exercise {

    private final int MAXIMUM = 100;
    private final int SIZE = 20;

    private PriorityQueue<Integer> heap;
    private int[] reference;

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        heap = new PriorityQueue<Integer>();
        reference = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            int n = (int) (Math.random() * MAXIMUM);
            
            heap.add(n);
            reference[i] = n;
        }

        System.out.print("Reference = { ");
        for (int n : reference) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}%n");
        
        System.out.print("Heap = { ");
        while (!heap.isEmpty()) {
            System.out.printf("%d ", heap.poll());
        }
        System.out.printf("}%n");    
    }

    @Override
    protected void test() {
    return;
    }

    /*
     * ------------------------------
     * Notes
     * ------------------------------
     * Java's implementation of Heap provides:
     *         1) O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add).
     *         2) Linear time for the remove(Object) and contains(Object) methods
     *         3) Constant time for the retrieval methods (peek, element, and size).
     */
}
