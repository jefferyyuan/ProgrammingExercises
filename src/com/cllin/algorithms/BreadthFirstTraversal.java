package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BreadthFirstTraversal implements Exercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	
	private BinarySearchTree tree;
	
	@Override
	public void run() {
		initialize();
		breadFirstTraversal(tree.root);
		
		System.out.println("Finish");
	}
	
	private void breadFirstTraversal(Node node) {
		if (node == null) return;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Node> next = new LinkedList<Node>();
		queue.add(node);
		
		
		while (!queue.isEmpty()) {
			Node n = queue.pollFirst();
			if (n.left != null) next.add(n.left);
			if (n.right != null) next.add(n.right);
			
			System.out.printf("%d ", n.value);
			if (queue.isEmpty()) {
				queue = next;
				next = new LinkedList<Node>();
				System.out.println();
			}
		}
	}
	
	private void initialize(){
		buildTree();
	}
	
	private void buildTree(){
		tree = new BinarySearchTree();
		
		for (int i = 0; i < SIZE; i++) {
			tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

}
