package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class FlattenBinaryTreeToLinkedList implements LeetCodeExercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 10;
	
	private BinarySearchTree tree;
	
	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
	}

	@Override
	public void runExercise() {
		initialize();
		flatten(tree.root);
	}
	
	private void flatten(Node root) {
		root = new Node(1);
		root.right = new Node(2);
		
		Node head = new Node(0);
		preorderTraversal(root, head);
		root = head;
	}
	
	private Node preorderTraversal(Node node, Node end) {
		if (node == null) return end;

		Node buf = node.right;
		end.right = node;
		end = end.right;

		Node newEnd = preorderTraversal(node.left, end);
		if (newEnd != null) end = newEnd;
		
		newEnd = preorderTraversal(buf, end);
		if (newEnd != null) end = newEnd; 
		
		node.left = null;
		return end;
	}

	@Override
	public boolean test() {
		return true;
	}

}
