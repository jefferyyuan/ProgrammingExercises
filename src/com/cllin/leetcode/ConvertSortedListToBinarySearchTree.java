package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Source: http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class ConvertSortedListToBinarySearchTree implements LeetCodeExercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10;
	
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
		ListNode node = head;

		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		
		list = head;
		return buildTree(0, size - 1);
	}
	
	private ListNode list;
    private TreeNode buildTree(int start, int end) {
    	if (start > end) return null;
    	int mid = start + (end - start) / 2;
    	
    	TreeNode leftChild = buildTree(start, mid - 1);
    	
    	TreeNode node = new TreeNode(list.val);
    	list = list.next;
    	
    	TreeNode rightChild = buildTree(mid + 1, end);
    	
    	node.left = leftChild;
    	node.right = rightChild;
    	
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
