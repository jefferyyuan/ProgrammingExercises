package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Source: http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */

public class SwapNodesInPairs implements LeetCodeExercise {
	private final int SIZE = 100;
	private final int MAXIMUM = 1000;
	
	private ListNode head;
	private int[] reference;
	
	@Override
	public void initialize() {
		reference = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			reference[i] = (int)(Math.random()* MAXIMUM);
		}
		
		Arrays.sort(reference);
		
		head = new ListNode(reference[0]);
		ListNode node = head;
		for (int i = 1; i < SIZE; i++) {
			node.next = new ListNode(reference[i]);
			node = node.next;
		}

	}

	@Override
	public void runExercise() {
		initialize();
		
		head = swapPairs(head);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	ListNode first = head;
    	ListNode second = null;
    	ListNode newHead = head.next;
    	ListNode nextIter = null;
    	ListNode last = null;
    	
    	while (first != null && first.next != null) {
    		nextIter = first.next.next;
    		second = first.next;
    		
    		second.next = first;
    		first.next = nextIter;
    		
    		if (last != null) last.next = second;
    		last = first;
    		first = nextIter;
    	}
    	
        return newHead;
    }

	@Override
	public boolean test() {
		int length = reference.length;
		ListNode node = head;

		int i = 0;
		while (i + 1 < length) {
			if (node.val != reference[i + 1]) return false;
			
			if (node.next != null) node = node.next.next;
			else break;
			
			i += 2;
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
