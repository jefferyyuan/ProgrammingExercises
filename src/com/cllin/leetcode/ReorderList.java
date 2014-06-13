package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a singly linked list L: L0 -> L1 -> ... -> Ln-1 -> Ln,
 * reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Source: http://oj.leetcode.com/problems/reorder-list/
 */

public class ReorderList implements LeetCodeExercise {

	private int SIZE = 4;
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
	
	private static void reorderList(ListNode head) {
		if (head == null) return;
		
//		Get the tail of the first half, and the head of the second half 
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode node = (fast == null)? slow : slow.next;
		ListNode prev = null;
		ListNode next = null;
		
		if (fast != null) slow.next = null;

//		Reverse the second half
		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		
//		Re-link the list
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
	
	private	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
