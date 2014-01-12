package com.cllin.list;

import com.cllin.main.Exercise;

public class LinkedListExercise implements Exercise {

	@Override
	public void runExercise() {
		LinkedList<String> list = new LinkedList<String>(Integer.toString(0));
		
		for(int i = 1; i < 30; i++){
			list.addNode(list.getNode(Integer.toString(i - 1)), Integer.toString(i));
		}
		
		for(int i = 0; i < 30; i++){
			if(i % 3 == 1){
				list.deleteNode(list.getNode(Integer.toString(i)));
			}
		}
		
		LinkedListNode<String> node = list.getHead();
		while(node != null){
			System.out.println("content = " + node.getContent());
			node = node.getNext();
		}
		
		System.out.println("******");
		
		while(node != null){
			System.out.println("content = " + node.getContent());
			node = node.getPrevious();
		}
		
		System.out.println("******");
		
		node = list.getHead();
		System.out.println("head = " + node.getContent());
		if(node.getPrevious() == null){
			System.out.println("head.prev = null, as expected");
		}else{
			System.out.println("head.prev != null, failed");
		}
		System.out.println("head.next = " + node.getNext().getContent());
		list.deleteNode(node);
		node = list.getHead();
		System.out.println("after deleting the old head, new head = " + node.getContent());
		
		System.out.println("******");
		
		node = list.getTail();
		System.out.println("tail = " + node.getContent());
		if(node.getNext() == null){
			System.out.println("tail.next = null, as expected");
		}else{
			System.out.println("head.next != null, failed");
		}
		System.out.println("tail.prev = " + node.getPrevious().getContent());
		list.deleteNode(node);
		node = list.getTail();
		System.out.println("after deleting the old tail, new tail = " + node.getContent());

		
	}
}
