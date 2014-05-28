package com.cllin.cci.chap02;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to find the n-th to last element of a singly linked list.
 * In another word, find the n-th element from the tail.
 */

public class Exercise02_02 implements Exercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;
	private final int[] testSuite = {20, 50, 100, 800, 556, 183, 999, 1000};
	
	private int n;
	private Node listHead;
	private Node result;
	private LinkedList<Integer> reference;
	
	@Override
	public void runExercise() {
		initialize();
		for (int testCase : testSuite) {
			n = testCase;
			result = getNToLast(listHead, n);
			test();
		}
	}
	
	private Node getNToLast(Node list, int n) {
		if (list == null) return null;
		
		Node node1 = list;
		Node node2 = list;
		
		int count = 1;
		while(count < n){
			if (node2 == null) return null;
			
			node2 = node2.next;
			count++;
		}
		
		while (node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node1;
	}
	
	private void test() {
		System.out.printf("%s%n", (result.value == reference.get(SIZE - n))? "Success!" : "Failed");
	}
	
	private void initialize() {
		reference = new LinkedList<Integer>();
		
		Node dummy = new Node(-1);
		Node node  = dummy;
		
		for (int i = 0; i < SIZE; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			
			reference.add(value);
			node.next = new Node(value);
			node = node.next;
		}
		
		listHead = dummy.next;
	}
	
	private class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}

}
