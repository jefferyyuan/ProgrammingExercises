package com.cllin.tree;


public class Node {
	public int key;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(int key, Node left, Node right, Node parent){
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public void printNode(){
		System.out.print(key);
	}
}
