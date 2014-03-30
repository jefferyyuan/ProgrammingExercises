package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Source: http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * Source: http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */

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
	
	/* Iterative implementation requires extra O(n) space for:,
	 * 1) a stack
	 * 2) a list that stores visited node
	 */
    private ArrayList<Integer> inorderTraversal(Node root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<Node> list = new ArrayList<Node>();
    	Stack<Node> stack = new Stack<Node>();
    	
    	if (root == null) return result;
    	
    	stack.add(root);
    	
    	while (!stack.isEmpty()) {
    		Node node = stack.peek();
    		
    		if (node.left != null && !list.contains(node.left)) stack.push(node.left);
    		else {
    			Node n = stack.pop();
    			list.add(n);
    			result.add(n.value);
    			
    			if (node.right != null && !list.contains(node.right)) stack.push(node.right);
    		}
    	}
    	
    	return result;
    }
    
    @SuppressWarnings("unused")
	private ArrayList<Integer> preorderTraversal(Node root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<Node> list = new ArrayList<Node>();
    	Stack<Node> stack = new Stack<Node>();
    	
    	if (root == null) return result;
    	
    	stack.add(root); 
    	while (!stack.isEmpty()) {
    		Node node = stack.pop();
    		list.add(node);
    		result.add(node.value);
    		
    		if (node.right != null && !list.contains(node.right)) stack.push(node.right);
    		if (node.left != null && !list.contains(node.left)) stack.push(node.left);
    	}
    	
        return result;
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
