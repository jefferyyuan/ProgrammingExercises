package com.cllin.leetcode;

import java.util.ArrayList;

public class ValidateBinarySearchTree implements LeetCodeExercise {
	private TreeNode[] testSuite = {
			null,
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10),
			new TreeNode(10)
	};
	
	private boolean[] solution = {
			true,
			true,
			true,
			false,
			false,
			false
	};

	@Override
	public void initialize() {
//		Case 0: null tree
		
//		Case 1: Valid BST
		testSuite[1].left = new TreeNode(5);
		testSuite[1].right = new TreeNode(10);
		
//		Case 2: Tree with one node
			
//		Case 3: One element from the left subtree is larger than the root
		TreeNode left = new TreeNode(5);
		left.left = new TreeNode(2);
		left.right = new TreeNode(20);
		
		testSuite[3].left = left;
		
//		Case 4: One element from the right subtree is less than the root
		TreeNode right = new TreeNode(15);
		right.left = new TreeNode(2);
		right.right = new TreeNode(20);
		
		testSuite[4].left = right;
		
//		Case 5: Duplicate values
		testSuite[5].left = new TreeNode(10);
	}

	@Override
	public void runExercise() {
		initialize();
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");
	}
	
	private boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		return (inorderTraversal(root, new ArrayList<Integer>()) != null);
    }

//	Return null if the tree on top of this node is not a valid BST
	private ArrayList<Integer> inorderTraversal(TreeNode node, ArrayList<Integer> visited) {
		if (node == null || visited == null) return visited;
		
		visited = inorderTraversal(node.left, visited);
		
		if (visited == null) return visited;
		else {
			int size = visited.size();
			if (size > 0 && visited.get(size - 1) >= node.val) return null;
			
			visited.add(node.val);
		}
		
		return inorderTraversal(node.right, visited);
	}

	@Override
	public boolean test() {
		for (int i = 5; i < testSuite.length; i++) {
			if (isValidBST(testSuite[i]) != solution[i]) {
				return false;
			}
		}
		
		return true;
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x;
		}
	
	}
}
