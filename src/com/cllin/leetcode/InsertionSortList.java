package com.cllin.leetcode;



public class InsertionSortList implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 1000;

	private ListNode head;
	
	@Override
	public void initialize() {
		head = new ListNode((int) (Math.random() * MAXIMUM));
		
		ListNode node = head;
		for (int i = 1; i < SIZE; i++) {
			node.next = new ListNode((int) (Math.random() * MAXIMUM));
			node = node.next;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		head = insertionSortList(head);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
	private ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		else if (head.next == null) return head;
		
		ListNode node = head.next;
		ListNode prev = head;
		
		while (node != null) {
			ListNode next = node.next;
			
			if (prev.val > node.val) {
				ListNode n = head.next;
				ListNode p = head;
				
				if (node.val < p.val) {
//					Case: node.value is the smallest element in this list
					head = node;
					node.next = p;
					prev.next = next;
					
					node = next;
				} else {
					while (n.hashCode() != node.hashCode()) {
						if (p.val <= node.val && node.val < n.val) {
							p.next = node;
							node.next = n;
							prev.next = next;
							
							node = next;
							break;
						}
						p = n;
						n = n.next;
					}
//					Case: node.value is the largest element so far
					if (node != null && n.hashCode() == node.hashCode()) {
						prev = node;
						node = next;
					}
				}
			} else {
				prev = node;
				node = next;
			}
		}
		
		return head;
    }

	@Override
	public boolean test() {
		if (head == null || head.next == null) return true;
		
		ListNode node = head.next;
		ListNode prev = head;
		while (node != null) {
			if (prev.val > node.val) {
				return false;
			}
			
			prev = node;
			node = node.next;
		}
		
		return true;
	}
	
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
