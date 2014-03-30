package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * 
 * Source: http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

public class BinaryTreeZigzagLevelOrderTraversal implements LeetCodeExercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10;
	
	private BinarySearchTree tree;
	private ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
	}

	@Override
	public void runExercise() {
		initialize();
		result = zigzagLevelOrder(tree.root);
		test();
	}
	
	private ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
    	ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
    	Stack<Node> thisLevel = new Stack<Node>();
    	Stack<Node> nextLevel = new Stack<Node>();
    	
    	if (root == null) return levels;
    	
    	int count = 1;
    	thisLevel.add(root);
    	while (!thisLevel.isEmpty()) {
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		
        	while (!thisLevel.isEmpty()) {
        		Node n = thisLevel.pop();
        		
        		level.add(n.value);
        		
        		if (count % 2 == 0) {
        			if (n.right != null) nextLevel.push(n.right);        			
        			if (n.left != null) nextLevel.push(n.left);
        		} else {
        			if (n.left != null) nextLevel.push(n.left);
        			if (n.right != null) nextLevel.push(n.right);        			
        		}
        	}
        	
        	thisLevel = nextLevel;
        	nextLevel = new Stack<Node>();
        	levels.add(level);
        	count++;
    	}
    	
    	return levels;
    }
	
	@Override
	public boolean test() {
		for (ArrayList<Integer> level : result) {
			for (int n : level) System.out.printf("%d ", n);
			System.out.println();
		}
		
		return false;
	}

}
