package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class MaximumDepthOfBinaryTree implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 100;
	
	private BinarySearchTree tree;

	@Override
	public void initialize() {
		tree = new BinarySearchTree();
		
		for(int i = 0; i < SIZE; i++){
			tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		int maxDepth = getMaxDepth();
		System.out.printf("The maximum depth of the tree is %d", maxDepth);
	}
	
	private int getMaxDepth(){
		if (tree == null || tree.root == null) return 0;
		return getDepth(tree.root, 1);
	}
	
	private int getDepth(Node node, int depth){
		int left = 0;
		int right = 0;
		
		if (node.left != null) left = getDepth(node.left, depth + 1);
		if (node.right != null) right = getDepth(node.right, depth + 1);
		
		return max(depth, left, right);
	}
	
    private int max(int a, int b, int c){
        int max = -1;
        if (a > max) max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        
        return max;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
