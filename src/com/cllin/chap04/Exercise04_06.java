package com.cllin.chap04;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class Exercise04_06 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private BinarySearchTree tree;
	private Node nodeA;
	private Node nodeB;

	@Override
	public void runExercise() {
		for(int i = 0; i < 10; i++){
			initialize();
			Node fcs = getFirstCommonAncestor(tree.root);
			System.out.printf("The value of the First Common Ancestor is %d%n", fcs.value);
		}
		
	}
	
	private Node getFirstCommonAncestor(Node node){
		if (node == null) return null;
		
		if(getCoveredNodes(node.left) == 1 && getCoveredNodes(node.right) == 1){
			return node;
		}else if(getCoveredNodes(node.left) == 2){
			if (node.left == nodeA || node.left == nodeB) return node.left;
			
			return getFirstCommonAncestor(node.left);
		}else if(getCoveredNodes(node.right) == 2){
			if (node.right == nodeA || node.right == nodeB) return node.right;
			
			return getFirstCommonAncestor(node.right);
		}
		
		return null;
	}
	
	private int getCoveredNodes(Node node){
		if (node == null) return 0;
		
		int nCoveredNodes = 0;
		if(node.hashCode() == nodeA.hashCode() || node.hashCode() == nodeB.hashCode()){
			nCoveredNodes++;
		}
		
		nCoveredNodes += getCoveredNodes(node.right) + getCoveredNodes(node.left);
		
		return nCoveredNodes;
	}

	private void initialize(){
		int a = (int)(Math.random() * SIZE);
		int b = (int)(Math.random() * SIZE);
		while(b == a){
			b = (int)(Math.random() * SIZE);
		}
		
		
		tree = new BinarySearchTree((int)(Math.random() * MAXIMUM));
		
		for(int i = 0; i < SIZE; i++){
			Node node = new Node((int)(Math.random() * MAXIMUM), null, null, null);
			if (i == a) nodeA = node;
			if (i == b) nodeB = node;
			
			tree.insert(node);
		}
	}
}
