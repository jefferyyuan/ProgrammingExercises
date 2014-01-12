package com.cllin.list;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LinkedList<T>{
	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;
	private int size = 0;
	
	public LinkedList(T contentOfHead){
		head = new LinkedListNode<T>(contentOfHead);
		tail = head;
		size++;
	}
	
	public void addNode(T content){
		LinkedListNode<T> afterThisNode = this.tail;
		LinkedListNode<T> node = new LinkedListNode(afterThisNode, content);
		
		afterThisNode.setNext(node);
		this.tail = node;
		
		size++;
	}
	
	public void addNode(LinkedListNode<T> afterThisNode, T content){
		LinkedListNode<T> beforeThisNode = afterThisNode.getNext();
		LinkedListNode<T> node = new LinkedListNode(afterThisNode, content);
		
		afterThisNode.setNext(node);
		if(beforeThisNode == null){
			tail = node;
		}else{
			beforeThisNode.setPrevious(node);
		}
		
		size++;
	}
	
	public void addNode(LinkedListNode<T> afterThisNode, LinkedListNode<T> addThisNode){
		LinkedListNode<T> beforeThisNode = afterThisNode.getNext();
		
		afterThisNode.setNext(addThisNode);
		if(beforeThisNode == null){
			tail = addThisNode;
		}else{
			beforeThisNode.setPrevious(addThisNode);
		}
		
		size++;
	}
	
	public LinkedListNode<T> getNode(T content){
		if(size == 0){
			return null;
		}
		
		LinkedListNode<T> node = head;
		while(node != null){
			if(node.getContent().equals(content)){
				return node;
			} 
			node = node.getNext();
		}
		return node;
	}
	

	public LinkedListNode<T> getNode(int index){
		LinkedListNode<T> node = head;
		if (node == null) return null;
		
		int i = 0;
		while(i < index){
			if (node == null) return null;
			node = node.getNext();
			i++;
		}
		return node;
	}
	
	public void deleteNode(LinkedListNode<T> deleteThisNode){
		LinkedListNode<T> previous = deleteThisNode.getPrevious();
		LinkedListNode<T> next = deleteThisNode.getNext();
		
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

	public LinkedListNode<T> getHead(){
		return head;
	}
	
	public LinkedListNode<T> getTail(){
		return tail;
	}
	
	public void resetSize(){
		int i = 0;
		
		if (this.head == null) i = 0;

		LinkedListNode<T> node = this.head;
		while(node != null){
			node = node.getNext();
			i++;
		}
		
		this.size = i;
	}

	public int getSize(){
		return size;
	}
}