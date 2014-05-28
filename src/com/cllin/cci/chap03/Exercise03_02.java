package com.cllin.cci.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 */

public class Exercise03_02 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private MyStack myStack;
	private Stack<Integer> reference;
	
	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private class MyStack {
		Stack<Integer> stack;
		Stack<Integer> minimum;
		
		MyStack() {
			stack = new Stack<Integer>();
			minimum = new Stack<Integer>();
		}
		
		void push(int value) {
			stack.push(value);
			
			if (minimum.isEmpty() || value <= minimum.peek()) {
				minimum.push(value);
			} else {
				minimum.push(minimum.peek());
			}
		}
		
		int pop() {
			if (stack.isEmpty()) return Integer.MIN_VALUE;
			
			minimum.pop();
			return stack.pop();
		}
		
		int getMinimum() {
			return (stack.isEmpty())? Integer.MIN_VALUE : minimum.peek();
		}
		
		boolean isEmpty() {
			return stack.isEmpty();
		}
	}
	
	private void test() {
		while (!myStack.isEmpty()) {
			int minimum = Integer.MAX_VALUE;
			for (int n : reference) {
				minimum = Math.min(minimum, n);
			}
			
			if (myStack.getMinimum() != minimum) {
				System.out.println("Failed");
				return;
			}
			
			if (myStack.pop() != reference.pop()) {
				System.out.println("Failed");
				return;	
			}
		}
		
		if (!reference.isEmpty()) {
			System.out.println("Failed");
			return;
		}
		
		System.out.println("Success!");
	}
	
	private void initialize() {
		myStack = new MyStack();
		reference = new Stack<Integer>();
		
		for (int i = 0; i < SIZE; i++) {
			int n = (int) (Math.random() * MAXIMUM);
			myStack.push(n);
			reference.push(n);
		}
	}
}
