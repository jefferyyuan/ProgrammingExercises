package com.cllin.cci.chap02;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * 
 * Definition of Circular linked list:
 * 		A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
 * 
 * For example,
 * 		Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * 		Output: C
 */

public class Exercise02_05 implements Exercise {
	private final int SIZE = 3;
	private final int MAXIMUM = 1000;
	private final int CYCLE_BEGINNING = 2;
	
	private LinkedList<TestCase> testSuite;

	@Override
	public void runExercise() {
		initialize();
		
		for (TestCase test : testSuite) {
			Node result = getBeginning(test.list);
			
			System.out.printf("%s%n", (result == test.beginning)? "Success!" : "Failed");
		}
	}
	
	private Node getBeginning(Node head) {
    	Node a = head;
    	Node b = head;
    	
    	while (a != null && b != null) {
    		if (a.next == null) return null;

    		a = a.next.next;
    		b = b.next;
    		
    		if (a == null) return null;
    		if (a.hashCode() != b.hashCode()) break;
    	}
    	
    	a = head;
    	while (a != null && b != null) {
    		if (a.hashCode() == b.hashCode()) return a;
    		
    		a = a.next;
    		b = b.next;
    	}
    	
        return null;
	}
	
	public void initialize() {
		testSuite = new LinkedList<TestCase>();
		
//		Case 1: No cycle
		Node dummyA = new Node(-1);
		Node nodeA = dummyA;
		for (int i = 0; i < SIZE; i++) {
			nodeA.next = new Node((int) (Math.random() * MAXIMUM));
			nodeA = nodeA.next;
		}
		testSuite.add(new TestCase(dummyA.next, null));
		
//		Case 2: Cycle
		Node dummyB = new Node(-1);
		Node nodeB = dummyB;
		Node cycleBeginning = null;
		for (int i = 0; i < SIZE; i++) {
			nodeB.next = new Node((int) (Math.random() * MAXIMUM));
			nodeB = nodeB.next;
			
			if (i == CYCLE_BEGINNING) cycleBeginning = nodeB;
		}
		nodeB.next = cycleBeginning;
		testSuite.add(new TestCase(dummyB.next, cycleBeginning));
	}
	
	@SuppressWarnings("unused")
	private class Node {
		int val;
		Node next;
		Node(int x) {
			val = x;
			next = null;
		}
	}
	
	private class TestCase {
		Node list;
		Node beginning;
		
		TestCase (Node list, Node beginning) {
			this.list = list;
			this.beginning = beginning;
		}
	}
}
