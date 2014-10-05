package com.cllin.cci.chap02;

import com.cllin.main.Exercise;

/*
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 * 
 * Write a function that adds the two numbers and returns the sum as a linked-list.
 * 
 * For example:
 * 		Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * 		Output: 8 -> 0 -> 8
 */

public class Exercise02_04 implements Exercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 10;
	
	private Node listA;
	private Node listB;
	private int referenceA = 0;
	private int referenceB = 0;
	
	private Node output;
	
	@Override
	public void run() {
		initialize();
		
		output = add(listA, listB);
		System.out.printf("%s%n", (test())? "Success!" : "Failed");
	}
	
	private Node add(Node listA, Node listB) {
    	Node n1 = listA;
    	Node n2 = listB;

    	Node dummyHead = new Node(-1);
    	Node node = dummyHead;
    	
    	int sum = 0;
    	boolean addOne = false;
    	while (n1 != null && n2 != null) {
    		sum = n1.value + n2.value;
    		sum = (addOne)? sum + 1 : sum;
    		
    		node.next = new Node(sum % 10);
    		addOne = (sum >= 10);
    		
    		node = node.next;
    		n1 = n1.next;
    		n2 = n2.next;
    	}
    	
    	Node remain = (n1 == null)? n2 : n1;
    	while (remain != null) {
			sum = remain.value;
			sum = (addOne)? sum + 1 : sum;
			
			node.next = new Node(sum % 10);
			addOne = (sum >= 10);
			
			node = node.next;
    		
    		remain = remain.next;
    	}
    	
    	if (addOne) {
    		node.next = new Node(1);
    	}
    	
    	return dummyHead.next;
	}
	
	private void initialize() {
		Node dummyA = new Node(-1);
		Node dummyB = new Node(-1);
		Node nodeA  = dummyA;
		Node nodeB  = dummyB;
		
		int count = 1;
		for (int i = 0; i < SIZE; i++) {
			int a = (int) (Math.random() * MAXIMUM);
			int b = (int) (Math.random() * MAXIMUM);
			
			referenceA += a * count;
			referenceB += b * count;
			count *= 10;
			
			nodeA.next = new Node(a);
			nodeB.next = new Node(b);
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		
		listA = dummyA.next;
		listB = dummyB.next;
	}
	
	private boolean test() {
		int solution = 0;
		int power = 1;
		Node node = output;
		
		while (node != null) {
			solution += node.value * power;
			
			power *= 10;
			node = node.next;
		}
		
		return (solution == referenceA + referenceB);
	}
	
	private class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
}
