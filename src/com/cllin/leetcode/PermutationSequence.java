package com.cllin.leetcode;

import java.util.ArrayList;

public class PermutationSequence implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (int n = 1; n <= 5; n++) {
			int factorial = getFactorial(n);
			
			for (int k = 1; k <= factorial; k++) {
				String permutation = getPermutation(n, k);
				System.out.printf("The %dth permutation of %d is %s%n", k, n, permutation);
			}
			
			System.out.println("------------------");
		}
	}
	
	private String getPermutation(int n, int k) {
		if (n < 0 || getFactorial(n) < k) return new String();
		
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) candidates.add(i);
		
    	return permute(candidates, k);
    }
	
	private String permute(ArrayList<Integer> candidates, int k) {
		String string = new String();
		if (candidates == null || candidates.size() == 0) return string;
		
		int n = candidates.size();
		int factorial = getFactorial(n - 1);
		
		int firstNumberIdx = (k - 1) / factorial;
		int firstNumber = candidates.get(firstNumberIdx);
		candidates.remove(firstNumberIdx);
		
		int order = (k % factorial == 0)? factorial : k % factorial;
		
    	return firstNumber + permute(candidates, order);
	}
	
	private int getFactorial(int n) {
		if (n == 0) return 1;
		int factorial = 1;

		for (int i = 1; i <= n; i++) factorial *= i;
		return factorial;
	}

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
