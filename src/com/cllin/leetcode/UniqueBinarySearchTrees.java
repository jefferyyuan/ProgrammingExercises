package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class UniqueBinarySearchTrees implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		for (int n = 1; n <= 10; n++) {
			int num = numTrees(n);
			System.out.printf("There are %d unique binary search trees to integer 1-%d%n", num, n);
		}

	}
	
    private int numTrees(int n) {
    	if (n < 0) return 0;
    	if (n <= 1) return 1;
        int num = 0;
        
        if (n % 2 == 0) {
        	int lowerLimit = n / 2;
        	for (int i = n - 1; i >= lowerLimit; i--) {
        		num += 2 * numTrees(i) * numTrees(n - i - 1);
        	}	
        } else {
        	int lowerLimit = n / 2;
        	for (int i = n - 1; i > lowerLimit; i--) {
        		num += 2 * numTrees(i) * numTrees(n - i - 1);
        	}		
        	num += numTrees(lowerLimit) * numTrees(lowerLimit);
        }
        
        return num;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
