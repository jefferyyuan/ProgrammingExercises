package com.cllin.list;

public class LinkedListNode<T>{
	private LinkedListNode<T> previous;
	private LinkedListNode<T> next;
	private T content;
	
	public LinkedListNode(T content){
		previous = null;
		next = null;
		this.content = content;			
	}
	
	public LinkedListNode(LinkedListNode<T> prev, T content){
		previous = prev;
		next = null;
		this.content = content;
	}
	
	public void setNext(LinkedListNode<T> next){
		this.next = next;
	}
	
	public void setPrevious(LinkedListNode<T> previous){
		this.previous = previous;
	}
	
	public LinkedListNode<T> getPrevious(){
		return previous;
	}
	
	public LinkedListNode<T> getNext(){
		return next;
	}
	
	public void setContent(T content){
		this.content = content;
	}
	
	public T getContent(){
		return content;
	}
}
