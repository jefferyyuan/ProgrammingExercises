package com.cllin.algorithms;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Design an algorithm and write code to serialize and de-serialize a binary tree.
 * 
 * http://leetcode.com/2010/09/serializationdeserialization-of-binary.html
 */

public class SerializeBinaryTree implements Exercise {

	private final int SIZE = 5;
	private final int MAXIMUM = 500;
	private BinarySearchTree tree;
	
	private String serialize;
	private Node node;
	
	@Override
	public void runExercise() {
		initialize();
		
		serialize = serialize(tree.root, new String());
		node = deserialize();
		
		test();
	}
	
	private void initialize() {
		tree = new BinarySearchTree();
		tree.buildTree(SIZE, MAXIMUM);
	}
	
	private String serialize(Node node, String string){
		if (node == null) {
			string += "#";
			return string;
		}
		
		string += node.value;
		string += "|";
		string = serialize(node.left, string);
		string = serialize(node.right, string);
		
		return string;
	}
	
	private Node deserialize() {
		if (serialize.length() == 0 || serialize.charAt(0) == '#') {
			if (serialize.charAt(0) == '#') serialize = serialize.substring(1);
			return null;
		}
		
		String value = serialize.substring(0, serialize.indexOf("|"));
		serialize = serialize.substring(serialize.indexOf("|") + 1);
		
		Node node = new Node(Integer.parseInt(value));
		node.left = deserialize();
		node.right = deserialize();
		
		return node;
	}
	
	private String inorderTraversal(Node node, String string) {
		if (node == null) return string;
		
		string = inorderTraversal(node.left, string);
		string += node.value;
		string = inorderTraversal(node.right, string);
		
		return string;
	}

	private void test() {
		String newTree = inorderTraversal(node, new String());
		String oldTree = tree.printTree();
		
		System.out.printf("%s%n", (newTree.equals(oldTree))? "Success!" : "Failed");
	}
}
