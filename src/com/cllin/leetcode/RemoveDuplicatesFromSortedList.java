package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class RemoveDuplicatesFromSortedList implements LeetCodeExercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private int[] integers;
	private ListNode root;
	
	@Override
	public void initialize() {
		integers = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			integers[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(integers);
		
		root = new ListNode(integers[0]);
		ListNode node = root;
		for (int i = 1; i < SIZE; i++) {
			node.next = new ListNode(integers[i]);
			node = node.next;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		deleteDuplicates(root);
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
	private ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		
		ListNode last = head;
		ListNode node = head.next;
		
		while (node != null) {
			if (node.val == last.val) {
				last.next = node.next;
			} else {
				last = node;
			}
			node = node.next;
		}
		
        return head;
    }

	@Override
	public boolean test() {
		ListNode node = root;
		while (node != null) {
			
			ListNode previous = root;
			while (previous != null && previous.hashCode() != node.hashCode()) {
				if (previous.val == node.val) return false;
				previous = previous.next;
			}
			
			node = node.next;
		}
		return true;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
