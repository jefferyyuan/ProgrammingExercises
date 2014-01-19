package com.cllin.chap04;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class Exercise04_04 implements Exercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 5;
	
	private BinarySearchTree tree;
	private ArrayList<LinkedList<Node>> nodes;
	
	@Override
	public void runExercise() {
		initialize();
		getNodeByLevel();
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");
	}
	
	private void getNodeByLevel(){
//		TODO
	}
	
	private boolean test(){
//		TODO
		return true;
	}
	
	private void initialize(){
		tree = new BinarySearchTree();
		nodes = new ArrayList<LinkedList<Node>>(20);
		
		for(int i = 0; i < SIZE; i++){
			tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
		}
	}

}
