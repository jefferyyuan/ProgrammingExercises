package com.cllin.leetcode;

public class SqrtX implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void runExercise() {
		for (int i = 1; i <= 2147483647 && i > 0; i *= 2) {
			int squareRoot = sqrt(i);
			System.out.printf("The square root of %d is %d%n", i, squareRoot);
		}
	}
	
	private int sqrt(int x) {
		if (x <= 0) return 0;
		else if (x == 1) return 1;
		
		long root;
		long start = 1;
		long end = x;
		
		while (start < end) {
			root = (start + end) / 2;
			
			if (root <= x / root && (x / (root + 1)) < (root + 1)) {
				return (int) root;
			} else if (root < (x / root)) {
				start = root;
			} else {
				end = root;
			}
		}
		
		return -1;
    }

	@Override
	public boolean test() {
		return false;
	}

}
