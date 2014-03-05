package com.cllin.leetcode;

public class SortList implements LeetCodeExercise {

	private final int SIZE = 5;
	private final int MAXIMUM = 1000;
	
	private ListNode head;
	
	@Override
	public void initialize() {
		head = new ListNode(Integer.MIN_VALUE);
		
		ListNode node = head;
		for (int i = 0; i < SIZE; i++) {
			node.next = new ListNode((int)(Math.random() * MAXIMUM));
			node = node.next;
		}
		
		head = head.next;
	}

	@Override
	public void runExercise() {
		boolean isSuccess = true;
		
		for (int i = 0; i < 100; i++) {
			initialize();
			head = sortList(head);
			
			isSuccess = test();
			if (!isSuccess) {
				System.out.println("Failed");
				break;
			}
		}
		
		if (isSuccess) System.out.println("Success");
		
	}
	
	private ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode first = head;
		ListNode second = head.next.next;
		
		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
		}
		
		ListNode head2 = sortList(first.next);
		first.next = null;
		
		return mergeList(sortList(head), head2);
    }
	
	private ListNode mergeList(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode node = head;
		
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			
			node = node.next;
		}
		
		if (list1 == null) {
			node.next = list2;
		}
		
		if (list2 == null) {
			node.next = list1;
		}
		
		return head.next;
	}

	@Override
	public boolean test() {
		if (head == null) return true;
		
		ListNode prev = head;
		ListNode node = head.next;
		
		while (node != null) {
			if (node.val < prev.val) return false;
			
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
