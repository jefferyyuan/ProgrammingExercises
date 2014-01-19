package com.cllin.cci.chap02;

import java.util.Stack;

import com.cllin.list.LinkedList;
import com.cllin.list.LinkedListNode;
import com.cllin.main.Exercise;

public class Exercise02_04 implements Exercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 10;
	
	private LinkedList<Integer> listA;
	private LinkedList<Integer> listB;
	
	private int referenceA = 0;
	private int referenceB = 0;
	
	@Override
	public void runExercise() {
		initialize();
		
		int output = add();
		if(referenceA + referenceB != output){
			System.out.println("Failed");
			return;
		}
		
		System.out.println("Success!");
	}
	
	private int add(){
		int count = 1;
		Stack<Integer> sum = new Stack<Integer>();
		LinkedListNode<Integer> nodeA = listA.getHead();
		LinkedListNode<Integer> nodeB = listB.getHead();
		
		while(nodeA != null || nodeB != null){
			if(nodeA == null && nodeB != null){
				sum.push(nodeB.getContent());
				nodeB = nodeB.getNext();
			}else if(nodeB == null){
				sum.push(nodeA.getContent());
				nodeA = nodeA.getNext();
			}else{
				sum.push(nodeA.getContent() + nodeB.getContent());
				nodeA = nodeA.getNext();
				nodeB = nodeB.getNext();
			}
			count *= 10;
		}
		count /= 10;
		
		int output = 0;
		while(!sum.isEmpty()){
			output += sum.pop() * count;
			count /= 10;
		}
		
		return output;
	}

	private void initialize(){
		int a = (int)(Math.random() * (MAXIMUM - 1)) + 1;
		int b = (int)(Math.random() * (MAXIMUM - 1)) + 1;
		listA = new LinkedList<Integer>(a);
		listB = new LinkedList<Integer>(b);
		
		int count = 1;
		referenceA += a * count;
		referenceB += b * count;
		count *= 10;
		
		for(int i = 0; i < SIZE; i++){
			a = (int)(Math.random() * (MAXIMUM - 1)) + 1;
			b = (int)(Math.random() * (MAXIMUM - 1)) + 1;
			
			referenceA += a * count;
			referenceB += b * count;
			count *= 10;
			
			listA.addNode(listA.getTail(), a);
			listB.addNode(listB.getTail(), b);
		}
		
	}
	
}
