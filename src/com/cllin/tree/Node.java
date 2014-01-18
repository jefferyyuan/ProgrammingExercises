package com.cllin.tree;


public class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(int key, Node left, Node right, Node parent){
		this.value = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public void printNode(){
		System.out.print(value);
	}
}
