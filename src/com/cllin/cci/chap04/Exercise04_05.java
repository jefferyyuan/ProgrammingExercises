package com.cllin.cci.chap04;

import java.util.ArrayList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class Exercise04_05 implements Exercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private BinarySearchTree tree;
	private Node node;
	private int[] reference;
	
	@Override
	public void runExercise() {
		
		for(int i = 0; i < 1000; i++){
			initialize();
			Node next = getNextNode(node);
			
			if(!test(next)){
				System.out.println("Failed");
				return;
			}
			
			if (next == null) System.out.printf("The %d does not have a successor%n", node.value);
			else System.out.printf("The next value of %d is %d%n", node.value, next.value);
		}
		System.out.println("Success");
	}
	
	private Node getNextNode(Node node){
		if (node == null) return null;
		
		if(node.right != null){
			return getLeftMostChild(node.right);
		}else{
			if (node.parent == null) return getLeftMostChild(node.right);
			
			if (node.parent.left != null &&
					node.hashCode() == node.parent.left.hashCode()){
				return node.parent;
			}else{
				Node rtn = node;
				while(rtn.parent != null){
					if(rtn.parent.left != null && rtn.hashCode() == rtn.parent.left.hashCode()){
						return rtn.parent;
					}
					
					rtn = rtn.parent;
				}
				
				return null;
			}
		}
	}
	
	private Node getLeftMostChild(Node root){
		if (root == null) return null;
		
		Node rtn = root;
		while(rtn.left != null){
			rtn = rtn.left;
		}
		return rtn;
	}
	
	private boolean test(Node result){
		ArrayList<Node> sorted = inOrderTreeWalk(tree.root);
		int size = sorted.size();
		
		for(int i = 0; i < size; i++){
			if(sorted.get(i).hashCode() == node.hashCode()){
				
				if (i == size - 1) return (result == null)? true : false;
				
				if(sorted.get(i + 1).hashCode() == result.hashCode()){
					return true;
				}else{
					return false;
				}
			}
		}
		
		return false;
	}
	
	private ArrayList<Node> inOrderTreeWalk(Node node){
		ArrayList<Node> rtn = new ArrayList<Node>();
		if(node != null){
			rtn.addAll(inOrderTreeWalk(node.left));
			rtn.add(node);
			rtn.addAll(inOrderTreeWalk(node.right));
		}
		return rtn;
		
	}
	
	private void initialize(){
		reference = new int[SIZE];
		tree = new BinarySearchTree();
		
		int index = (int)(Math.random() * SIZE);
		
		for(int i = 0; i < SIZE; i++){
			Node node = new Node((int)(Math.random() * MAXIMUM), null, null, null);
			if (i == index) this.node = node; 
			
			tree.insert(node);
			reference[i] = node.value;
		}
	}

}
