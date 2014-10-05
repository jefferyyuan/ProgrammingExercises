package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 	   1         3     3      2      1
 * 	    \       /     /      / \      \
 * 	     3     2     1      1   3      2
 * 	    /     /       \                 \
 * 	   2     1         2                 3
 * 
 * Source: http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */

public class UniqueBinarySearchTreesII implements LeetCodeExercise {

	private int n;
	private ArrayList<TreeNode> result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		for (n = 0; n <= 10; n++) {
			result = generateTrees(n);
			
			if (!test()) System.out.println("Failed");	
		}
	}

	private ArrayList<TreeNode> generateTrees(int n) {
		if (n < 1) {
			ArrayList<TreeNode> result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
		
		return buildTrees(1, n);
    }
	
	private ArrayList<TreeNode> buildTrees(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) return result;
		
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = buildTrees(start, i - 1);
			ArrayList<TreeNode> right = buildTrees(i + 1, end);
			
			int leftSize = left.size();
			int rightSize = right.size();
			if (leftSize == 0 && rightSize == 0) {
				TreeNode n = new TreeNode(i);
				result.add(n);
			} else if (leftSize == 0) {
				for (int q = 0; q < rightSize; q++) {
					TreeNode n = new TreeNode(i);
					n.right = right.get(q);
					result.add(n);
				}
			} else if (rightSize == 0) {
				for (int p = 0; p < leftSize; p++) {
					TreeNode n = new TreeNode(i);
					n.left = left.get(p);
					result.add(n);
				}				
			} else {
				for (int p = 0; p < leftSize; p++) {
					for (int q = 0; q < rightSize; q++) {
						TreeNode n = new TreeNode(i);
						n.left = left.get(p);
						n.right = right.get(q);
						result.add(n);
					}
				}
			}
		}
		
		return result;
    }
	
    private int numTrees(int n) {
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
		int num = numTrees(n);
		if (num != result.size()) {
			return false;
		}
		
		System.out.printf("There are %d unique binary search trees to integer 1-%d%n", num, n);
		return true;
	}
	
	@SuppressWarnings("unused")
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x;
			left = null;
			right = null;
		}
	}
}
