package com.cllin.cci.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * Describe how you could use a single array to implement three stacks.
 */

public class Exercise03_01 extends Exercise {
    private final int MAXIMUM = 100;
    private final int SIZE = 10;
    
    private class MyStack {
        int size;
        int[] array;
        int[] pointers;
        
        MyStack(int size) {
            this.size = size;
            this.array = new int[size * 3];
            this.pointers = new int[3];
            
            pointers[0] = 0;
            pointers[1] = size;
            pointers[2] = size * 2;
        }
        
        boolean push(int stackNumber, int value) {
            if (stackNumber < 0 || stackNumber > 2) return false;
            if (pointers[stackNumber] >= (stackNumber + 1) * size) return false;
            
            array[pointers[stackNumber]++] = value;
            
            return true;
        }
        
        int pop(int stackNumber) {
            if (stackNumber < 0 || stackNumber > 2) return -1;
            if (pointers[stackNumber] <= stackNumber * size) return -1;
            
            return array[--pointers[stackNumber]];
        }
        
        int peek(int stackNumber) {
            if (stackNumber < 0 || stackNumber > 2) return -1;
            if (pointers[stackNumber] <= stackNumber * size) return -1;
            
            return array[pointers[stackNumber] - 1];            
        }
        
        boolean isEmpty(int stackNumber) {
            if (stackNumber < 0 || stackNumber > 2) return false;
            return pointers[stackNumber] <= stackNumber * size;
        }
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
    protected boolean test() {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        MyStack myStack = new MyStack(SIZE);
        
        for (int i = 0; i < SIZE; i++) {
            int a = (int)(Math.random() * MAXIMUM);
            int b = (int)(Math.random() * MAXIMUM);
            int c = (int)(Math.random() * MAXIMUM);
            
            stack1.push(a);
            myStack.push(0, a);
            
            stack2.push(b);
            myStack.push(1, b);
            
            stack3.push(c);
            myStack.push(2, c);
        }
        
        if (stack1.peek() != myStack.peek(0)
                || stack2.peek() != myStack.peek(1)
                || stack3.peek() != myStack.peek(2)) {
            System.out.println("Failed");
            return false;
        }
        
        if (stack1.isEmpty() != myStack.isEmpty(0)
                || stack2.isEmpty() != myStack.isEmpty(1)
                || stack2.isEmpty() != myStack.isEmpty(2)) {
            System.out.println("Failed");
            return false;
        }
        
        for (int i = 0; i < SIZE; i++) {
            if (stack1.pop() != myStack.pop(0)
                    || stack2.pop() != myStack.pop(1)
                    || stack3.pop() != myStack.pop(2)) {
                System.out.println("Failed");
                return false;
            }
        }
        
        System.out.println("Success!");
        return true;
    }
}
