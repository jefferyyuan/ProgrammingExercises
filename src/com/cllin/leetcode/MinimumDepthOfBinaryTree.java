package com.cllin.leetcode;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class MinimumDepthOfBinaryTree implements LeetCodeExercise {
	private final int SIZE = 100;
	private final int MAXIMUM = 10;
	
	private BinarySearchTree tree;
	private int minimumHeight;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
		
		minimumHeight = 0;
	}

	@Override
	public void runExercise() {
		initialize();
		minimumHeight = minDepth(tree.root);
		
		test();
	}
	
    private int minDepth(Node root) {
    	return traverse(root, 1);
    }
    
    private int traverse(Node node, int height) {
    	if (node == null) return height - 1;
    	
    	if (node.left == null && node.right == null) return height;
    	else if (node.left == null || node.right == null) 
    		return Math.max(traverse(node.left, height + 1), traverse(node.right, height + 1));
    	else return Math.min(traverse(node.left, height + 1), traverse(node.right, height + 1));
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum height of the tree is %d%n", minimumHeight);
		return false;
	}

}
