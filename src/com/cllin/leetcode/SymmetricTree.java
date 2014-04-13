package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 
 * Source: http://oj.leetcode.com/problems/symmetric-tree/
 */

public class SymmetricTree implements LeetCodeExercise {
	private final int MAXIMUM = 0;
	private final int SIZE = 100;
	
	private BinarySearchTree tree;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		
		for(int i = 0; i < SIZE; i++){
			tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		boolean isSymmetric = isSymmetric(tree.root);
		if (isSymmetric) System.out.println("The tree is symmetric");
		else System.out.println("The tree is not symmetric");
	}
	
    private boolean isSymmetric(Node root) {
    	if (root == null) return true;
    	
    	ArrayList<String> preOrder = preOrderTreeWalk(root);
    	ArrayList<String> postOrder = postOrderTreeWalk(root);
    	
    	if (preOrder.size() != postOrder.size()) return false;
    	
    	int size = preOrder.size();
    	for (int i = 0; i < size; i++) {
    		if (!preOrder.get(i).equals(postOrder.get(size - 1 - i))) return false;
    	}
    	
        return true;
    }
    
    private ArrayList<String> preOrderTreeWalk(Node node) {
    	ArrayList<String> nodes = new ArrayList<String>();
    	
    	if (node == null) {
    		nodes.add("#");
    	} else {
    		ArrayList<String> left = preOrderTreeWalk(node.left);
    		ArrayList<String> right = preOrderTreeWalk(node.right);
    		
    		nodes.add(Integer.toString(node.value));
    		nodes.addAll(left);
    		nodes.addAll(right);
    	}
    	
    	return nodes;
    }
    
    private ArrayList<String> postOrderTreeWalk(Node node) {
    	ArrayList<String> nodes = new ArrayList<String>();
    	
    	if (node == null) {
    		nodes.add("#");
    	} else {
    		ArrayList<String> left = postOrderTreeWalk(node.left);
    		ArrayList<String> right = postOrderTreeWalk(node.right);
    		
    		nodes.addAll(left);
    		nodes.addAll(right);
    		nodes.add(Integer.toString(node.value));
    	}
    	
    	return nodes;   	
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
