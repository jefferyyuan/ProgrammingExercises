package com.cllin.chap03;

import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_05 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	private int[] numbers = new int[SIZE];
	
	private MyQueue myQueue;
	
	@Override
	public void runExercise() {
		initialize();
		
		test();
	}
	
	private void initialize(){
		int length = numbers.length;
		for(int i = 0; i < length; i++){
			numbers[i] = (int)(Math.random() * MAXIMUM);
		}
		
		myQueue = new MyQueue();
	}
	
	private void test(){
		int length = numbers.length;
		for(int i = 0; i < length; i++){
			myQueue.add(numbers[i]);
		}
		
		if(myQueue.size() != SIZE){
			System.out.println("Failed");
			return;
		}else{
			System.out.printf("MyQueue.size()=%d%n", myQueue.size());
		}
		
		int i = 0;
		while(!myQueue.isEmpty()){
			if(myQueue.peek() != numbers[i] || myQueue.remove() != numbers[i]){
				System.out.println("Failed");
				return;
			}
			i++;
		}
		System.out.println("Success!");
	}
	
	private class MyQueue {
		Stack<Integer> stackA;
		Stack<Integer> stackB;
		
		public MyQueue(){
			stackA = new Stack<Integer>();
			stackB = new Stack<Integer>();
		}
		
		public void add(int element){
			stackA.push(element);
		}
		
		public int remove(){
			pourAToB();
			int element = stackB.pop();
			pourBToA();
			return element;
		}
		
		public int peek(){
			pourAToB();
			int element = stackB.peek();
			pourBToA();
			return element;
		}
		
		public int size(){
			return stackA.size();
		}
		
		public boolean isEmpty(){
			return stackA.isEmpty();
		}
		
		private void pourAToB(){
			while(!stackA.isEmpty()){
				stackB.push(stackA.pop());
			}
		}
		
		private void pourBToA(){
			while(!stackB.isEmpty()){
				stackA.push(stackB.pop());
			}
		}
	}
}
