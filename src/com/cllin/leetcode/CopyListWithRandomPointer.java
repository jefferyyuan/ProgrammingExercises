package com.cllin.leetcode;

import java.util.LinkedList;

public class CopyListWithRandomPointer implements LeetCodeExercise {
	
	private RandomListNode[] testSuite = {
			null,
			new RandomListNode(1),
			new RandomListNode(1),
			new RandomListNode(1),
	};
	
	private int index;
	private RandomListNode newHead;

	@Override
	public void initialize() {
		RandomListNode n1;
		RandomListNode n2;
		RandomListNode n3;
		RandomListNode n4;
		RandomListNode n5;
		
//		CASE 0: null list
		
//		CASE 1
		n1 = testSuite[1];
		n2 = new RandomListNode(2);
		n3 = new RandomListNode(3);
		n4 = new RandomListNode(4);
		n5 = new RandomListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		n1.random = n3;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n2;
		
//		CASE 2: NODE WITH SINGLE ELEMENT
		
//		CASE 3: NODES WITH NULLRANDOM POINTERS
		n1 = testSuite[3];
		n2 = new RandomListNode(2);
		
		n1.next = n2;
		n2.next = null;
		
		n1.random = null;
		n2.random = null;
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			initialize();
			newHead = copyRandomList(testSuite[index]);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		
		RandomListNode node, newNode, originNext;
		RandomListNode dummyNewHead = new RandomListNode(-1);
		
		node = head;
		newNode = dummyNewHead;
		
//		SET THE NEXT OF THE NEW LIST
		while (node != null) {
			newNode.next = new RandomListNode(node.label);
			newNode.next.random = node;
			
			newNode = newNode.next;
			node = node.next;
		}
		
		node = head;
		newNode = dummyNewHead.next;
		while (node != null) {
			originNext = node.next;
			node.next = newNode;
			
			node = originNext;
			newNode = newNode.next;
		}
		
//		SET THE RANDOM OF THE NEW LIST
		newNode = dummyNewHead.next;
		LinkedList<RandomListNode> originNexts = new LinkedList<RandomListNode>();
		while (newNode != null) {
			originNext = (newNode.next == null)? null : newNode.next.random;
			originNexts.add(originNext);
			
			newNode.random = (newNode.random.random == null)?  null : newNode.random.random.next;
			newNode = newNode.next;
		}
		
//		RESTORE THE NEXT OF THE ORIGIN LIST
		node = head;
		while (node != null) {
			node.next = originNexts.poll();
			node = node.next;
		}
		
		
		return dummyNewHead.next;
    }

	@Override
	public boolean test() {
		RandomListNode node = testSuite[index];
		RandomListNode newNode = newHead;
		
		while (node != null) {
			if (node.label != newNode.label) return false;
			
			if ((node.random == null && newNode.random != null) || (node.random != null && newNode.random == null)) return false;
			else if (node.random == null && newNode.random == null) ;	// DO NOTHING
			else if (node.random.label != newNode.random.label) return false;
			
			node = node.next;
			newNode = newNode.next;
		}
		
		return true;
	}

	private class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
		}
	}
}