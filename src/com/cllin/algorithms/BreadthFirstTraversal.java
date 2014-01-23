package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BreadthFirstTraversal implements Exercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	
	private BinarySearchTree tree;
	private LinkedList<Node> queue;
	
	@Override
	public void runExercise() {
		initialize();
		breadFirstTraversal(tree.root);
		
		System.out.println("Finish");
	}
	
	private void breadFirstTraversal(Node node) {
		if (node == null) return;
		
		queue.add(node);
		
		while (queue.size() > 0) {
			Node n = queue.pollFirst();
			
			if (n.left != null) queue.add(n.left);
			if (n.right != null) queue.add(n.right);
			
			boolean hasSiblings = false;
			for (Node a : queue) {
				if (tree.getLevel(a) == tree.getLevel(n)) {
					hasSiblings = true;
					break;
				}
			}
			
			System.out.printf("%d ", n.value);
			if (!hasSiblings) System.out.println();
		}
	}
	
	private void initialize(){
		buildTree();
		queue = new LinkedList<Node>();
	}
	
	private void buildTree(){
		tree = new BinarySearchTree();
		
		for (int i = 0; i < SIZE; i++) {
			tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

}
