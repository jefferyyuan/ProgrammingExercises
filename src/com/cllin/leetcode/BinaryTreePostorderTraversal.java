package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BinaryTreePostorderTraversal implements LeetCodeExercise {
	private final int MAXIMUM = 3;
	private final int SIZE = 3;
	
	private BinarySearchTree tree;
	private ArrayList<Integer> result;
	private ArrayList<Integer> reference;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		reference = new ArrayList<Integer>();
		int[] numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) numbers[i] = (int)(Math.random() * MAXIMUM);
		Arrays.sort(numbers);
		
		tree.buildTree(numbers);
	}

	@Override
	public void runExercise() {
		initialize();
		result = postorderTraversal(tree.root);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");		
	}
	
	private ArrayList<Integer> postorderTraversal(Node root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<Node> list = new ArrayList<Node>();
    	Stack<Node> stack = new Stack<Node>();
    	
    	if (root == null) return result;
    	
    	stack.add(root); 
    	while (!stack.isEmpty()) {
    		Node node = stack.peek();
    		
    		if (node.left != null && !list.contains(node.left)) stack.push(node.left);
    		else if (node.right != null && !list.contains(node.right)) stack.push(node.right);
    		else {
    			Node n = stack.pop();
    			list.add(n);
    			result.add(n.value);
    		}
    	}
    	
        return result;
    }
    
	private void postTreeWalk(Node node) {
		if (node != null) {
			postTreeWalk(node.left);
			postTreeWalk(node.right);
			reference.add(node.value);
		}
	}

	@Override
	public boolean test() {
		postTreeWalk(tree.root);
		
		int size = result.size();
		if (size != reference.size()) return false;
		
		for (int i = size - 1; i >= 0; i--) {
			if (result.get(i).intValue() != reference.get(i).intValue()) return false;
		}
		
		return true;
	}

}
