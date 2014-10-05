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
	public void run() {
		initialize();
		
		head = swapPairs(head);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;

//    	Swap first and second, then connect them with previous and next
    	ListNode first = head;
    	ListNode second = null;
    	ListNode next = null;
    	ListNode previous = null;
    	ListNode newHead = head.next;
    	
    	while (first != null && first.next != null) {
    		next = first.next.next;
    		second = first.next;
    		
    		second.next = first;
    		first.next = next;
    		
    		if (previous != null) previous.next = second;
    		previous = first;
    		first = next;
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
