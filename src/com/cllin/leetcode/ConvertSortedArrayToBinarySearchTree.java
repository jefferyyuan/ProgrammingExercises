package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.tree.Node;

public class ConvertSortedArrayToBinarySearchTree implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;
	
	private int[] numbers;
	private Node root;
	
	@Override
	public void initialize() {
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int) (Math.random() * MAXIMUM);
		}
		
		Arrays.sort(numbers);
	}

	@Override
	public void runExercise() {
		initialize();
		
		root = sortedArrayToBST(numbers);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private Node sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length - 1);
    }
    
    private Node buildTree(int[] num, int start, int end) {
    	if (start == end) return new Node(num[start]);
    	else if (start > end) return null;
    	
    	int mid = (start + end) / 2;
    	
    	Node node = new Node(num[mid]);
    	node.left = buildTree(num, start, mid - 1);
    	node.right = buildTree(num, mid + 1, end);
    	
    	return node;
    }
	
	private String inOrderTreeWalk(Node node) {
		String string = new String();
		
		if (node == null) return string;
		
		string += inOrderTreeWalk(node.left);
		string += Integer.toString(node.value);
		string += inOrderTreeWalk(node.right);
		
		return string;
	}

	@Override
	public boolean test() {
		String result = inOrderTreeWalk(root);
		
		String reference = new String();
		for (int n : numbers) {
			reference += Integer.toString(n);
		}
		
		return (result.equals(reference))? true : false;
	}

}
