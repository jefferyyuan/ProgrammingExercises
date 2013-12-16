package com.cllin.list;

import com.cllin.main.Exercise;

public class LinkedListExercise implements Exercise {

	@Override
	public void runExercise() {
		LinkedList list = new LinkedList(Integer.toString(0));
		
		for(int i = 1; i < 30; i++){
			list.addNode(list.getNode(Integer.toString(i - 1)), Integer.toString(i));
		}
		
		for(int i = 0; i < 30; i++){
			if(i % 3 == 1){
				list.deleteNode(list.getNode(Integer.toString(i)));
			}
		}
		
		LinkedListNode node = list.getHead();
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
	
	private class LinkedList{
		private LinkedListNode head;
		private LinkedListNode tail;
		private int size = 0;
		
		public LinkedList(String contentOfHead){
			head = new LinkedListNode(contentOfHead);
			tail = head;
			size++;
		}
		
		public void addNode(LinkedListNode afterThisNode, String content){
			LinkedListNode beforeThisNode = afterThisNode.getNext();
			LinkedListNode node = new LinkedListNode(afterThisNode, content);
			
			afterThisNode.setNext(node);
			if(beforeThisNode == null){
				tail = node;
			}else{
				beforeThisNode.setPrevious(node);
			}
			
			size++;
		}
		
		public LinkedListNode getNode(String content){
			if(size == 0){
				return null;
			}
			
			LinkedListNode node = head;
			while(node != null){
				if(node.getContent().equals(content)){
					return node;
				} 
				node = node.getNext();
			}
			return node;
		}
		
		public void deleteNode(LinkedListNode deleteThisNode){
			LinkedListNode previous = deleteThisNode.getPrevious();
			LinkedListNode next = deleteThisNode.getNext();
			
			if(previous == null){
				head = next;
				return;
			}
			
			if(next == null){
				tail = previous;
				return;
			}
			
			previous.setNext(next);
			next.setPrevious(previous);
			
			size--;
		}

		public LinkedListNode getHead(){
			return head;
		}
		
		public LinkedListNode getTail(){
			return tail;
		}

	}
	
	private class LinkedListNode{
		private LinkedListNode previous;
		private LinkedListNode next;
		private String content;
		
		public LinkedListNode(String content){
			previous = null;
			next = null;
			this.content = content;			
		}
		
		public LinkedListNode(LinkedListNode prev, String content){
			previous = prev;
			next = null;
			this.content = content;
		}
		
		public void setNext(LinkedListNode next){
			this.next = next;
		}
		
		public void setPrevious(LinkedListNode previous){
			this.previous = previous;
		}
		
		public LinkedListNode getPrevious(){
			return previous;
		}
		
		public LinkedListNode getNext(){
			return next;
		}
		
		public String getContent(){
			return content;
		}
	}

}
