package com.cllin.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_02 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private MyStack myStack;
	
	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private void test(){
		int minFromStack = myStack.min();
		int min = 1 << 31;
		while(!myStack.isEmpty()){
			int value = myStack.pop().value;
			if (value < min) min = value;
		}
		
		if(min != minFromStack){
			System.out.println("Failed");
			return;
		}
		System.out.println("Success!");
	}
	
	private void initialize(){
		myStack = new MyStack();
		for(int i = 0; i < SIZE; i++){
			myStack.push((int)(Math.random() * MAXIMUM));
		}
	}
	
	private class MyStack extends Stack<Node>{
		private static final long serialVersionUID = 1L;
		private int min = 1 << 31;
		
		public Node push(int value){
			Node node = new Node(value, min);
			if (value < min) min = value;
			
			return super.push(node);
		}
		
		public Node pop(){
			Node node = super.pop();
			min = node.minimumWithoutMe;
			
			return node;
		}
		
		public int min(){
			return min;
		}
		
	}
	
	private class Node {
		private int value = 0;
		private int minimumWithoutMe = 1 << 31;
		
		public Node(int value, int minimumWithoutMe){
			this.value = value;
			this.minimumWithoutMe = minimumWithoutMe;
		}
	}

}
