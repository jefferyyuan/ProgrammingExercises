package com.cllin.cci.chap04;

import java.util.ArrayList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree and a target value, design an algorithm to print all paths which sum up to that value.
 * Note that it can be any path in the tree - it does not have to start at the root.
 */

public class Exercise04_08 implements Exercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 1000;
	
	private BinarySearchTree tree;

	@Override
	public void run() {
		initialize();
		
		for (int n = 10; n < 30; n++) {
			findPath(tree.root, n, new ArrayList<Integer>());
		}
		
		System.out.println("All paths are found");
	}
	
	private void findPath(Node node, int sum, ArrayList<Integer> path) {
		if (node == null) return;
		
		path.add(node.value);

		int tmp = sum;
		int end = path.size() - 1;
		int start = end;
		
		for (int i = start; i >= 0; i--) {
			tmp -= path.get(i);
			
			if (tmp == 0) {
				start = i;
				printPath(sum, start, end, path);
			}
		}
		
		findPath(node.right, sum, new ArrayList<Integer>(path));
		findPath(node.left, sum, new ArrayList<Integer>(path));
	}
	
	private void printPath(int sum, int start, int end, ArrayList<Integer> path) {
		for (int i = start; i <= end; i++) {
			System.out.printf("%d -> ", path.get(i));
		}
		
		System.out.printf(", sum = %d%n", sum);
	}

	private void initialize() {
		tree = new BinarySearchTree(SIZE, MAXIMUM);
	}

}
