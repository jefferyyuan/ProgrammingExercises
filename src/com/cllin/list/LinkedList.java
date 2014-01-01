package com.cllin.list;


public class LinkedList{
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
			next.setPrevious(null);
			size--;
			return;
		}
		
		if(next == null){
			tail = previous;
			previous.setNext(null);
			size--;
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

	public int getSize(){
		return size;
	}
}

class LinkedListNode{
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
