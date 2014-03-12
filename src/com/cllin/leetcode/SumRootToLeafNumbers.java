package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class SumRootToLeafNumbers implements LeetCodeExercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10;
	
	private int sum = 0;
	private BinarySearchTree tree;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
	}

	@Override
	public void runExercise() {
		initialize();
		sum = sumNumbers(tree.root);
		test();
	}
	
	private int sumNumbers(Node root) {
		if (root == null) return 0;
		traverse(root, 0);
		return sum;
    }
	
	private void traverse(Node node, int num) {
		if (node == null) return;
		
		num = num * 10 + node.value;
		
		if (node.left != null) traverse(node.left, num);
		if (node.right != null) traverse(node.right, num);
		
		if (node.left == null && node.right == null) sum += num; 
	}

	@Override
	public boolean test() {
		System.out.printf("The root-to-leaf path is %d%n", sum);
		return false;
	}

}
