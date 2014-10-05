package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 	   1         3     3      2      1
 * 	    \       /     /      / \      \
 * 	     3     2     1      1   3      2
 * 	    /     /       \                 \
 * 	   2     1         2                 3
 * 
 * Source: http://oj.leetcode.com/problems/unique-binary-search-trees/
 */

public class UniqueBinarySearchTrees implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		for (int n = 1; n <= 10; n++) {
			int num = numTrees(n);
			System.out.printf("There are %d unique binary search trees to integer 1-%d%n", num, n);
		}

	}
	
    private int numTrees(int n) {
    	if (n < 0) return 0;
    	if (n <= 1) return 1;
    	
    	int[] nums = new int[n + 1];
    	nums[0] = 1;
    	nums[1] = 1;
    	
    	for (int i = 2; i <= n; i++) {
    		int num = 0;
    		
    		int lowerLimit = i / 2;
    		for (int j = i - 1; j > lowerLimit; j--) {
    			num += 2 * nums[j] * nums[i - j - 1];
    		}
    		
    		num += (i % 2 == 0)? 2 * nums[lowerLimit] * nums[i - lowerLimit - 1] : nums[lowerLimit] * nums[lowerLimit];
    		
    		nums[i] = num;
    	}
        
        return nums[n];
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
