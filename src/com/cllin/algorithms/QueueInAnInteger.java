package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * How to implement a queue using one integer, it should store value 0 to 9.
 * 
 * Source: http://www.careercup.com/question?id=310680
 */

public class QueueInAnInteger implements Exercise {

	private int integerQueue = 1;
	private LinkedList<Integer> queue;
	
	@Override
	public void runExercise() {
		push(0);
		queue.add(0);
		
		push(0);
		queue.add(0);
		
		push(8);
		queue.add(8);
		
		push(2);
		queue.add(2);
		
		push(4);
		queue.add(4);
		
		push(1);
		queue.add(1);
		
		push(0);
		queue.add(0);
		
		while (!queue.isEmpty()) {
			int a = poll();
			int b = queue.pollFirst();
			
			if (a != b) {
				System.out.println("Failed");
			}
		}
	}

	private void push(int value) {
		
	}
	
	private int poll() {
		return 0;
	}
	
	private int size() {
		return 0;
	}
}
