package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given a doubly linked list and an array of references to nodes on the linked list.
 * How many "blocks" are there present in the linked list? 
 * 
 * A "block" is defined as a group of nodes on the list with references directed at them and adjacent to each other. 
 * 
 * Source: http://www.careercup.com/question?id=18880663
 */

public class NumberOfBlocks implements Exercise {

	private TestCase testCase;
	private ArrayList<TestCase> testSuite;
	
	private int nBlocks;
	
	@Override
	public void run() {
		initialize();
		for (TestCase t : testSuite) {
			testCase = t;
			nBlocks = getNumBlocks(t.nodes, t.head);
			test();
		}

	}
	
	private int getNumBlocks(Node[] nodes, Node head) {
		HashSet<Node> set = new HashSet<Node>();
		int count = 0;
		
		for (Node node : nodes) {
			count++;
			
			if (node.previous != null && set.contains(node.previous)) count--;
			set.add(node);
		}
		
		return count;
	}

	private void initialize() {
		testSuite = new ArrayList<TestCase>();
		for (int size = 1; size < 15; size++) {
			testSuite.add(new TestCase(size));
		}
	}
	
	private void test() {
		System.out.print("List = { ");
		Node node = testCase.head;
		while (node != null) {
			System.out.printf("%d ", node.value);
			node = node.next;
		}
		System.out.printf("}%n");
		
		if (testCase.nodes.length == 0) {
			System.out.printf("Block = { }, there is %d block%n", nBlocks);
			System.out.println("------------------------------");
			return;
		}
		
		System.out.print("Block = { ");
		for (int i = 0; i < testCase.nodes.length; i++) {
			System.out.printf("%d ", testCase.nodes[i].value);
		}
		System.out.printf("}, there are %d blocks%n", nBlocks);
		
		System.out.println("------------------------------");
	}
	
	private class TestCase {
		Node head;
		Node[] nodes;
		
		TestCase(int size) {
			Node dummyHead = new Node(-1);
			Node node = dummyHead;
			
			for (int i = 0; i < size; i++) {
				Node next = new Node(i);
				node.next = next;
				next.previous = node;
				
				node = node.next;
			}
			
			dummyHead.next.previous = null;
			
			node = dummyHead.next;
			ArrayList<Node> temp = new ArrayList<Node>();
			for (int i = 0; i < size; i++) {
				if (Math.random() > 0.5) {
					temp.add(node);
				}
				node = node.next;
			}
			
			nodes = new Node[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				nodes[i] = temp.get(i);
			}
			
			head = dummyHead.next;
		}
	}
	
	private class Node {
		Node previous;
		Node next;
		int value;
		
		Node (int value) {
			this.value = value;
			this.previous = null;
			this.next = null;
		}
	}
}
