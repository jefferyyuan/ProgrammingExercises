package com.cllin.leetcode;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class SameTree implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 100;
	
	private BinarySearchTree tree;
	private BinarySearchTree treeCopy;
	private BinarySearchTree tree2;
	
	private boolean result1 = false;
	private boolean result2 = false;
	private boolean result3 = false;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		treeCopy = new BinarySearchTree();
		tree2 = new BinarySearchTree();
		
		for(int i = 0; i < SIZE; i++){
			int value = (int)(Math.random() * MAXIMUM);
			tree.insert(new Node(value, null, null, null));
			treeCopy.insert(new Node(value, null, null, null));
			
			tree2.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}

	}

	@Override
	public void runExercise() {
		initialize();
		
		result1 = isSameTree(tree.root, treeCopy.root);
		result2 = isSameTree(tree2.root, treeCopy.root);
		result3 = isSameTree(tree.root, tree2.root);
		
		if (!test()) System.out.println("Failed");
		else System.out.println("Success");

	}
	
	private boolean isSameTree(Node p, Node q){
		return isSameNode(p, q);
	}
	
	private boolean isSameNode(Node p, Node q){
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.value != q.value) return false;
		
		return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
	}
	
	

	@Override
	public boolean test() {
		if (!result1 || result2 || result3) return false; 
		return true;
	}

}
