package com.cllin.leetcode;

public class BinaryTreeMaximumPathSum implements LeetCodeExercise {

	private TreeNode[] testSuite = {
			new TreeNode(1),
			new TreeNode(-1),
			new TreeNode(-1),
			new TreeNode(1),
	};
	
	@Override
	public void initialize() {
//		CASE 0: SINGLE NODE TREE
		
//		CASE 1:
		testSuite[1].left = new TreeNode(1);
		
//		CASE 2:
		testSuite[2].left = new TreeNode(3);
		testSuite[2].right = new TreeNode(3);
		
//		CASE 3:
		TreeNode l1 = new TreeNode(-2);
		l1.left = new TreeNode(1);
		l1.right = new TreeNode(3);
		
		TreeNode r1 = new TreeNode(-3);
		r1.left = new TreeNode(-2);
		
		testSuite[3].left = l1;
		testSuite[3].right = r1;
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (TreeNode root : testSuite) {
			int maxPathSum = maxPathSum(root);
			System.out.printf("The maximum path sum is %d%n", maxPathSum);
		}
	}
	
	private int maxPathSum(TreeNode root) {
		if (root == null) return 0;

		int[] max = new int[]{Integer.MIN_VALUE};
		traverse(root, max);
		return max[0];
    }
	
	private int traverse(TreeNode node, int[] globalMaximum) {
		if (node == null) return 0;
		
		int n = node.val;
		int left = traverse(node.left, globalMaximum); 
		int right = traverse(node.right, globalMaximum);
		
		int localMaximum = Math.max(n, Math.max(n + left, n + right));
		globalMaximum[0] = Math.max(globalMaximum[0], Math.max(localMaximum, n + left + right));
		
		return localMaximum;
	}

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
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
