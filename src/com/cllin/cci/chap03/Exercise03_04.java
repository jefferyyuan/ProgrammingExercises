package com.cllin.cci.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_04 implements Exercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	private Stack<Integer> stack3;
	
	@Override
	public void runExercise() {
		initialize();
		sort();
		moveDisk(SIZE, stack1, stack2,stack3);
		test();
	}
	
	private void moveDisk(int n, Stack<Integer> from, Stack<Integer> buffer, Stack<Integer> destination){
		if(n > 0){
			moveDisk(n - 1, from, destination, buffer);
			destination.push(from.pop());
			moveDisk(n - 1, buffer, from, destination);
		}
	}
	
	private void test(){
		if(!stack1.isEmpty() || !stack2.isEmpty()){
			System.out.println("Failed");
			return;
		}
		
		int prev = -2147483647;
		while(!stack3.isEmpty()){
			if(stack3.peek() < prev){
				System.out.println("Failed");
				return;
			}
			prev = stack3.pop();
		}
		
		System.out.println("Success!");
	}
	
	private void initialize(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		stack3 = new Stack<Integer>();
		for(int i = 0; i < SIZE; i++){
			stack1.push((int)(Math.random() * MAXIMUM));
		}
	}

	private void sort(){
		Stack<Integer> buffer = new Stack<Integer>();
		
		while(!stack1.isEmpty()){
			int fromOrigin = stack1.pop();
			while(!buffer.isEmpty() && buffer.peek() > fromOrigin){
				stack1.push(buffer.pop());
			}
			buffer.push(fromOrigin);
		}
		
		while(!buffer.isEmpty()){
			stack1.push(buffer.pop());
		}
	}
	
}
