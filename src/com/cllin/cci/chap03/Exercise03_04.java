package com.cllin.cci.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (e.g., each disk sits on top of an even larger one). You have the following constraints:
 *         1) Only one disk can be moved at a time.
 *         2) A disk is slid off the top of one rod onto the next rod.
 *         3) A disk can only be placed on top of a larger disk.
 * 
 * Write a program to move the disks from the first rod to the last using Stacks.
 */

public class Exercise03_04 extends Exercise {
    private final int SIZE = 10;
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Stack<Integer> stack3;
    
    private void moveDisk(int n, Stack<Integer> from, Stack<Integer> buffer, Stack<Integer> destination) {
        if (n > 0) {
            moveDisk(n - 1, from, destination, buffer);
            destination.push(from.pop());
            moveDisk(n - 1, buffer, from, destination);
        }
    }
    
    @Override
    protected void initialize() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        stack3 = new Stack<Integer>();
        
        for (int i = SIZE; i >= 1; i--) {
            stack1.push(i);
        }    
    }

    @Override
    protected void runExercise() {
    moveDisk(SIZE, stack1, stack2,stack3);    
    }

    @Override
    protected void test() {
        if (!stack1.isEmpty() || !stack2.isEmpty()) {
            System.out.println("Failed");
            return;
        }
        
        int prev = Integer.MIN_VALUE;
        while (!stack3.isEmpty()) {
            if (stack3.peek() < prev) {
                System.out.println("Failed");
                return;
            }
            prev = stack3.pop();
        }
        
        System.out.println("Success!");    
    }
}
