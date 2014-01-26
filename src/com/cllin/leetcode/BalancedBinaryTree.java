package com.cllin.leetcode;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BalancedBinaryTree implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;
	
	private BinarySearchTree tree;
    boolean isBalanced;
	
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
