package com.cllin.leetcode;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class PathSum implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	
	private BinarySearchTree tree;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
	}

	@Override
	public void runExercise() {
		initialize();
		for (int sum = 0; sum < 50; sum++) {
			boolean result = hasPathSum(tree.root, sum);
			if (result) System.out.printf("The tree has a root-to-leaf whose sum is %d%n", sum);
			else System.out.printf("The tree does not have a root-to-leaf whose sum is %d%n", sum);
		}
	}
	
	private boolean hasPathSum(Node root, int sum) {
		return traverse(root, 0, sum);
    }
	
	private boolean traverse(Node node, int sum, int target) {
		if (node == null) return false;
		
		if (node.left == null && node.right == null) {
			return (sum + node.value == target)? true : false;
		}
		
		return traverse(node.left, sum + node.value, target) 
				|| traverse(node.right, sum + node.value, target);
	}

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
