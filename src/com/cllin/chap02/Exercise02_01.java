package com.cllin.chap02;

import com.cllin.list.LinkedList;
import com.cllin.list.LinkedListNode;
import com.cllin.main.Exercise;

public class Exercise02_01 implements Exercise {
	private final int SIZE = 10 - 1;
	private final int MAXIMUM = 10;
	
	private LinkedList<Integer> list;
	
	@Override
	public void runExercise() {
		initialize();
		removeDuplicate();
		test();
	}
	
	private void removeDuplicate(){
		LinkedListNode<Integer> node = list.getHead();
		
		while(node != null){
			LinkedListNode<Integer> iterator = list.getHead();
			
			while(iterator != null && iterator.hashCode() != node.hashCode()){
				if((int)iterator.getContent() == (int)node.getContent() 
						&& iterator.hashCode() != node.hashCode()){
					list.deleteNode(node);
				}
				iterator = iterator.getNext();
			}
			node = node.getNext();
		}
		
	}
	
	private void test(){
		LinkedListNode<Integer> node = list.getHead();
		while(node != null){
			int value = node.getContent();
			
			if(list.getNode(new Integer(value)).hashCode() != node.hashCode()){
				System.out.println("Failed");
				return;
			}
			
			node = node.getNext();
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
