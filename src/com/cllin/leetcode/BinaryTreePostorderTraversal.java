package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BinaryTreePostorderTraversal implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	
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
		result = postorderTraversal(tree.root);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");		
	}
	
    public ArrayList<Integer> postorderTraversal(Node root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
//    	TODO
    	
        return result;
    }

	@Override
	public boolean test() {
		int size = result.size();
		int length = reference.length;
		
		if (size != length) return false;
		
		for (int i = size - 1; i >= 0; i--) {
			if (result.get(i).intValue() != reference[i]) return false;
		}
		
		return true;	}

}
