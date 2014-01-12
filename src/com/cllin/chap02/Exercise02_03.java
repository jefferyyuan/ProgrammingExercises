package com.cllin.chap02;

import java.util.ArrayList;

import com.cllin.list.LinkedList;
import com.cllin.list.LinkedListNode;
import com.cllin.main.Exercise;

public class Exercise02_03 implements Exercise {
	private final int SIZE = 1000 - 1;
	private final int MAXIMUM = 1000;
	
	private LinkedList<Integer> list;
	private ArrayList<Integer> reference;

	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private boolean remove(int n){
		if (list.getNode(n) == null || list.getNode(n + 1) == null) return false;
		
		LinkedListNode<Integer> next = list.getNode(n).getNext();
		list.getNode(n).setContent(next.getContent());
		list.getNode(n).setNext(next.getNext());
		
//		Just changed the size externally, need to recalculate the size of the list 
		list.resetSize();
		
		return true;
	}
	
	private void test(){
		for(int i = 0; i < 100; i++){
			int index = (int)(Math.random() * SIZE / 2);
			remove(index);
			reference.remove(index);
		}
		
		if(list.getSize() != reference.size()){
			System.out.println("Failed");
			return;
		}
		
		int size = list.getSize();
		for(int i = 0; i < size; i++){
			if((int)list.getNode(i).getContent() != (int)reference.get(i)){
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("Success!");
	}
	
	private void initialize(){
		int a = (int)(Math.random() * MAXIMUM);
		list = new LinkedList<Integer>(a);
		reference = new ArrayList<Integer>();
		reference.add(a);
		
		for(int i = 0; i < SIZE; i++){
			a = (int)(Math.random() * MAXIMUM);
			list.addNode(a);
			reference.add(a);
		}
	}

}
