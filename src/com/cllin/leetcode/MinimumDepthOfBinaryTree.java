package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Source: http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */

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
	public void run() {
		initialize();
		minimumHeight = minDepth(tree.root);
		
		test();
	}
	
    private int minDepth(Node root) {
    	return traverse(root, 1);
    }
    
    private int traverse(Node node, int depth) {
    	if (node == null) return depth - 1;
    	
    	if (node.left == null && node.right == null) {
    		return depth;
    	} else if (node.left == null || node.right == null) {
    		return Math.max(traverse(node.left, depth + 1), traverse(node.right, depth + 1));
    	} else {
    		return Math.min(traverse(node.left, depth + 1), traverse(node.right, depth + 1));
    	}
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum height of the tree is %d%n", minimumHeight);
		return false;
	}

}
