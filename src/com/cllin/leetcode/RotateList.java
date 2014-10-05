package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1 -> 2 -> 3 -> 4 -> 5 -> NULL and k = 2,
 * return 4 -> 5 -> 1 -> 2 -> 3 -> NULL.
 * 
 * Source: http://oj.leetcode.com/problems/rotate-list/
 */

public class RotateList implements LeetCodeExercise {
	
	private int SIZE = 10;
	
	private int N;
	private ListNode head;
	
	@Override
	public void initialize() {
		head = new ListNode(1);
		
		ListNode node = head;
		for (int i = 2; i <= SIZE; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
	}

	@Override
	public void run() {
		for (N = 0; N <= SIZE * 2; N++) {
			initialize();
			head = rotateRight(head, N);
			test();
		}
	}
	
	private ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) return head;
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode newTail = slow;
		
//		Get the head of the new list
		int count = 0;
		while (fast != null && count < n) {
			fast = fast.next;
			count++;
		}
		
//		If n > list size
		if (fast == null) {
			return rotateRight(head, n % count);
		}
		
		while (fast != null) {
			fast = fast.next;
			newTail = slow;
			slow = slow.next;
		}
		
//		Get the tail of the first half of the new string, append the second half to it
		ListNode node = slow;
		while (node.next != null) {
			node = node.next;
		}
		
		node.next = head;
		newTail.next = null;
		
    	return slow;
    }

	@Override
	public boolean test() {
		System.out.printf("N = %d%n", N);
		
		ListNode node = head;
		while (node != null) {
			System.out.printf("%d -> ", node.val);
			node = node.next;
		}
		System.out.print("NULL\n");
		System.out.println("------------------");
		
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
