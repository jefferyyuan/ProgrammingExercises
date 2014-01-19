package com.cllin.cci.chap03;

import java.util.Arrays;
import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_01 implements Exercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 10;
	
	private int[] array;
	private int sizeOfStack = 5;

	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private void test(){
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		for(int i = 0; i < SIZE; i++){
			int a = (int)(Math.random() * MAXIMUM);
			int b = (int)(Math.random() * MAXIMUM);
			int c = (int)(Math.random() * MAXIMUM);
			
			stack1.push(a);
			push(a, 1);
			
			stack2.push(b);
			push(b, 2);
			
			stack3.push(c);
			push(c, 3);
		}
		
		for(int i = 0; i < SIZE; i++){
			if(stack1.pop() != peek(1) || peek(1) != pop(1)){
				System.out.println("Failed");
				return;
			}
			
			if(stack2.pop() != peek(2) || peek(2) != pop(2)){
				System.out.println("Failed");
				return;
			}
			
			if(stack3.pop() != peek(3) || peek(3) != pop(3)){
				System.out.println("Failed");
				return;
			}
		}
		
		System.out.println("Success!");
	}
	
	private void push(int value, int stack){
		int start = (stack - 1) * sizeOfStack;
		int end = stack * sizeOfStack;
		for(int i = start; i < end; i++){
			if(array[i] == 1 << 31){
				array[i] = value;
				return;
			}
		}
		expand();
		push(value, stack);
	}
	
	private int pop(int stack){
		int start = stack * sizeOfStack - 1;
		int end = (stack - 1) * sizeOfStack;
		
		for(int i = start; i >= end; i--){
			if(array[i] != 1 << 31){
				int output = array[i];
				array[i] = 1 << 31;
				return output;
			}
		}
		
		return 1 << 31;
	}
	
	private int peek(int stack){
		int start = stack * sizeOfStack - 1;
		int end = (stack - 1) * sizeOfStack;
		
		for(int i = start; i >= end; i--){
			if(array[i] != 1 << 31){
				int output = array[i];
				return output;
			}
		}
		
		return 1 << 31;
	}
	
	private void expand(){
		int length = array.length;
		int originSizeOfStack = sizeOfStack;
		int[] buf = Arrays.copyOf(array, length);
		
		sizeOfStack *= 2;
		initialize();
		
		for(int i = 0; i < originSizeOfStack; i++){
			array[i] = buf[i];
			array[i + sizeOfStack] = buf[i + originSizeOfStack];
			array[i + sizeOfStack * 2] = buf[i + originSizeOfStack * 2];
		}
		
	}
	
	private void initialize(){
		array = new int[sizeOfStack * 3];
		Arrays.fill(array, 1 << 31);
	}

}
