package com.cllin.chap02;

import com.cllin.list.LinkedList;
import com.cllin.list.LinkedListNode;
import com.cllin.main.Exercise;

public class Exercise02_02 implements Exercise {
	private final int SIZE = 1000 - 1;
	private final int MAXIMUM = 1000;
	private final int[] testSuite = {20, 50, 100, 800, 556, 183, 999, 1000};
	
	private LinkedList<Integer> list;
	
	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private LinkedListNode<Integer> getNToLast(int n){
		if (list.getHead() == null) return null;
		
		LinkedListNode<Integer> node1 = list.getHead();
		LinkedListNode<Integer> node2 = list.getHead();
		
		int count = 1;
		while(count < n){
			if (node2 == null) return null;
			
			node2 = node2.getNext();
			count++;
		}
		
		while(node2.getNext() != null){
			node1 = node1.getNext();
			node2 = node2.getNext();
		}
		
		return node1;
	}
	
	private void test(){
		for(int n : testSuite){
			LinkedListNode<Integer> result = getNToLast(n);
			LinkedListNode<Integer> reference = list.getNode(list.getSize() - n);
			
			if(result.hashCode() != reference.hashCode()){
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("Success!");
	}
	
	private void initialize(){
		int a = (int)(Math.random() * MAXIMUM);
		list = new LinkedList<Integer>(a);
		
		for(int i = 0; i < SIZE; i++){
			list.addNode((int)(Math.random() * MAXIMUM));
		}
	}

}
