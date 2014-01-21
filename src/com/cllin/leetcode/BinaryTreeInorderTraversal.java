package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BinaryTreeInorderTraversal implements LeetCodeExercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private BinarySearchTree tree;
	private ArrayList<Integer> result;
	private int[] reference;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		reference = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			tree.insert(new Node(value, null, null, null));
			reference[i] = value;
		}
		
		Arrays.sort(reference);

	}

	@Override
	public void runExercise() {
		initialize();
		result = inorderTraversal(tree.root);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");		
	}
	
    private ArrayList<Integer> inorderTraversal(Node root) {
    	ArrayList<Integer> rtn = new ArrayList<Integer>();
    	
    	if (root == null) return rtn;
    	
    	rtn.addAll(inorderTraversal(root.left));
    	rtn.add(root.value);
    	rtn.addAll(inorderTraversal(root.right));
    	
    	return rtn;
    }
    
    @SuppressWarnings("unused")
	private ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> rtn = new ArrayList<Integer>();
    	
    	if (root == null) return rtn;
    	
    	rtn.add(root.value);
    	rtn.addAll(preorderTraversal(root.left));
    	rtn.addAll(preorderTraversal(root.right));
    	
    	return rtn;
    }

	@Override
	public boolean test() {
		int size = result.size();
		int length = reference.length;
		
		if (size != length) return false;
		
		for (int i = 0; i < size; i++) {
			if (result.get(i).intValue() != reference[i]) return false;
		}
		
		return true;
	}

}
