package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal implements
		LeetCodeExercise {

	private final int SIZE = 4;
	
	private BinarySearchTree tree;
	private Node root;
	
	private int[] inorder;
	private int[] preorder;
	
	@Override
	public void initialize() {
		int[] numbers = new int[SIZE];
		for (int i = 0; i < SIZE; i++) numbers[i] = i + 1;
		
		tree = new BinarySearchTree();
		tree.buildTree(numbers);
		
		inorder = new int[SIZE];
		preorder = new int[SIZE];
		
		ArrayList<Integer> inorderReference = inorderTraversal(tree.root);
		ArrayList<Integer> postorderReference = preorderTraversal(tree.root);
		
		for (int i = 0; i < SIZE; i++) {
			inorder[i] = inorderReference.get(i);
			preorder[i] = postorderReference.get(i);
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		inorder = new int[]{1, 2, 3, 4};
		preorder = new int[]{1, 4, 2, 3};
		
		root = buildTree(preorder, inorder);

		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
	private Node buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || preorder == null) return null;
		
		if (inorder.length != preorder.length) return null;
		else if (inorder.length == 0) return null;
		
		int length = inorder.length;
		int rootValue = preorder[0];
		
		Node root = new Node(rootValue);
		int rootIndex = -1;
		for (int i = 0; i < length; i++) {
			if (inorder[i] == rootValue) {
				rootIndex = i;
				break;
			}
		}
		
		int[] leftInorder = new int[rootIndex];
		int[] leftPreorder = new int[rootIndex];
		for (int i = 0; i < rootIndex; i++) {
			leftInorder[i] = inorder[i];
			leftPreorder[i] = preorder[i + 1];
		}
		
		int[] rightInorder = new int[length - rootIndex - 1];
		int[] rightPreorder = new int[length - rootIndex - 1];
		for (int i = 0; i < length - rootIndex - 1; i++) {
			rightInorder[i] = inorder[i + rootIndex + 1];
			rightPreorder[i] = preorder[i + rootIndex + 1];
		}
		
		root.left = buildTree(leftPreorder, leftInorder);
		root.right = buildTree(rightPreorder, rightInorder);
		
		return root;
    }
	
    private ArrayList<Integer> preorderTraversal(Node root) {
    	ArrayList<Integer> rtn = new ArrayList<Integer>();
    	
    	if (root == null) return rtn;
    	
    	rtn.add(root.value);
    	rtn.addAll(preorderTraversal(root.left));
    	rtn.addAll(preorderTraversal(root.right));
    	
    	return rtn;
    }
	
    private ArrayList<Integer> inorderTraversal(Node root) {
    	ArrayList<Integer> rtn = new ArrayList<Integer>();
    	
    	if (root == null) return rtn;
    	
    	rtn.addAll(inorderTraversal(root.left));
    	rtn.add(root.value);
    	rtn.addAll(inorderTraversal(root.right));
    	
    	return rtn;
    }

	@Override
	public boolean test() {
		ArrayList<Integer> reference;
		int size;
		
		reference = inorderTraversal(root);
		size = reference.size();
		if (inorder.length != size) return false;
		
		for (int i = 0; i < size; i++) {
			if (inorder[i] != reference.get(i)) return false;
		}
		
		reference = preorderTraversal(root);
		size = reference.size();
		if (preorder.length != size) return false;
		
		for (int i = 0; i < size; i++) {
			if (preorder[i] != reference.get(i)) return false;
		}
		
		return true;	}

}