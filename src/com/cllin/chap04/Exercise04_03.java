package com.cllin.chap04;

import java.util.Arrays;

import com.cllin.main.Exercise;

public class Exercise04_03 implements Exercise {
	private final int MAXIMUM = 20;
	private final int SIZE = 20;
	
	private int[] array;
	private Tree tree;

	@Override
	public void runExercise() {
		initialize();
		buildTree();
		
		tree.printTree();
	}
	
	private void buildTree(){
		tree.root = addToTree(0, SIZE - 1);
	}
	
	private Node addToTree(int start, int end){
		if (end < start) return null;
		
		int mid = (start + end) / 2;

		Node n = new Node(array[mid]);
		n.left = addToTree(start, mid - 1);
		n.right = addToTree(mid + 1, end);
		return n;
	}
	
	private void initialize(){
		tree = new Tree();
		array = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++){
			array[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(array);
	}
	
	private class Tree {
		private Node root = null;
		
		private void printTree(){
			Node node = this.root;
			inOrderTreeWalk(node);

		}
		
		public void inOrderTreeWalk(Node node){
			if(node != null){
				inOrderTreeWalk(node.left);
				System.out.printf("%d ", node.value);
				inOrderTreeWalk(node.right);
			}
		}
	}
	
	private class Node {
		private Node left = null;
		private Node right = null;
		private int value;
		
		private Node(int value){
			this.value = value;
		}
	}

}
