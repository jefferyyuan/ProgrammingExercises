package com.cllin.chap02;

import java.util.ArrayList;

import com.cllin.list.LinkedList;
import com.cllin.list.LinkedListNode;
import com.cllin.main.Exercise;

public class Exercise02_05 implements Exercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;
	
	private LinkedList<Integer> list;
	LinkedListNode<Integer> beginning = new LinkedListNode<Integer>(0);

	@Override
	public void runExercise() {
		initialize();
		
		LinkedListNode<Integer> result = getBeginning();
		
		if(result.hashCode() != beginning.hashCode()){
			System.out.println("Failed");
			return;
		}
		System.out.println("Success!");
	}
	
	private LinkedListNode<Integer> getBeginning(){
		LinkedListNode<Integer> node = list.getHead();
		ArrayList<LinkedListNode<Integer>> visited = new ArrayList<LinkedListNode<Integer>>();
		
		while(node != null){
			if (visited.contains(node)) return node;
			
			visited.add(node);
			node = node.getNext();
		}
		
		return node;
	}
	
	private void initialize(){
		list = new LinkedList<Integer>(-1);
		LinkedListNode<Integer> node = list.getHead();
		
		for(int i = 0; i < SIZE; i++){
			list.addNode(node, (int)(Math.random() * MAXIMUM));
			node = list.getTail();
		}
		
		list.addNode(node, beginning);
		node = list.getTail();
		
		for(int i = 0; i < SIZE; i++){
			list.addNode(node, (int)(Math.random() * MAXIMUM));
			node = list.getTail();
		}
		
		list.addNode(list.getTail(), beginning);
	}

}
