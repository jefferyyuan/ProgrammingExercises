package com.cllin.cci.chap03;

import java.util.LinkedList;
import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class Exercise03_05 extends Exercise {
    private final int MAXIMUM = 1000;
    private final int SIZE = 1000;
    
    private LinkedList<Integer> reference;
    private MyQueue myQueue;
    
    private class MyQueue {
        Stack<Integer> stackA;
        Stack<Integer> stackB;
        
        public MyQueue() {
            stackA = new Stack<Integer>();
            stackB = new Stack<Integer>();
        }
        
        public void add(int element) {
            stackA.push(element);
        }
        
        public int remove() {
            pourAToB();
            int element = stackB.pop();
            pourBToA();
            return element;
        }
        
        public int peek() {
            pourAToB();
            int element = stackB.peek();
            pourBToA();
            return element;
        }
        
        public int size() {
            return stackA.size();
        }
        
        public boolean isEmpty() {
            return stackA.isEmpty();
        }
        
        private void pourAToB() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        
        private void pourBToA() {
            while (!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
        }
    }

    @Override
    protected void initialize() {
        myQueue = new MyQueue();
        reference = new LinkedList<Integer>();
        
        for (int i = 0; i < SIZE; i++) {
            int n = (int) (Math.random() * MAXIMUM);
            
            myQueue.add(n);
            reference.add(n);
        }    
    }

    @Override
    protected void runExercise() {
    return;
    }

    @Override
    protected boolean test() {
        if (myQueue.size() != reference.size()) {
            System.out.println("Failed");
            return false;
        }
        
        while (!myQueue.isEmpty()) {
            if (myQueue.peek() != reference.peek() || myQueue.remove() != reference.poll()) {
                System.out.println("Failed");
                return false;
            }
        }
        
        System.out.println("Success!");
        return true;
    }
}
