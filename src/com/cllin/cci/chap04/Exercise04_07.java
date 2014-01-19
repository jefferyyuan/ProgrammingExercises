package com.cllin.cci.chap04;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class Exercise04_07 implements Exercise {
	private final int MAXIMUM = 3;
	private final int SIZE_1 = 5;
	private final int SIZE_2 = 0;
	
	private BinarySearchTree tree1;
	private BinarySearchTree tree2;
	
	@Override
	public void runExercise() {
		for(int i = 0; i < 10; i++){
			initialize();
			if(isSubtree(tree1, tree2)){
				System.out.println("T2 is a subtree of T1");
			}else{
				System.out.println("T2 is not a subtree of T1");
			}
		}
	}
	
	private boolean isSubtree(BinarySearchTree tree, BinarySearchTree subTree){
		if (subTree == null) return true;
		return compareNode(tree.root, subTree.root);
	}
	
	private boolean compareNode(Node tree, Node subTree){
		if (tree == null) return false;
		
		if(tree.value == subTree.value){
			if (matchTree(tree, subTree)) return true;
		}
		
		return compareNode(tree.left, subTree) || compareNode(tree.right, subTree);
	}
	
	private boolean matchTree(Node tree, Node subTree){
		if (tree == null && subTree == null) return true;
		if (tree == null || subTree == null) return false;
		if (tree.value != subTree.value) return false;
		
		return matchTree(tree.left, subTree.left) && matchTree(tree.right, subTree.right);
		
	}
	
	private void initialize(){
		tree1 = new BinarySearchTree((int)(Math.random() * MAXIMUM));
		tree2 = new BinarySearchTree((int)(Math.random() * MAXIMUM));
		
		for(int i = 0; i < SIZE_1; i++){
			tree1.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
		
		for(int i = 0; i < SIZE_2; i++){
			tree2.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

}
