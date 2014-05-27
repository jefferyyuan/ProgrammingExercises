package com.cllin.cci.chap02;

import java.util.Stack;

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
	
	@Override
	public void runExercise() {
		initialize();
		
		int output = add(listA, listB);
		if (referenceA + referenceB != output) {
			System.out.println("Failed");
			return;
		}
		
		System.out.println("Success!");
	}
	
	private int add(Node listA, Node listB) {
		int count = 1;
		Stack<Integer> sum = new Stack<Integer>();
		Node nodeA = listA;
		Node nodeB = listB;
		
		while (nodeA != null || nodeB != null) {
			if (nodeA == null && nodeB != null) {
				sum.push(nodeB.value);
				nodeB = nodeB.next;
			} else if (nodeB == null && nodeA != null) {
				sum.push(nodeA.value);
				nodeA = nodeA.next;
			} else {
				sum.push(nodeA.value + nodeB.value);
				nodeA = nodeA.next;
				nodeB = nodeB.next;
			}
			count *= 10;
		}
		
		count /= 10;
		
		int output = 0;
		while (!sum.isEmpty()) {
			output += sum.pop() * count;
			count /= 10;
		}
		
		return output;
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
	
	private class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
}
