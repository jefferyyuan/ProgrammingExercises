package com.cllin.cci.chap10;

import java.util.HashSet;
import java.util.PriorityQueue;

import com.cllin.main.Exercise;

/*
 * Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
 */

public class Exercise10_07 implements Exercise {
	private final int[] testSuite = {1, 5, 6, 2, 3, 8, 30, 44, 27, 69, 56, 44, 73, 79, 81, 89, 94, 123, 183, 192, 448, 767};
	
	@Override
	public void run() {
		for (int k : testSuite) {
			int number = getNumber(k);
			System.out.printf("The %dth element is %d%n", k, number);
		}
		
	}
	
	private static int getNumber(int k) {
		int count = 1;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		queue.add(1);
		
		while (count < k) {
			int number = queue.poll();
			
			if (!visited.contains(number * 3)) queue.add(number * 3);
			if (!visited.contains(number * 5)) queue.add(number * 5);
			if (!visited.contains(number * 7)) queue.add(number * 7);
			
			visited.add(number);
			count++;
		}
		
		return queue.poll();
	}
}
