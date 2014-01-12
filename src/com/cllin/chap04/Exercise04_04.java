package com.cllin.chap04;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.main.Exercise;

public class Exercise04_04 implements Exercise {
	private ArrayList<LinkedList<Node>> lists;
	
	@Override
	public void runExercise() {
		lists = new ArrayList<LinkedList<Node>>();

	}
	
	@SuppressWarnings("unused")
	private void inOrderWalk(Node node, int depth){
		if (node == null) return;
		
		inOrderWalk(node.getLeftNode(), depth + 1);
		
		if (lists.get(depth) == null) lists.add(depth, new LinkedList<Node>());
		lists.get(depth).add(node);
		
		inOrderWalk(node.getRightChild(), depth + 1);
	}

}
