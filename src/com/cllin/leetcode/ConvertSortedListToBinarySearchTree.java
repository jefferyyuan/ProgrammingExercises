package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class ConvertSortedListToBinarySearchTree implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 2000;
	
	private ListNode head;
	private TreeNode root;
	private int[] reference;

	@Override
	public void initialize() {
		reference = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			reference[i] = (int)(Math.random() * MAXIMUM);
		}
		Arrays.sort(reference);
		
		head = new ListNode(reference[0]);
		ListNode node = head;
		for (int i = 1; i < SIZE; i++) {
			node.next = new ListNode(reference[i]);
			node = node.next;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		root = sortedListToBST(head);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
	private TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ListNode node = head;
		
		while (node != null) {
			numbers.add(node.val);
			node = node.next;
		}
		
		return buildTree(numbers, 0, numbers.size() - 1);
	}
	
    private TreeNode buildTree(ArrayList<Integer> num, int start, int end) {
    	if (start == end) return new TreeNode(num.get(start));
    	else if (start > end) return null;
    	
    	int mid = (start + end) / 2;
    	
    	TreeNode node = new TreeNode(num.get(mid));
    	node.left = buildTree(num, start, mid - 1);
    	node.right = buildTree(num, mid + 1, end);
    	
    	return node;
    }
    
	private String inOrderTreeWalk(TreeNode node) {
		String string = new String();
		
		if (node == null) return string;
		
		string += inOrderTreeWalk(node.left);
		string += Integer.toString(node.val);
		string += inOrderTreeWalk(node.right);
		
		return string;
	}

	@Override
	public boolean test() {
		String result = inOrderTreeWalk(root);
		
		String reference = new String();
		for (int n : this.reference) {
			reference += Integer.toString(n);
		}
		
		return (result.equals(reference))? true : false;
	}
	
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x; 
			next = null;
		}
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
