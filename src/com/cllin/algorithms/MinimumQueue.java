package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Implement a queue in which push_rear(), pop_front() and get_min() are all constant time operations.
 * 
 * http://www.careercup.com/question?id=7263132
 */

public class MinimumQueue extends Exercise {

    private int[][] testSuite = new int[][]{
            new int[]{4, 5, 1, 2}
    };
    
    @Override
    public void run() {
        for (int[] test : testSuite) {
            Queue queue = new Queue();
            
            for (int i = 0; i < test.length; i++) {
                queue.push(test[i]);
            }
            
            for (int i = 0; i < test.length; i++) {
                queue.pop();
            }
        }
    }

    private class Queue {
        LinkedList<Integer> queue;
        LinkedList<Integer> minimum;
        
        Queue() {
            queue = new LinkedList<Integer>();
            minimum = new LinkedList<Integer>();
        }
        
        private void push(int value) {
            while (!minimum.isEmpty() && minimum.peekLast() > value) {
                minimum.pollLast();
            }
            minimum.add(value);
            queue.add(value);
            
            this.printQueue("PUSH");
        }
        
        private int pop() {
            int value = -1;
            if (queue.isEmpty()) return value;
            
            value = queue.pollFirst().intValue();
            if (minimum.peek().intValue() == value) {
                minimum.pollFirst();
            }
            
            this.printQueue("POP");
            return value;
        }
        
        private int getMinimum() {
            return (minimum.isEmpty())? -1 : minimum.peek();
        }
        
        private void printQueue(String string) {
            System.out.printf("%s, Q = { ", string);
            for (int n : queue) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}, Minimum = %d%n", this.getMinimum());
        }
    }
}
