package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Description
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 		1) The left subtree of a node contains only nodes with keys less than the node's key.
 * 		2) The right subtree of a node contains only nodes with keys greater than the node's key.
 * 		3) Both the left and right subtrees must also be binary search trees.
 * 
 * Source: http://oj.leetcode.com/problems/validate-binary-search-tree/
 */

public class ValidateBinarySearchTree implements LeetCodeExercise {
	private TreeNode[] testSuite = {
			null,
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10)
	};
	
	private boolean[] solution = {
			true,
			true,
			true,
			false,
			false,
			false
	};

	@Override
	public void initialize() {
//		Case 0: null tree
		
//		Case 1: Valid BST
		testSuite[1].left = new TreeNode(5);
		testSuite[1].right = new TreeNode(10);
		
//		Case 2: Tree with one node
			
//		Case 3: One element from the left subtree is larger than the root
		TreeNode left = new TreeNode(5);
		left.left = new TreeNode(2);
		left.right = new TreeNode(20);
		
		testSuite[3].left = left;
		
//		Case 4: One element from the right subtree is less than the root
		TreeNode right = new TreeNode(15);
		right.left = new TreeNode(2);
		right.right = new TreeNode(20);
		
		testSuite[4].left = right;
		
//		Case 5: Duplicate values
		testSuite[5].left = new TreeNode(10);
	}

	@Override
	public void runExercise() {
		initialize();
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");
	}
	
	private boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	/*
	 * Return true if:
	 * 1) This is a null node
	 * 2) Keys on the left child is smaller the key of the node AND Keys on the right child is larger the key of the node
	 * 
	 * Else, return false.
	 */
	private boolean isValidBSTHelper(TreeNode node, int min, int max) {
		if (node == null) return true;
		
		int value = node.val;
		if (value > min && value < max) {
			return isValidBSTHelper(node.left, min, value) && isValidBSTHelper(node.right, value, max);
		}
		
		return false;
	}

	@Override
	public boolean test() {
		for (int i = 5; i < testSuite.length; i++) {
			if (isValidBST(testSuite[i]) != solution[i]) {
				return false;
			}
		}
		
		return true;
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x;
		}
	
	}
}
