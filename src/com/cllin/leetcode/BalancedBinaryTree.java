package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which 
 * the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Source: http://oj.leetcode.com/problems/balanced-binary-tree/
 */

public class BalancedBinaryTree implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;
	
	private BinarySearchTree tree;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
		
		isBalanced = true;
	}

	@Override
	public void runExercise() {
		initialize();
		
		Node node = new Node(1);
		node.right = new Node(2);
		node.right.right = new Node(3);
		
		boolean result = isBalanced(node);
		
		if (result) System.out.println("The tree is balanced");
		else System.out.println("The tree is not balanced");
		
	}
	
	boolean isBalanced;
    private boolean isBalanced(Node root) {
    	traversal(root, 0);
    	return isBalanced;
    }
    
    private int traversal(Node node, int height) {
    	if (node == null) return height;
    	
    	int left = traversal(node.left, height + 1);
    	int right = traversal(node.right, height + 1);
    	
    	if (Math.abs(left - right) > 1) isBalanced = false;
    	
    	return Math.max(left, right);
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
