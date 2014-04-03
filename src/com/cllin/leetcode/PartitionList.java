package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Source: http://oj.leetcode.com/problems/partition-list/
 */

public class PartitionList implements LeetCodeExercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10;

	private ListNode head;
	private int target;
	
	@Override
	public void initialize() {
		head = new ListNode((int) (Math.random() * MAXIMUM));
		target = (int) (Math.random() * MAXIMUM);
		
		ListNode node = head;
		for (int i = 1; i < SIZE; i++) {
			node.next = new ListNode((int) (Math.random() * MAXIMUM));
			node = node.next;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		head = partition(head, target);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}

	private ListNode partition(ListNode head, int x) {
		if (head == null) return head;
		
		ListNode less = null;
		ListNode lessHead = null;
		ListNode greater = null;
		ListNode greaterHead = null;
		ListNode node = head;
		
		while (node != null) {
			if (node.val < x) {
				if (lessHead == null) {
					lessHead = node;
					less = lessHead;
				} else {
					less.next = node;
					less = less.next;
				}
			} else {
				if (greaterHead == null) {
					greaterHead = node;
					greater = greaterHead;
				} else {
					greater.next = node;
					greater = greater.next;
				}
			}
			node = node.next;
		}
		
		if (greater != null) greater.next = null;
		
		if (less == null) head = greaterHead;
		else {
			less.next = greaterHead;
			head = lessHead;
		}
		
    	return head;
	}
	
	@Override
	public boolean test() {
		boolean lessIsDone = false;
		ListNode node = head;
		while (node != null) {
			if (node.val < target) {
				if (lessIsDone) return false;
				lessIsDone = false;
			} else if (!lessIsDone) lessIsDone = true;
			
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
