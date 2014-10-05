package com.cllin.cci.chap04;

import java.util.Arrays;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */

public class Exercise04_03 implements Exercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 20;
	
	private int[] array;
	private Tree tree;

	@Override
	public void run() {
		initialize();
		
		tree.root = buildTree(array);
		tree.printTree();
	}
	
	private Node buildTree(int[] array) {
		return addToTree(array, 0, array.length - 1);
	}
	
	private Node addToTree(int[] array, int start, int end) {
		if (end < start) return null;
		
		int mid = (start + end) / 2;

		Node n = new Node(array[mid]);
		n.left = addToTree(array, start, mid - 1);
		n.right = addToTree(array, mid + 1, end);
		return n;
	}
	
	private void initialize() {
		tree = new Tree();
		array = new int[SIZE];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(array);
	}
	
	private class Tree {
		private Node root = null;
		
		private void printTree() {
			LinkedList<Node> thisLevel = new LinkedList<Node>();
			LinkedList<Node> nextLevel = new LinkedList<Node>();
			
			thisLevel.add(this.root);
			while (!thisLevel.isEmpty()) {
				while (!thisLevel.isEmpty()) {
					Node node = thisLevel.poll();
					if (node.left != null) nextLevel.add(node.left);
					if (node.right != null) nextLevel.add(node.right);
					
					System.out.printf("%d ", node.value);
				}
				
				thisLevel.addAll(nextLevel);
				nextLevel = new LinkedList<Node>();
				System.out.println();
			}
		}
	}
	
	private class Node {
		private Node left = null;
		private Node right = null;
		private int value;
		
		private Node(int value) {
			this.value = value;
		}
	}

}
