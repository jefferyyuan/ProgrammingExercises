package com.cllin.chap04;

public class Node {
	private Node leftChild = null;
	private Node rightChild = null;
	private Node parent = null;
	private int value = 0;
	
	public Node(Node parent, int value){
		this.parent = parent;
		this.value = value;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public Node getLeftNode(){
		return leftChild;
	}
	
	public Node getRightChild(){
		return rightChild;
	}
	
	public int getValue(){
		return value;
	}
	
	public boolean isLeaf(){
		return (rightChild == null && leftChild == null);
	}
}
