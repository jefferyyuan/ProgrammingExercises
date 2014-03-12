package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class ReorderList implements LeetCodeExercise {

	private int SIZE = 7;
	private ListNode head;
	
	@Override
	public void initialize() {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode node = dummy;
		
		for (int i = 1; i <= SIZE; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		
		head = dummy.next;
	}

	@Override
	public void runExercise() {
		initialize();
		
		System.out.println("The list before reordering is: ");
		printList(head);
		
		reorderList(head);
		
		System.out.println("The list after reordering is: ");
		printList(head);
		
		System.out.println("------------------");
	}
	
	private void reorderList(ListNode head) {
		if (head == null) return;
		
//		GET THE TOTAL COUNT OF THE LIST
		int count = 1;
		ListNode node = head;
		
		while (node != null) {
			node = node.next;
			count++;
		}
		
//		GET THE END OF THE FIRST HALF OF THE LIST
		int index = 1;
		node = head;
		while (index < count / 2) {
			node = node.next;
			index++;
		}
		index--;
		
		ListNode endOfFirstHalf = node;
		
//		REVERSE THE SECOND HALF OF THE LIST
		node = node.next;
		ListNode prev = null;
		ListNode next = null;
		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		
		endOfFirstHalf.next = null;
		
//		RE-LINK THE LIST ITERATIVELY
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		node = dummyHead;
		ListNode first = head;
		ListNode second = prev;
		while (second != null) {
			node.next = first;
			first = first.next;
			
			node = node.next;
			
			node.next = second;
			second = second.next;
			
			node = node.next;
		}
		
		if (first != null) {
			node.next = first;
			node = node.next;
		}
		
		node.next = null;
		
		head = dummyHead.next;
    }

	private void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.printf("%d -> ", node.val);
			node = node.next;
		}
		System.out.println("NULL");
	}
	
	@Override
	public boolean test() {
		return true;
	}
	
	private	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
