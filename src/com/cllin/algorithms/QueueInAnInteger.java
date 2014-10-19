package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * How to implement a queue using one integer, it should store value 0 to 9.
 * 
 * Source: http://www.careercup.com/question?id=310680
 */

public class QueueInAnInteger extends Exercise {

    // Use -1 to mark a poll
    private final int[][] testSuite = new int[][]{
            new int[]{0, 0, 8, 2, -1, 4, 1}
    };
    
    private int integerQueue = 1;

    private void push(int value) {
        integerQueue *= 10;
        integerQueue += value;
    }
    
    private int poll() {
        int size = size();
        if (size == 0) return -1;
        
        int value = (integerQueue % (int) Math.pow(10, size)) / (int) Math.pow(10, size - 1);
        int newValue = integerQueue % (int) Math.pow(10, size - 1);
        
        integerQueue = newValue + (int) Math.pow(10, size - 1);
        
        return value;
    }
    
    private int size() {
        int size = 0;
        int queue = integerQueue;
        while (queue > 1) {
            queue /= 10;
            size++;
        }
        return size;
    }
    
    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected void test() {
        for (int[] test : testSuite) {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            for (int n : test) {
                if (n == -1) {
                    poll();
                    queue.poll();
                } else {
                    push(n);
                    queue.add(n);
                }
            }

            boolean isSuccess = true;
            while (!queue.isEmpty()) {
                int a = poll();
                int b = queue.pollFirst();

                if (a != b) {
                    isSuccess = false;
                    break;
                }
            }

            System.out.printf("%s%n", (isSuccess) ? "Success" : "Failed");
        }
    }
}
