package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

/*
 * Given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i (inclusive) and j (exclusive) in N equal to M.
 * 
 * For example, 
 * Input: N = 10000000000, M = 10101, i = 2, j = 6
 * Output: N = 10001010100
 */

public class Exercise05_01 implements Exercise {

	@Override
	public void run() {
		
		int n = 1024;
		int m = 21;
		int i = 2;
		int j = 6;
		
		int newN = copy(n, m, i, j);
		
		printNumbers(n, m, newN, i, j);

	}
	
	private int copy(int n, int m, int i, int j) {
		int max = ~0;
		int left = max - ((1 << j) - 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		
		return (n & mask) | (m << i);
	}
	
	private void printNumbers(int n, int m, int newN, int i, int j) {
		System.out.printf("N=%s, M=%s, newN=%s; i=%d, j=%d%n", 
				Integer.toBinaryString(n), Integer.toBinaryString(m),
				Integer.toBinaryString(newN),
				i, j);
	} 

}
