package com.cllin.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_06 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	private Stack<Integer> stack;

	@Override
	public void runExercise() {
		initialize();
		sort();
		check();
	}
	
	private void sort(){
		Stack<Integer> buffer = new Stack<Integer>();
		
		while(!stack.isEmpty()){
			int fromOrigin = stack.pop();
			while(!buffer.isEmpty() && buffer.peek() > fromOrigin){
				stack.push(buffer.pop());
			}
			buffer.push(fromOrigin);
		}
		
		while(!buffer.isEmpty()){
			stack.push(buffer.pop());
		}
	}
	
	private void check(){
		int prev = -2147483647;
		while(!stack.isEmpty()){
			if(stack.peek() < prev){
				System.out.println("Failed");
				return;
			}
			prev = stack.pop();
		}
		System.out.println("Success!");
	}

	private void initialize(){
		stack = new Stack<Integer>();
		for(int i = 0; i < SIZE; i++){
			stack.push((int)(Math.random() * MAXIMUM));
		}
	}
}
