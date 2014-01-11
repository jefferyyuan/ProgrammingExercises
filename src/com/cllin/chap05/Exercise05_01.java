package com.cllin.chap05;

import com.cllin.main.Exercise;

public class Exercise05_01 implements Exercise {

	@Override
	public void runExercise() {
		
		int n = 1024;
		int m = 21;
		int i = 2;
		int j = 6;
		
		int newN = copy(n, m, i, j);
		
		printNumbers(n, m, newN, i, j);

	}
	
	private int copy(int n, int m, int i, int j){
		int right = n;
		int left = n;
		
		m <<= i;
		right = (n >> i) << i;
		left = (n << (32 - j)) >> (32 - j);
		
		n = right | left | m;
		
		return n;
	}
	
	private void printNumbers(int n, int m, int newN, int i, int j){
		System.out.printf("N=%s, M=%s, newN=%s; i=%d, j=%d", 
				Integer.toBinaryString(n), Integer.toBinaryString(m),
				Integer.toBinaryString(newN),
				i, j);
	} 

}
