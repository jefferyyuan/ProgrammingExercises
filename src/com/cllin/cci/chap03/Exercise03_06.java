package com.cllin.cci.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * Write a program to sort a stack in ascending order.
 * You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program: push, pop, peek, isEmpty.
 */

public class Exercise03_06 extends Exercise {
    private final int MAXIMUM = 1000;
    private final int SIZE = 10;
    private Stack<Integer> stack;

    private Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<Integer>();
        
        while (!stack.isEmpty()) {
            int fromOrigin = stack.pop();
            while (!buffer.isEmpty() && buffer.peek() > fromOrigin) {
                stack.push(buffer.pop());
            }
            buffer.push(fromOrigin);
        }
        
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
        
        return stack;
    }
    
    @Override
    protected void initialize() {
        stack = new Stack<Integer>();
        for (int i = 0; i < SIZE; i++) {
            stack.push((int) (Math.random() * MAXIMUM));
        }    
    }

    @Override
    protected void runExercise() {
    stack = sort(stack);    
    }

    @Override
    protected boolean test() {
        int prev = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (stack.peek() < prev) {
                System.out.println("Failed");
                return false;
            }
            prev = stack.pop();
        }

        System.out.println("Success!");
        return true;
    }
}
